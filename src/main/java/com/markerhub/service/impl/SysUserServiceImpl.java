package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysMenu;
import com.markerhub.entity.SysRole;
import com.markerhub.entity.SysUser;
import com.markerhub.mapper.SysUserMapper;
import com.markerhub.service.SysMenuService;
import com.markerhub.service.SysRoleService;
import com.markerhub.service.SysUserService;
import com.markerhub.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

	@Resource
	SysRoleService sysRoleService;

	@Resource
	SysUserMapper sysUserMapper;

	@Resource
	SysMenuService sysMenuService;

	@Resource
	RedisUtil redisUtil;

	@Override
	public SysUser getByUsername(String username) {
		return getOne(new QueryWrapper<SysUser>().eq("username", username));
	}

	@Override
	public String getUserAuthorityInfo(Long userId) {

		SysUser sysUser = sysUserMapper.selectById(userId);

		//  ROLE_admin,ROLE_normal,sys:user:list,....
		String authority = "";

		if (redisUtil.hasKey("GrantedAuthority:" + sysUser.getUsername())) {
			authority = (String) redisUtil.get("GrantedAuthority:" + sysUser.getUsername());

		} else {
			// 获取角色编码
			List<SysRole> roles = sysRoleService.list(new QueryWrapper<SysRole>()
					.inSql("id", "select role_id from sys_user_role where user_id = " + userId));

			if (roles.size() > 0) {
				String roleCodes = roles.stream().map(r -> "ROLE_" + r.getCode()).collect(Collectors.joining(","));
				authority = roleCodes.concat(",");
			}

			// 获取菜单操作编码
			List<Long> menuIds = sysUserMapper.getNavMenuIds(userId);
			if (menuIds.size() > 0) {

				List<SysMenu> menus = sysMenuService.listByIds(menuIds);
				String menuPerms = menus.stream().map(m -> m.getPerms()).collect(Collectors.joining(","));

				authority = authority.concat(menuPerms);
			}

			redisUtil.set("GrantedAuthority:" + sysUser.getUsername(), authority, 60 * 60);
		}

		return authority;
	}

	@Override
	public void clearUserAuthorityInfo(String username) {
		redisUtil.del("GrantedAuthority:" + username);
	}

	@Override
	public void clearUserAuthorityInfoByRoleId(Long roleId) {

		List<SysUser> sysUsers = this.list(new QueryWrapper<SysUser>()
				.inSql("id", "select user_id from sys_user_role where role_id = " + roleId));

		sysUsers.forEach(u -> {
			this.clearUserAuthorityInfo(u.getUsername());
		});

	}

	@Override
	public void clearUserAuthorityInfoByMenuId(Long menuId) {
		List<SysUser> sysUsers = sysUserMapper.listByMenuId(menuId);

		sysUsers.forEach(u -> {
			this.clearUserAuthorityInfo(u.getUsername());
		});
	}

	@Override
	public List<SysUser> listUserByUserId(Long userId) {
		List<SysUser> userList=sysUserMapper.listUserById(userId);

		return userList;
	}

	@Override
	public List<SysUser> listUserByTeacherId(Long teacherId) {

		return sysUserMapper.findById(teacherId);
	}

	@Override
	public List<SysUser> listUserByCourseId(Long courseId) {
		List<SysUser> userList=this.list(new QueryWrapper<SysUser>()
				.inSql("id","select teacher_id from teacher_course where course_id="+courseId));

		return userList;
	}

	@Override
	public SysUser listUsersByCourseId(Long courseId) {
		return sysUserMapper.listUsersByCourseId(courseId);
	}

	@Override
	public Page<SysUser> findAll(Page<SysUser> page) {
		return sysUserMapper.findAll(page);
	}

	@Override
	public List<SysUser> findById(Long teacherId) {
		return sysUserMapper.findById(teacherId);
	}



}

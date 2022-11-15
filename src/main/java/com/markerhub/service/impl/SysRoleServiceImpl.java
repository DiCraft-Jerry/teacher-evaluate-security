package com.markerhub.service.impl;

import cn.hutool.db.sql.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysRole;
import com.markerhub.mapper.SysRoleMapper;
import com.markerhub.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> listRolesByUserId(Long userId) {

		List<SysRole> sysRoles = this.list(new QueryWrapper<SysRole>()
				.inSql("id", "select role_id from sys_user_role where user_id = " + userId));

		return sysRoles;
	}

	@Override
	public SysRole listRoleByUserId(Long userId) {

		return sysRoleMapper.rolesByUserId(userId);
	}

	@Override
	public Page<SysRole> findName(Page<SysRole> page) {
		return sysRoleMapper.findName(page);
	}
}

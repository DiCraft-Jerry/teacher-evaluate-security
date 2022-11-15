package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysUser;
import com.markerhub.entity.SysUserRole;
import com.markerhub.mapper.SysUserRoleMapper;
import com.markerhub.service.SysUserRoleService;
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
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUser> listUserById(Long id) {
        SysUserRole sysUserRole = sysUserRoleMapper.selectById(id);
        List<SysUserRole> sysUserRoleList = this.list(new QueryWrapper<SysUserRole>()
                .inSql("id", "select user_id from sys_user_role where role_id = " + id));

//        sysUsers.forEach(u -> {
//            this.clearUserAuthorityInfo(u.getUsername());
//        });
        return null;
    }

    @Override
    public List<SysUserRole> listRoleByUserId(Long userId) {
        return sysUserRoleMapper.listRoleByUserId(userId);
    }


}

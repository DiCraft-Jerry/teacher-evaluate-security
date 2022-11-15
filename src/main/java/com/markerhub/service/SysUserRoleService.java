package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysUser;
import com.markerhub.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    List<SysUser> listUserById(Long id);


    List<SysUserRole> listRoleByUserId(Long userId);
}

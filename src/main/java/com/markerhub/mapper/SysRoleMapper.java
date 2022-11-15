package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * fetch data by user id
     * @param userId
     * @return
     */
    SysRole rolesByUserId(Long userId);

    /**
     * @param page
     * @return
     */
    Page<SysRole> findName(Page<SysRole> page);
}

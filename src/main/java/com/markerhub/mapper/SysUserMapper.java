package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.Batch;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

	List<Long> getNavMenuIds(Long userId);

	List<SysUser> listByMenuId(Long menuId);

	List<SysUser> listUserById(Long userId);

	List<SysUser> findById(Long id);

	Page<SysUser> findAll(Page<SysUser> page);

	SysUser listUsersByCourseId(Long courseId);


}

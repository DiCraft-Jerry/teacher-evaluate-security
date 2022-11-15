package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.Batch;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
public interface SysUserService extends IService<SysUser> {

	SysUser getByUsername(String username);

	String getUserAuthorityInfo(Long userId);

	void clearUserAuthorityInfo(String username);

	void clearUserAuthorityInfoByRoleId(Long roleId);

	void clearUserAuthorityInfoByMenuId(Long menuId);

	List<SysUser> listUserByUserId (Long userId);

	/**
	 * 根据教师id查询信息
	 * @param teacherId
	 * @return
	 */
	List<SysUser> listUserByTeacherId(Long teacherId);

	/**
	 * 根据课程id查教师信息
	 * @param courseId
	 * @return
	 */
	List<SysUser> listUserByCourseId(Long courseId);

	SysUser listUsersByCourseId(Long courseId);

	Page<SysUser> findAll(Page<SysUser> page);

    List<SysUser> findById(Long teacherId);


}

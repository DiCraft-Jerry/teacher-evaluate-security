package com.markerhub.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CourseBatch;
import com.markerhub.entity.UserCourse;

import java.util.List;

/**
* @author ASUS
* @description 针对表【user_course】的数据库操作Service
* @createDate 2022-10-08 23:12:30
*/
public interface UserCourseService extends IService<UserCourse> {

    Page<UserCourse> finAllCT(Page<UserCourse> page,Long batchId);

    Page<UserCourse> findAll(Page<UserCourse> page, Long batchId,Long userId);
}

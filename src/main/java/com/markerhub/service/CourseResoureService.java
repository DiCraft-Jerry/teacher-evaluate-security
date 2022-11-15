package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CourseResoure;

import java.util.List;

/**
* @author ASUS
* @description 针对表【course_resoure】的数据库操作Service
* @createDate 2022-10-07 17:44:48
*/
public interface CourseResoureService extends IService<CourseResoure> {

    List<CourseResoure> findById(Long id);

    List<CourseResoure> listResoureByCourseId(Long courseId);

    void clearUserAuthorityInfo(String name);

    Page<CourseResoure> finAll(Page<CourseResoure> page, Long id);
}

package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CourseInfo;

import java.util.List;

/**
* @author ASUS
* @description 针对表【course_info】的数据库操作Service
* @createDate 2022-10-05 10:29:04
*/
public interface CourseInfoService extends IService<CourseInfo> {
    /**
     * 根据资料id查课程信息
     * @param resoureId
     * @return
     */
    List<CourseInfo> listCourseByResoureId(Long resoureId);

    /**
     * 根据用户id查课程信息
     * @param courseId
     * @return
     */
    List<CourseInfo> findById(Long courseId);

    void clearUserAuthorityInfo(String name);

    List<CourseInfo> listCourseBybatchId(Long batchId);

    Page<CourseInfo> finAll(Page<CourseInfo> page, Long courseId);
}

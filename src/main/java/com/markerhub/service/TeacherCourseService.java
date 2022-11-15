package com.markerhub.service;

import com.markerhub.entity.TeacherCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ASUS
* @description 针对表【teacher_course】的数据库操作Service
* @createDate 2022-10-26 09:42:22
*/
public interface TeacherCourseService extends IService<TeacherCourse> {

    /**
     * 根据课程id查教师信息
     * @param courseId
     * @return
     */
    TeacherCourse teacherByCourseId(Long courseId);
}

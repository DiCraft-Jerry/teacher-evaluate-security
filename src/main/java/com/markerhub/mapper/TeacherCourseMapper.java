package com.markerhub.mapper;

import com.markerhub.entity.TeacherCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ASUS
* @description 针对表【teacher_course】的数据库操作Mapper
* @createDate 2022-10-26 09:42:22
* @Entity com.markerhub.entity.TeacherCourse
*/
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {

    TeacherCourse teacherByCourseId(Long courseId);
}





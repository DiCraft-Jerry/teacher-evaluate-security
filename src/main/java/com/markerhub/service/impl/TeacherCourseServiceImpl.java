package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.TeacherCourse;
import com.markerhub.service.TeacherCourseService;
import com.markerhub.mapper.TeacherCourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author ASUS
* @description 针对表【teacher_course】的数据库操作Service实现
* @createDate 2022-10-26 09:42:22
*/
@Service
public class TeacherCourseServiceImpl extends ServiceImpl<TeacherCourseMapper, TeacherCourse>
    implements TeacherCourseService{

    @Resource
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public TeacherCourse teacherByCourseId(Long courseId) {

        return teacherCourseMapper.teacherByCourseId(courseId);
    }
}





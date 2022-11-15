package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.service.CollegeTeacherService;
import com.markerhub.mapper.CollegeTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_teacher】的数据库操作Service实现
* @createDate 2022-10-25 10:01:51
*/
@Service
public class CollegeTeacherServiceImpl extends ServiceImpl<CollegeTeacherMapper, CollegeTeacher>
    implements CollegeTeacherService{

    @Autowired
    private CollegeTeacherMapper collegeTeacherMapper;

    @Override
    public Page<CollegeTeacher> findAll(Page<CollegeTeacher> page) {
        return collegeTeacherMapper.findAll(page);
    }

    @Override
    public List<CollegeTeacher> listTeacherIdByCoureseId(Long courseId) {
        List<CollegeTeacher> collegeTeachers=this.list(new QueryWrapper<CollegeTeacher>()
        .inSql("teacher_id","select teacher_id from teacher_course where course_id="+courseId));
        System.out.println(collegeTeachers);
        return collegeTeachers;
    }


}





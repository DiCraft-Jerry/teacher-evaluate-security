package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.CollegeTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_teacher】的数据库操作Service
* @createDate 2022-10-25 10:01:51
*/
public interface CollegeTeacherService extends IService<CollegeTeacher> {

    Page<CollegeTeacher> findAll(Page<CollegeTeacher> page);

    List<CollegeTeacher> listTeacherIdByCoureseId(Long courseId);

}

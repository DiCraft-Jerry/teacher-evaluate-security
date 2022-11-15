package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.entity.vo.TeacherCollegeVo;

import java.util.List;

public interface TeacherCollegeService extends IService<TeacherCollegeVo> {

    Page<TeacherCollegeVo> findCTVo(Page<TeacherCollegeVo> page);

    List<TeacherCollegeVo> listTeacherByCourseId(Long courseId);



}

package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.entity.vo.TeacherCollegeVo;
import com.markerhub.mapper.CollegeTeacherMapper;
import com.markerhub.mapper.voMapper.TeacherCollegeMapper;
import com.markerhub.service.CollegeTeacherService;
import com.markerhub.service.TeacherCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCollegeServiceImpl extends ServiceImpl<TeacherCollegeMapper, TeacherCollegeVo>
        implements TeacherCollegeService {
    @Autowired
    TeacherCollegeMapper teacherCollegeMapper;
    @Override
    public Page<TeacherCollegeVo> findCTVo(Page<TeacherCollegeVo> page) {
        return teacherCollegeMapper.findCTVo(page);
    }

    @Override
    public List<TeacherCollegeVo> listTeacherByCourseId(Long courseId) {
        return teacherCollegeMapper.listTeacherByCourseId(courseId);
    }


}

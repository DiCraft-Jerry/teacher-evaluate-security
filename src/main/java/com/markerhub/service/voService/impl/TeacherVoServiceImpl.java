package com.markerhub.service.voService.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.vo.TeacherCollegeVo;
import com.markerhub.entity.vo.TeacherVo;
import com.markerhub.mapper.voMapper.TeacherCollegeMapper;
import com.markerhub.mapper.voMapper.TeacherVoMapper;
import com.markerhub.service.TeacherCollegeService;
import com.markerhub.service.voService.TeacherVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherVoServiceImpl extends ServiceImpl<TeacherVoMapper, TeacherVo>
        implements TeacherVoService {
    @Autowired
    TeacherVoMapper teacherVoMapper;


    @Override
    public Page<TeacherVo> findCTVo(Page<TeacherVo> page) {
        return teacherVoMapper.findCTVo(page);
    }
}

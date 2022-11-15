package com.markerhub.service.voService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.markerhub.entity.vo.TeacherVo;



public interface TeacherVoService extends IService<TeacherVo> {

    Page<TeacherVo> findCTVo(Page<TeacherVo> page);


}

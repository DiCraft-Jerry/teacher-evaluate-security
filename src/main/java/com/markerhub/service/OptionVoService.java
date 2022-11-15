package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.ExamScore;
import com.markerhub.entity.vo.OptionsVo;

import java.util.List;

public interface OptionVoService extends IService<OptionsVo> {

    List<OptionsVo> listOptionsByRoleId(Long roleId);

    List<OptionsVo> listOptionsByRoleIdByTeacher(Long roleId);

    List<OptionsVo> listOptionsByRoleIdByMine(Long roleId);
}

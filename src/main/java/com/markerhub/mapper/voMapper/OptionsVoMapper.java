package com.markerhub.mapper.voMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.entity.vo.OptionsVo;
import com.markerhub.entity.vo.TeacherCollegeVo;

import java.util.List;

public interface OptionsVoMapper extends BaseMapper<OptionsVo> {

    List<OptionsVo> listOptionsByRoleId(Long userId);

    List<OptionsVo> listOptionsByRoleIdByTeacher(Long roleId);

    List<OptionsVo> listOptionsByRoleIdByMine(Long roleId);
}

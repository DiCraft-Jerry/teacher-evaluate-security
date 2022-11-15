package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.Evaluation;
import com.markerhub.entity.vo.EvaluationVo;
import com.markerhub.mapper.EvaluationMapper;
import com.markerhub.mapper.voMapper.EvaluationVoMapper;
import com.markerhub.service.EvaluationService;
import com.markerhub.service.EvaluationVoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EvaluationVoServiceImpl extends ServiceImpl<EvaluationVoMapper, EvaluationVo>
        implements EvaluationVoService {

    @Resource
    private EvaluationVoMapper evaluationVoMapper;

    @Override
    public Page<EvaluationVo> listByRoleId(Page<EvaluationVo> page) {
        return evaluationVoMapper.listByRoleId(page);
    }
}

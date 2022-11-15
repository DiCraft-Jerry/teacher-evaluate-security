package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.Evaluation;
import com.markerhub.service.EvaluationService;
import com.markerhub.mapper.EvaluationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author ASUS
* @description 针对表【evaluation】的数据库操作Service实现
* @createDate 2022-11-03 09:04:52
*/
@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation>
    implements EvaluationService{

    @Resource
    EvaluationMapper evaluationMapper;

    /**
     * 根据id修改状态
     *  @param id
     * @param status
     * @return
     */
    @Override
    public boolean updateStatusById(Long id, Long status) {
        if (status == 0 ) {
            evaluationMapper.updateStatusIsTrueById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStatusIsFalseById(Long id, Long status) {
        if (status == 1) {
            evaluationMapper.updateStatusIsFalseById(id);
            return true;
        } else {
            return false;
        }
    }
}





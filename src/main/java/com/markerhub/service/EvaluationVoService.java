package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.Evaluation;
import com.markerhub.entity.vo.EvaluationVo;

/**
* @author ASUS
* @description 针对表【evaluation】的数据库操作Service
* @createDate 2022-11-03 09:04:52
*/
public interface EvaluationVoService extends IService<EvaluationVo> {
    /**
     * 根据roleId查询评教信息
     * @return
     */
    Page<EvaluationVo> listByRoleId(Page<EvaluationVo> page);
}

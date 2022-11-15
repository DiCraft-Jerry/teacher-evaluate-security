package com.markerhub.service;

import com.markerhub.entity.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ASUS
* @description 针对表【evaluation】的数据库操作Service
* @createDate 2022-11-03 09:04:52
*/
public interface EvaluationService extends IService<Evaluation> {

    /**
     * 根据id修改状态
     * @param id
     * @param status
     * @return
     */
    boolean updateStatusById(Long id, Long status);

    boolean updateStatusIsFalseById(Long id, Long status);


}

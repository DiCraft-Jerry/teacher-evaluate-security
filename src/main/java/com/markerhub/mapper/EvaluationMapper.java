package com.markerhub.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ASUS
* @description 针对表【evaluation】的数据库操作Mapper
* @createDate 2022-11-03 09:04:52
* @Entity com.markerhub.entity.Evaluation
*/
public interface EvaluationMapper extends BaseMapper<Evaluation> {


    void updateStatusIsTrueById(Long id);

    void updateStatusIsFalseById(Long id);
}





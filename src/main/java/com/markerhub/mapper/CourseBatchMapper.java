package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.CourseBatch;

/**
* @author ASUS
* @description 针对表【course_batch】的数据库操作Mapper
* @createDate 2022-10-05 10:29:04
* @Entity com.markerhub.entity.CourseBatch
*/
public interface CourseBatchMapper extends BaseMapper<CourseBatch> {

    Page<CourseBatch> findAll(Page<CourseBatch> page, Long batchId);

}





package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CourseBatch;

/**
* @author ASUS
* @description 针对表【course_batch】的数据库操作Service
* @createDate 2022-10-05 10:29:04
*/
public interface CourseBatchService extends IService<CourseBatch> {
    Page<CourseBatch> findAll(Page<CourseBatch> page,Long batchId);
}

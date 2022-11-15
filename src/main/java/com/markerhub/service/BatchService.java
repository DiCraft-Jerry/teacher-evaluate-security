package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.Batch;

import java.util.List;

/**
* @author ASUS
* @description 针对表【batch】的数据库操作Service
* @createDate 2022-10-05 10:29:04
*/
public interface BatchService extends IService<Batch> {

    List<Batch> listBatchByCourseId(Long courseId);

    List<Batch> listBatchByUserId(Long courseId);

    List<Batch> findById(Long id);

    Page<Batch> findAll(Page<Batch> page);

}

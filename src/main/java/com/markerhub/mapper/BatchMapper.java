package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.Batch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【batch】的数据库操作Mapper
* @createDate 2022-10-05 10:29:04
* @Entity com.markerhub.entity.Batch
*/
@Mapper
public interface BatchMapper extends BaseMapper<Batch> {

    List<Batch> findById(Long id);

    Batch listBatchByUserId(Long userId);

    Page<Batch> findAll(Page<Batch> page);
}





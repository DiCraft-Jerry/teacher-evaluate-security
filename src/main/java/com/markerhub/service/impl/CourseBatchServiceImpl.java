package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CourseBatch;
import com.markerhub.mapper.CourseBatchMapper;
import com.markerhub.service.CourseBatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author ASUS
* @description 针对表【course_batch】的数据库操作Service实现
* @createDate 2022-10-05 10:29:04
*/
@Service
public class CourseBatchServiceImpl extends ServiceImpl<CourseBatchMapper, CourseBatch>
    implements CourseBatchService{

    @Resource
    private CourseBatchMapper courseBatchMapper;

    @Override
    public Page<CourseBatch> findAll(Page<CourseBatch> page, Long batchId) {
        return courseBatchMapper.findAll(page,batchId);
    }
}





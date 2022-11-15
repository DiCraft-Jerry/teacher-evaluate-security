package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.Batch;
import com.markerhub.mapper.BatchMapper;
import com.markerhub.service.BatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【batch】的数据库操作Service实现
* @createDate 2022-10-05 10:29:04
*/
@Service
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch>
    implements BatchService{

    @Resource
    private BatchMapper batchMapper;
    /**
     * 通过课程id查找批次
     * @param courseId
     * @return
     */
    @Override
    public List<Batch> listBatchByCourseId(Long courseId) {

        List<Batch> batchList=this.list(new QueryWrapper<Batch>()
                .inSql("id","select batch_id from course_batch where course_id="+courseId));


        return batchList;
    }
//
//    @Override
//    public Batch listBatchByUserId(Long userId) {
//        System.out.println("xsxs");
//        System.out.println(batchMapper.listBatchByUserId(userId));
//        return batchMapper.listBatchByUserId(userId);
//    }

    @Override
    public List<Batch> listBatchByUserId(Long courseId) {
        List<Batch> batchList=this.list(new QueryWrapper<Batch>()
        .inSql("id","select batch_id from user_course where course_id="+courseId));

        return batchList;
    }

    @Override
    public List<Batch> findById(Long id) {
        return batchMapper.findById(id);
    }

    @Override
    public Page<Batch> findAll(Page<Batch> page) {
        return batchMapper.findAll(page);
    }
}





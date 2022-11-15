package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.Teach;
import com.markerhub.service.TeachService;
import com.markerhub.mapper.TeachMapper;
import com.markerhub.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【teach】的数据库操作Service实现
* @createDate 2022-11-07 09:27:07
*/
@Service
public class TeachServiceImpl extends ServiceImpl<TeachMapper, Teach>
    implements TeachService{

    @Resource
    private TeachMapper teachMapper;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public Page<Teach> findAll(Page<Teach> page, Long batchId) {
        return teachMapper.findAll(page,batchId);
    }

    @Override
    public Page<Teach> findAllExcept(Page<Teach> page, Long batchId,Long userId ) {
        return teachMapper.findAllExcept(page,batchId, userId);
    }

    @Override
    public Page<Teach> findAllBybatchId(Page<Teach> page,  Long batchId,List<Long> id) {
        return teachMapper.findAllBybatchId(page,batchId,id);
    }

    /**
     * 查询自己的授课信息
     *
     * @param page
     * @param batchId
     * @param userId
     * @return
     */
    @Override
    public Page<Teach> findAllByUserId(Page<Teach> page, Long batchId, Long userId) {
        return teachMapper.findAllByUserId(page,batchId,userId);
    }

    @Override
    public void clearUserAuthorityInfo(Long id) {
        redisUtil.del("TeachId:" + id);
    }


}





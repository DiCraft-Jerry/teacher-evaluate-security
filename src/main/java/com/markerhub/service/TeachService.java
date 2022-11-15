package com.markerhub.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.Teach;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ASUS
* @description 针对表【teach】的数据库操作Service
* @createDate 2022-11-07 09:27:07
*/
public interface TeachService extends IService<Teach> {
    /**
     * 查询所有授课信息
     * @param page
     * @param batchId
     * @return
     */
    Page<Teach> findAll(Page<Teach> page, Long batchId);

    /**
     * 查询除自己外的授课信息
     * @param page
     * @param batchId
     * @param userId
     * @return
     */
    Page<Teach> findAllExcept(Page<Teach> page, Long batchId, Long userId);

    /**
     * 根据批次和授课id查询授课信息
     * @param page
     * @param batchId
     * @param id
     * @return
     */
    Page<Teach> findAllBybatchId(Page<Teach> page,  Long batchId,List<Long> id);

    /**
     * 查询自己的授课信息
     * @param page
     * @param batchId
     * @param userId
     * @return
     */
    Page<Teach> findAllByUserId(Page<Teach> page, Long batchId, Long userId);

    void clearUserAuthorityInfo(Long id);
}

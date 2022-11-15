package com.markerhub.mapper;

import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DiCraft
 * @description 针对表【quota】的数据库操作Mapper
 * @createDate 2022-11-01 15:52:08
 * @Entity cn.cq.quota.entity.model.Quota
 */
@Mapper
public interface QuotaMapper{
    /**
     *  插入数据
     * @param quota
     */
    void insertQuota(Quota quota);

    /**
     *  插入选项
     * @param listOp
     */
    void insertOptions(List<QuotaOptions> listOp);

    List<Quota> findAll();

    Quota getById(Long id);

    void updateById(Quota quota);

    void removeById(Long id);


}






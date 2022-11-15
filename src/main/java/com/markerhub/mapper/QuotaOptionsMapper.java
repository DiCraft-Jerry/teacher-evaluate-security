package com.markerhub.mapper;

import com.markerhub.entity.QuotaOptions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【quota_options】的数据库操作Mapper
* @createDate 2022-11-08 14:34:09
* @Entity com.markerhub.entity.QuotaOptions
*/
@Mapper
public interface QuotaOptionsMapper extends BaseMapper<QuotaOptions> {
    /**
     * 拿取选项数据
     * @return list
     */
    List<QuotaOptions> findAll();

    /**
     * 修改分数
     * @param quotaOptions
     * @return
     */
    int updateScore(QuotaOptions quotaOptions);

    QuotaOptions getInfoByOptionsId(Integer id);

}





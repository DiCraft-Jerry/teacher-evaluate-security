package com.markerhub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author DiCraft
* @description 针对表【quota】的数据库操作Service
* @createDate 2022-11-01 15:52:08
*/

public interface QuotaService {


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

    List<Quota> tree();

    Quota getById(Long id);

    void updateById(Quota quota);


    void removeById(Long id);


}

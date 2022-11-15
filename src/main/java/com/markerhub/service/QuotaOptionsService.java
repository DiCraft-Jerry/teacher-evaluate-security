package com.markerhub.service;

import com.markerhub.entity.QuotaOptions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.mapper.QuotaOptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【quota_options】的数据库操作Service
* @createDate 2022-11-08 14:34:09
*/
public interface QuotaOptionsService extends IService<QuotaOptions> {

    /**
     * 拿取选项数据
     * @return list
     */
    List<QuotaOptions> updateOptionsScore();
}

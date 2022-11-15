package com.markerhub.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.entity.SysMenu;
import com.markerhub.mapper.QuotaMapper;
import com.markerhub.service.QuotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author DiCraft
* @description 针对表【quota】的数据库操作Service实现
* @createDate 2022-11-01 15:52:08
*/
@Slf4j
@Service
public class QuotaServiceImpl implements QuotaService {


    @Autowired
    QuotaMapper quotaMapper;

    /**
     * 插入数据
     *
     * @param quota
     */
    @Override
    public void insertQuota(Quota quota) {
        System.out.println(quotaMapper);
        quotaMapper.insertQuota(quota);
    }

    /**
     * 插入选项
     *
     * @param listOp
     */
    @Override
    public void insertOptions(List<QuotaOptions> listOp) {
        quotaMapper.insertOptions(listOp);
    }


    @Override
    public List<Quota> tree() {
        // 获取所有菜单信息
        List<Quota> quotaList = quotaMapper.findAll();

        // 转成树状结构
        return buildTreeMenu(quotaList);
    }

    @Override
    public Quota getById(Long id) {
        return quotaMapper.getById(id);
    }

    @Override
    public void updateById(Quota quota) {
        quotaMapper.updateById(quota);
    }

    @Override
    public void removeById(Long id) {
        quotaMapper.removeById(id);
    }



    private List<Quota> buildTreeMenu(List<Quota> quotas) {

        List<Quota> finalMenus = new ArrayList<>();

        // 先各自寻找到各自的孩子
        for (Quota quota : quotas) {

            for (Quota e : quotas) {
                if (quota.getId() == e.getParentId()) {
                    quota.getChildren().add(e);

                }
            }

            // 提取出父节点
            if (quota.getParentId() == 0L) {
                finalMenus.add(quota);
            }
        }

//		System.out.println(JSONUtil.toJsonStr(finalMenus));
        return finalMenus;
    }
}





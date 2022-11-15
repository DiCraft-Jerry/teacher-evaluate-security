package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.service.QuotaOptionsService;
import com.markerhub.mapper.QuotaOptionsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【quota_options】的数据库操作Service实现
* @createDate 2022-11-08 14:34:09
*/
@Service
public class QuotaOptionsServiceImpl extends ServiceImpl<QuotaOptionsMapper, QuotaOptions>
    implements QuotaOptionsService{

    @Resource
    QuotaOptionsMapper quotaOptionsMapper;


    @Override
    public List<QuotaOptions> updateOptionsScore() {
        List<QuotaOptions> list = quotaOptionsMapper.findAll();

        for(int i = 0 ; i < list.size(); i = i+4 ){
            int score = 100;
            for( int j = i ;j < i+4 ; j++){

                System.out.println(list.get(j));
                list.get(j).setScore(score);
                int re = quotaOptionsMapper.updateScore(list.get(j));
                score -=25;


            }
            System.out.println("i: "+i);
        }

        return null;
    }
}





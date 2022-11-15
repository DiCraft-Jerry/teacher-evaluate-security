package com.markerhub;

import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.mapper.QuotaMapper;
import com.markerhub.mapper.QuotaOptionsMapper;
import com.markerhub.mapper.UserEvaluateMapper;
import com.markerhub.mapper.voMapper.OptionsVoMapper;
import com.markerhub.service.ScoreResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SpringBootTest
class TeacherJavaApplicationTests {

    @Resource
    OptionsVoMapper optionsVoMapper;

    @Resource
    ScoreResultService scoreResultService;

    @Resource
    QuotaMapper quotaMapper;

    @Resource
    QuotaOptionsMapper quotaOptionsMapper;

    @Autowired
    UserEvaluateMapper userEvaluateMapper;


    @Test
    void contextLoads() {

        System.out.println(optionsVoMapper.listOptionsByRoleId(9L));
    }

    /**
     * 查找每个授课的评分结果
     */
    @Test
    void contextLoads2() {

        System.out.println("------------------------");
//        System.out.println(userEvaluateMapper.findUserEvaluate());
    }

    /**
     * 算分
     */
    @Test
    void contextLoads3() {

        List<Integer> optionsId = new ArrayList<>();
        optionsId.add(2853);
        optionsId.add(2857);
        optionsId.add(2861);
        optionsId.add(2865);
        optionsId.add(2869);
        optionsId.add(2873);
        optionsId.add(2877);
        optionsId.add(2881);
        optionsId.add(2885);

        double sum = 0.00;

        for (int i = 0; i < optionsId.size() ; i++) {

            Integer parentId = 0;
            Integer nextParentId = 0;

            QuotaOptions options = quotaOptionsMapper.getInfoByOptionsId(optionsId.get(i));

            Quota quota1 = quotaMapper.getById(Long.valueOf(options.getQuotaId()));

            Double quotaWeight = Double.valueOf(quota1.getQuotaRight());

            int score = options.getScore();

            Double weightScore = quotaWeight * score;

            parentId = quota1.getParentId();


            while (nextParentId != 0) {
                Quota fatherQuote = quotaMapper.getById(Long.valueOf(parentId));



                quotaWeight = Double.valueOf(fatherQuote.getQuotaRight());

                weightScore *= quotaWeight;
                parentId = fatherQuote.getParentId();

                nextParentId =quotaMapper.getById(Long.valueOf(parentId)).getParentId();

            }
            System.out.println(weightScore);
            sum += weightScore;
        }

        System.out.println("------------- sum = "+ sum);
    }

    /**
     * 算总分
     */
    @Test
    void contextLoads4() {
        System.out.println(scoreResultService.countTeachScore(1));
    }

    @Test
    void contextLoads6() {
        System.out.println(optionsVoMapper.listOptionsByRoleIdByMine(9l));
    }

}


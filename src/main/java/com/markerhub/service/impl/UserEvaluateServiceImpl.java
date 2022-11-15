package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.entity.UserEvaluate;
import com.markerhub.entity.vo.EvaluationInfoVo;
import com.markerhub.mapper.QuotaMapper;
import com.markerhub.mapper.QuotaOptionsMapper;
import com.markerhub.service.UserEvaluateService;
import com.markerhub.mapper.UserEvaluateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



/**
* @author ASUS
* @description 针对表【user_evaluate】的数据库操作Service实现
* @createDate 2022-11-13 17:30:36
*/
@Service
public class UserEvaluateServiceImpl extends ServiceImpl<UserEvaluateMapper, UserEvaluate>
    implements UserEvaluateService{

    @Resource
    QuotaOptionsMapper quotaOptionsMapper;

    @Resource
    QuotaMapper quotaMapper;

    @Resource
    UserEvaluateMapper userEvaluateMapper;


    @Override
    public int saveUserEvaluate(UserEvaluate userEvaluate) {

        int i = userEvaluateMapper.saveUserEvaluate(userEvaluate);
        return i;
    }

    /**
     * 获取所有用户的评教信息
     * @return
     */
    @Override
    public List<EvaluationInfoVo> findUserEvaluate(Integer batchId,Integer roleId){
        List<EvaluationInfoVo> evaluationInfoVos = userEvaluateMapper.findUserEvaluate(batchId,roleId);

        return evaluationInfoVos;
    }

    @Override
    public List<EvaluationInfoVo> findUserEvaluateByBatchId(Integer batchId) {
        return userEvaluateMapper.findUserEvaluateByBatchId(batchId);
    }

    @Override
    public List<EvaluationInfoVo> findUserEvaluateByRoleId(Integer roleId) {
        return userEvaluateMapper.findUserEvaluateByRoleId(roleId);
    }


    @Override
    public Double countUserScore(List<Integer> optionsId) {

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


            while (parentId != 0) {
                Quota fatherQuote = quotaMapper.getById(Long.valueOf(parentId));



                quotaWeight = Double.valueOf(fatherQuote.getQuotaRight());

                weightScore *= quotaWeight;
                parentId = fatherQuote.getParentId();

            }
            System.out.println(weightScore);
            sum += weightScore;
        }

        System.out.println("------------- sum = "+ sum);
        return sum;

    }


    /**
     * 根据授课id查找当前授课信息的学生评教分数
     *
     * @param teachId
     * @return
     */
    @Override
    public List<String> findScoreByTeachIdFromStudent(Integer teachId) {

        List<String> scoreFromStudent = userEvaluateMapper.findScoreByTeachIdFromStudent(teachId);
        return scoreFromStudent;
    }

    /**
     * 根据授课id查找当前授课信息的教师评教分数
     *
     * @param teachId
     * @return
     */
    @Override
    public List<String> findScoreByTeachIdFromTeacher(Integer teachId) {
        List<String> scoreFromTeacher = userEvaluateMapper.findScoreByTeachIdFromTeacher(teachId);
        return scoreFromTeacher;
    }

    /**
     * 根据授课id查找当前授课信息的系主任评教分数
     *
     * @param teachId
     * @return
     */
    @Override
    public List<String> findScoreByTeachIdFromDept(Integer teachId) {
        List<String> scoreFromDept = userEvaluateMapper.findScoreByTeachIdFromDept(teachId);
        return scoreFromDept;
    }

    /**
     * 根据授课id查找当前授课信息的教研室评教分数
     *
     * @param teachId
     * @return
     */
    @Override
    public List<String> findScoreByTeachIdFromNormal(Integer teachId) {
        List<String> scoreFromNormal = userEvaluateMapper.findScoreByTeachIdFromNormal(teachId);
        return scoreFromNormal;
    }

    @Override
    public Boolean isNewEvaluateInfo(Long teachId , Long userId) {

        Integer id = Math.toIntExact(teachId);

        System.out.println(teachId);
        List<Integer> ids = userEvaluateMapper.findAllTeachId(userId);

        System.out.println(ids);

        int key = 0;
        for (int i = 0 ; i < ids.size() ; i++ ) {
            if (id.equals(ids.get(i))) {
                key = 1;
                break;
            }
        }

        if (key == 0) {
            return true;
        } else {
            return false;
        }


    }


}





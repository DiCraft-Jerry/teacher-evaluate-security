package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.ScoreResult;
import com.markerhub.entity.vo.ScoreResultInfoVo;
import com.markerhub.service.ScoreResultService;
import com.markerhub.mapper.ScoreResultMapper;
import com.markerhub.service.UserEvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Hasee
* @description 针对表【score_result】的数据库操作Service实现
* @createDate 2022-11-14 12:29:48
*/
@Service
public class ScoreResultServiceImpl extends ServiceImpl<ScoreResultMapper, ScoreResult>
    implements ScoreResultService{

    @Resource
    UserEvaluateService userEvaluateService;

    @Resource
    ScoreResultMapper scoreResultMapper;

    /**
     * 计算某次授课的总评分
     *
     * @return
     */
    @Override
    public String countTeachScore(Integer teachId) {

        //总分
        Double ans = 0.00;

        //平均分
        Double studentAverageScore = 0.00;
        Double teacherAverageScore = 0.00;
        Double deptAverageScore = 0.00;
        Double normalAverageScore = 0.00;

        //单个角色的总分
        Double studentScore = 0.00;
        Double teacherScore = 0.00;
        Double deptScore = 0.00;
        Double normalScore = 0.00;

        //拿到评分的列表
        List<String> studentScoreList = userEvaluateService.findScoreByTeachIdFromStudent(teachId);
        List<String> teacherScoreList = userEvaluateService.findScoreByTeachIdFromTeacher(teachId);
        List<String> deptScoreList = userEvaluateService.findScoreByTeachIdFromDept(teachId);
        List<String> normalScoreList = userEvaluateService.findScoreByTeachIdFromNormal(teachId);

        //获取评分人数
        Integer studentScoreListSize = studentScoreList.size();
        Integer teacherScoreListSize = teacherScoreList.size();
        Integer deptScoreListSize = deptScoreList.size();
        Integer normalScoreListSize = normalScoreList.size();

        //利用for循环计算单个角色的总分
        if (studentScoreListSize > 0) {
            for (int i = 0; i < studentScoreListSize; i++) {
                studentScore += Double.valueOf(studentScoreList.get(i));
            }
        }
        if (teacherScoreListSize > 0) {
            for (int i = 0; i < teacherScoreListSize; i++) {
                teacherScore += Double.valueOf(teacherScoreList.get(i));
            }
        }

        if (deptScoreListSize > 0) {
            for (int i = 0; i < deptScoreListSize; i++) {
                deptScore += Double.valueOf(deptScoreList.get(i));
            }
        }

        if (normalScoreListSize > 0) {
            for (int i = 0; i < normalScoreListSize; i++) {
                normalScore += Double.valueOf(normalScoreList.get(i));
            }
        }

        //计算平均分
        if (studentScoreListSize != 0) {
            studentAverageScore = studentScore / studentScoreListSize;
        }
        if (teacherScoreListSize != 0) {
            teacherAverageScore = teacherScore /teacherScoreListSize;
        }
        if (deptScoreListSize != 0) {
            deptAverageScore = deptScore / deptScoreListSize;
        }
        if (normalScoreListSize != 0) {
            normalAverageScore = normalScore / normalScoreListSize;
        }


        //获取总分
        ans = studentAverageScore + teacherAverageScore + deptAverageScore + normalAverageScore;

        return String.valueOf(ans);
    }

    @Override
    public List<ScoreResultInfoVo> findAllInfo() {
        return scoreResultMapper.findAllInfo();
    }

    @Override
    public List<ScoreResultInfoVo> findAllInfoByBatchId(Integer batchId) {
        return scoreResultMapper.findAllInfoByBatchId(batchId);
    }


}





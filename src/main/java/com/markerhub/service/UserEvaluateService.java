package com.markerhub.service;

import com.markerhub.entity.UserEvaluate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.vo.EvaluationInfoVo;

import java.util.List;

/**
* @author ASUS
* @description 针对表【user_evaluate】的数据库操作Service
* @createDate 2022-11-13 17:30:36
*/
public interface UserEvaluateService extends IService<UserEvaluate> {
    Double countUserScore(List<Integer> optionsId);

    int saveUserEvaluate(UserEvaluate userEvaluate);

    /**
     * 获取所有用户的评教信息
     * @return
     */
    List<EvaluationInfoVo> findUserEvaluate(Integer batchId,Integer roleId);

    List<EvaluationInfoVo> findUserEvaluateByBatchId(Integer batchId);

    List<EvaluationInfoVo> findUserEvaluateByRoleId(Integer roleId);


    /**
     * 根据授课id查找当前授课信息的学生评教分数
     * @param teachId
     * @return
     */
    List<String> findScoreByTeachIdFromStudent(Integer teachId);

    /**
     * 根据授课id查找当前授课信息的教师评教分数
     * @param teachId
     * @return
     */
    List<String> findScoreByTeachIdFromTeacher(Integer teachId);

    /**
     * 根据授课id查找当前授课信息的系主任评教分数
     * @param teachId
     * @return
     */
    List<String> findScoreByTeachIdFromDept(Integer teachId);

    /**
     * 根据授课id查找当前授课信息的教研室评教分数
     * @param teachId
     * @return
     */
    List<String> findScoreByTeachIdFromNormal(Integer teachId);

    /**
     * 判断是否评教
     * @param teachId
     * @return
     */
    Boolean isNewEvaluateInfo(Long teachId, Long userId);
}

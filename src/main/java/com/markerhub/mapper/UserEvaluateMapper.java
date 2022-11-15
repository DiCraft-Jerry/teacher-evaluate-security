package com.markerhub.mapper;

import com.markerhub.entity.UserEvaluate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markerhub.entity.vo.EvaluationInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【user_evaluate】的数据库操作Mapper
* @createDate 2022-11-13 17:30:36
* @Entity com.markerhub.entity.UserEvaluate
*/
@Mapper
public interface UserEvaluateMapper extends BaseMapper<UserEvaluate> {

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

    List<Integer> findAllTeachId(Long userId);
}





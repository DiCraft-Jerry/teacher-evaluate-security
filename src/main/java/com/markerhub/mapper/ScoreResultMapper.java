package com.markerhub.mapper;

import com.markerhub.entity.ScoreResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markerhub.entity.vo.ScoreResultInfoVo;

import java.util.List;

/**
* @author Hasee
* @description 针对表【score_result】的数据库操作Mapper
* @createDate 2022-11-14 12:29:48
* @Entity com.markerhub.entity.ScoreResult
*/
public interface ScoreResultMapper extends BaseMapper<ScoreResult> {
    List<ScoreResult> findAll();

    List<ScoreResult> findRecordByTeachId(Integer teachId);

    /**
     * 新增总分记录
     * @param scoreResult
     * @return
     */
    int saveNewTeachingResult(ScoreResult scoreResult);

    /**
     * 更新总分
     * @param scoreResult
     * @return
     */
    int updateOldTeachingResult(ScoreResult scoreResult);


    /**
     * 查找所有授课的总分信息
     * @return
     */
    List<ScoreResultInfoVo> findAllInfo();

    List<ScoreResultInfoVo> findAllInfoByBatchId(Integer batchId);
}





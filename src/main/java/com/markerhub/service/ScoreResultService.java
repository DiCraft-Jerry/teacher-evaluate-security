package com.markerhub.service;

import com.markerhub.entity.ScoreResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.vo.ScoreResultInfoVo;

import java.util.List;

/**
* @author Hasee
* @description 针对表【score_result】的数据库操作Service
* @createDate 2022-11-14 12:29:48
*/
public interface ScoreResultService extends IService<ScoreResult> {

    /**
     * 计算某次授课的总评分
     * @param teachId
     * @return
     */
    String countTeachScore(Integer teachId);

    List<ScoreResultInfoVo> findAllInfo();

    List<ScoreResultInfoVo> findAllInfoByBatchId(Integer batchId);
}

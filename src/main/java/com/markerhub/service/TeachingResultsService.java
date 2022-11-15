package com.markerhub.service;

import com.markerhub.entity.ScoreResult;

/**
 * @author dicraft
 */
public interface TeachingResultsService {
    /**
     * 判断是否为新总分记录
     * @param teachId
     * @return
     */
    Boolean isNewRecord(Integer teachId);

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
     * 处理总分
     * @param teachId
     */
    void checkScoreRecord(Integer teachId);
}

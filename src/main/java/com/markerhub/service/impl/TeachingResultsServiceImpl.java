package com.markerhub.service.impl;

import com.markerhub.entity.ScoreResult;
import com.markerhub.mapper.ScoreResultMapper;
import com.markerhub.service.ScoreResultService;
import com.markerhub.service.TeachingResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dicraft
 */
@Service
public class TeachingResultsServiceImpl implements TeachingResultsService {

    @Resource
    ScoreResultMapper scoreResultMapper;

    @Autowired
    ScoreResultService scoreResultService;

    /**
     * 判断是否为新总分记录
     *
     * @param teachId
     * @return
     */
    @Override
    public Boolean isNewRecord(Integer teachId) {
        List<ScoreResult> list = scoreResultMapper.findRecordByTeachId(teachId);
        int listSize = list.size();

        if (listSize == 0){
            return false;
        } else {
            return true;
        }

    }

    /**
     * 新增总分记录
     *
     * @param scoreResult
     * @return
     */
    @Override
    public int saveNewTeachingResult(ScoreResult scoreResult) {

        return scoreResultMapper.saveNewTeachingResult(scoreResult);
    }

    /**
     * 更新总分
     *
     * @param scoreResult
     * @return
     */
    @Override
    public int updateOldTeachingResult(ScoreResult scoreResult) {
        return scoreResultMapper.updateOldTeachingResult(scoreResult);
    }

    /**
     * 处理总分
     *
     * @param teachId
     */
    @Override
    public void checkScoreRecord(Integer teachId) {

        String finalScore = scoreResultService.countTeachScore(teachId);

        if (isNewRecord(teachId)) {
            ScoreResult scoreResult = new ScoreResult();
            scoreResult.setScore(finalScore);
            scoreResult.setTeachId(teachId);

            updateOldTeachingResult(scoreResult);
        } else {
            ScoreResult scoreResult = new ScoreResult();
            scoreResult.setScore(finalScore);
            scoreResult.setTeachId(teachId);

            saveNewTeachingResult(scoreResult);
        }
    }
}

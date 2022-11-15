package com.markerhub.controller;

import com.markerhub.common.lang.Result;
import com.markerhub.entity.vo.ScoreResultInfoVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-11-14 19:31
 * @package: com.markerhub.controller
 * @Version: 1.0
 * @Decsription:
 */

@RestController
@RequestMapping("/work/scoreResult")
public class ScoreResultController extends BaseController{

    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('work:score:list')")
    public Result scoreList(Integer batchId) {

        List<ScoreResultInfoVo> scoreResultInfoVoList = new ArrayList<>();
        if (batchId == null ){
            scoreResultInfoVoList = scoreResultService.findAllInfo();
        } else {
            scoreResultInfoVoList = scoreResultService.findAllInfoByBatchId(batchId);
        }


        return Result.succ(scoreResultInfoVoList);
    }

}

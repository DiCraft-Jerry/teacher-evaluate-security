package com.markerhub.controller;

import com.markerhub.common.lang.Result;
import com.markerhub.entity.vo.EvaluationInfoVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-11-14 13:31
 * @package: com.markerhub.controller
 * @Version: 1.0
 * @Decsription:
 */

@RequestMapping("/work/record")
@RestController
public class UserEvaluationController extends BaseController{

    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('work:record:list')")
    public Result evaluationList(Integer batchId,Integer roleId) {

        if(batchId !=null && roleId==null){
            List<EvaluationInfoVo> evaluationInfoVoList = userEvaluateService.findUserEvaluateByBatchId(batchId);
            return Result.succ(evaluationInfoVoList);
        }else if(batchId==null && roleId!=null){
            List<EvaluationInfoVo> evaluationInfoVoList = userEvaluateService.findUserEvaluateByRoleId(roleId);
            return Result.succ(evaluationInfoVoList);
        }else {
            List<EvaluationInfoVo> evaluationInfoVoList = userEvaluateService.findUserEvaluate(batchId,roleId);
            return Result.succ(evaluationInfoVoList);
        }


    }
}

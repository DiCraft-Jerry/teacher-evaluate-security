package com.markerhub.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.Batch;
import com.markerhub.entity.SysUserRole;
import com.markerhub.entity.Teach;
import com.markerhub.entity.UserEvaluate;
import com.markerhub.entity.vo.OptionsVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/teacher/myEvaluate")
public class TeacherMyEvaluateController extends BaseController{

    @PostMapping("/options/{userId}/{teachId}")
    @PreAuthorize("hasAuthority('teacher:myEvaluate:options')")
    public Result quotas(@PathVariable("userId") Integer userId,
                         @PathVariable("teachId") Integer teachId,
                         @RequestBody Integer[] quotaIds) {

        UserEvaluate userEvaluate = new UserEvaluate();

        double firstScore = userEvaluateService.countUserScore(Arrays.asList(quotaIds));

        userEvaluate.setUserId(userId);
        userEvaluate.setTeachId(teachId);
        userEvaluate.setFirstScore(String.valueOf(firstScore));

        userEvaluateService.saveUserEvaluate(userEvaluate);

        teachingResultsService.checkScoreRecord(teachId);


        System.out.println(quotaIds.toString());
        return Result.succ(quotaIds);
    }

    @PreAuthorize("hasAuthority('teacher:myEvaluate:list')")
    @GetMapping("/info/{id}/{userId}")
    public Result info(@PathVariable("id") Long id, @PathVariable("userId") Long userId ) {
        Boolean isInfo = userEvaluateService.isNewEvaluateInfo(id, userId);

        List<OptionsVo> optionsVos = new ArrayList<>();
        if (isInfo) {

            List<SysUserRole> sysUserRole=sysUserRoleService.listRoleByUserId(userId);

            optionsVos=optionVoService.listOptionsByRoleIdByMine(sysUserRole.get(0).getRoleId());

            return Result.succ(optionsVos);
        } else {


            return Result.succ(optionsVos);
        }
    }


    @PreAuthorize("hasAuthority('teacher:myEvaluate:list')")
    @GetMapping("/list")
    public Result list(Long batchId, Long userId) {

        Page<Teach> pageData = teachService.findAllByUserId(new Page<>(), batchId, userId);
        pageData.getRecords().forEach(u->{
            //教师信息
            u.setUsers(sysUserService.listUserByUserId(u.getTeacherId()));
            //学院信息
            u.setCollegeInfos(collegeInfoService.findById(u.getCollegeId()));
            //班级信息
            u.setClassInfos(classInfoService.findById(u.getClassId()));
            //课程信息
            u.setCourseInfos(courseInfoService.findById(u.getCourseId()));
        });


        return Result.succ(pageData);
    }

    @PreAuthorize("hasAuthority('teacher:myEvaluate:batch')")
    @GetMapping("/batch")
    public Result batch() {

        Page<Batch> pageData = batchService.findAll(new Page<>());

        return Result.succ(pageData);
    }


}

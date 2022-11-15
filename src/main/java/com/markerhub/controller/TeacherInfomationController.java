package com.markerhub.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.entity.vo.OptionsVo;
import com.markerhub.entity.vo.TeacherCollegeVo;
import com.markerhub.mapper.CourseResoureMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher/infomation")
public class TeacherInfomationController extends BaseController{

    @PostMapping("/options/{userId}/{teachId}")
    @PreAuthorize("hasAuthority('teacher:infomation:options')")
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

    @PreAuthorize("hasAuthority('teacher:infomation:list')")
    @GetMapping("/info/{id}/{userId}")
    public Result info(@PathVariable("id") Long id, @PathVariable("userId") Long userId ) {
        Boolean isInfo = userEvaluateService.isNewEvaluateInfo(id, userId);

        List<OptionsVo> optionsVos = new ArrayList<>();
        if (isInfo) {

            List<SysUserRole> sysUserRole=sysUserRoleService.listRoleByUserId(userId);

            optionsVos=optionVoService.listOptionsByRoleIdByTeacher(sysUserRole.get(0).getRoleId());

            return Result.succ(optionsVos);
        } else {


            return Result.succ(optionsVos);
        }

    }


    @PreAuthorize("hasAuthority('teacher:infomation:list')")
    @GetMapping("/list")
    public Result list(Long batchId, Long userId) {

        Page<Teach> pageData = teachService.findAllExcept(new Page<>(), batchId, userId);
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

    @PreAuthorize("hasAuthority('teacher:infomation:batch')")
    @GetMapping("/batch")
    public Result batch() {

        Page<Batch> pageData = batchService.findAll(new Page<>());

        return Result.succ(pageData);
    }


}

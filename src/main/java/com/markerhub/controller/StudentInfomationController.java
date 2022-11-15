package com.markerhub.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.entity.vo.OptionsVo;
import com.markerhub.mapper.CourseResoureMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student/infomation")
public class StudentInfomationController extends BaseController{

    @PostMapping("/options/{userId}/{teachId}")
    @PreAuthorize("hasAuthority('student:infomation:options')")
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



    @PreAuthorize("hasAuthority('student:infomation:list')")
    @GetMapping("/info/{id}/{userId}")
    public Result info(@PathVariable("id") Long id, @PathVariable("userId") Long userId ) {

        return newController.getCommonMethodByOptions(id, userId);

    }


    @PreAuthorize("hasAuthority('student:infomation:list')")
    @GetMapping("/list")
    public Result list(Long batchId) {

        List<StudentTeach> studentTeach=studentTeachService.findByBatchId(batchId);

        if(studentTeach.size()==0){
            return Result.succ(400,"该学期没有授课信息",null);
        }else{
            List<Long> teachId = new ArrayList<>();

            for (int i = 0 ; i< studentTeach.size(); i++) {
                teachId.add(studentTeach.get(i).getTeachId());
            }

            Page<Teach> pageData=teachService.findAllBybatchId(new Page<>(),batchId,teachId);
            pageData.getRecords().forEach(u->{
                //教师信息
                u.setUsers(sysUserService.listUserByCourseId(u.getCourseId()));
                //学院信息
                u.setCollegeInfos(collegeInfoService.findById(u.getCollegeId()));
                //班级信息
                u.setClassInfos(classInfoService.findById(u.getClassId()));
                //课程信息
                u.setCourseInfos(courseInfoService.findById(u.getCourseId()));
            });
            return Result.succ(pageData);
        }


    }

    @PreAuthorize("hasAuthority('student:infomation:batch')")
    @GetMapping("/batch")
    public Result batch() {

        Page<Batch> pageData = batchService.findAll(new Page<>());

        return Result.succ(pageData);
    }

    @Transactional
    @PostMapping("/back")
    @PreAuthorize("hasAuthority('student:infomation:back')")
    public Result delete(@RequestBody Long[] ids) {

        userCourseService.removeByIds(Arrays.asList(ids));
        return Result.succ("");
    }



}

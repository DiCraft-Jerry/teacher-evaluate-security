package com.markerhub.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student/train")
public class StudentTrainController extends BaseController{


    @PreAuthorize("hasAuthority('student:train:batch')")
    @GetMapping("/batch")
    public Result batch() {

        Page<Batch> pageData = batchService.findAll(new Page<>());

        return Result.succ(pageData);
    }

    @PreAuthorize("hasAuthority('student:train:list')")
    @GetMapping("/list")
    public Result list(Long batchId) {

        Page<Teach> pageData = teachService.findAll(new Page<>(), batchId);
        pageData.getRecords().forEach(u->{
            //课程信息
            u.setUsers(sysUserService.findById(u.getTeacherId()));
            u.setClassInfos(classInfoService.findById(u.getClassId()));
            u.setCourseInfos(courseInfoService.findById(u.getCourseId()));
            u.setCollegeInfos(collegeInfoService.findById(u.getCollegeId()));
            List<CourseInfo> courseInfoList = courseInfoService.findById(u.getCourseId());
            });


        return Result.succ(pageData);
    }

    @Transactional
    @PostMapping("/course/{teachId}/{userId}/{batchId}")
    @PreAuthorize("hasAuthority('student:train:course')")
    public Result rolePerm(@PathVariable("teachId") Long teachId,
                           @PathVariable("userId") Long userId,
                           @PathVariable("batchId") Long batchId
                           ) {

        List<StudentTeach> studentTeaches = new ArrayList<>();

        StudentTeach studentTeach = new StudentTeach();
        studentTeach.setTeachId(teachId);
        studentTeach.setStudentId(userId);
        studentTeach.setBatchId(batchId);
        studentTeaches.add(studentTeach);


        studentTeachService.remove(new QueryWrapper<StudentTeach>().eq("teach_id", teachId));
        studentTeachService.saveBatch(studentTeaches);


        return Result.succ("");
    }


}

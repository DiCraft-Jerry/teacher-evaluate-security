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

import java.util.Arrays;
import java.util.List;

/**
 * 课程信息
 */
@RestController
@RequestMapping("/work/grade")
public class WorkGradeController extends BaseController {


	@PreAuthorize("hasAuthority('work:grade:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		ExamScore examScore = examScoreService.getById(id);

		return Result.succ(examScore);
	}

	@PreAuthorize("hasAuthority('work:grade:list')")
	@GetMapping("/list")
	public Result list(String name) {

		Page<ExamScore> pageData = examScoreService.page(getPage(), new QueryWrapper<ExamScore>()
				.like(StrUtil.isNotBlank(name), "name", name));

		pageData.getRecords().forEach(u ->{
			UserCourse userCourse = userCourseService.getById(u.getScId());
			Catalogue catalogue = catalogueService.getById(u.getCaId());

			List<Batch> batcheList = batchService.findById(userCourse.getBatchId());
			List<SysUser> userList = sysUserService.listUserByUserId(userCourse.getUserId());
			List<CourseInfo> courseInfoList = courseInfoService.findById(userCourse.getCourseId());
			List<CourseResoure> courseResoure = courseResoureService.findById(catalogue.getResoureId());

			userCourse.setSysUserList(userList);
			userCourse.setCourseInfoList(courseInfoList);
			userCourse.setBatches(batcheList);
			catalogue.setCourseResoureList(courseResoure);

			u.setUserCourse(userCourse);
			u.setCatalogue(catalogue);

		});


		return Result.succ(pageData);
	}


	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:grade:update')")
	public Result update(@Validated @RequestBody ExamScore examScore) {
		examScoreService.updateById(examScore);
		return Result.succ(examScore);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:grade:delete')")
	public Result delete(@RequestBody Long[] ids) {

		examScoreService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}


}

package com.markerhub.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.entity.vo.TeacherCollegeVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 课程信息
 */
@RestController
@RequestMapping("/work/course")
public class WorkCourseController extends BaseController {


	@PreAuthorize("hasAuthority('work:course:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		CourseInfo courseInfo = courseInfoService.getById(id);

		List<Batch> batches = batchService.listBatchByCourseId(id);

		List<TeacherCollegeVo> teacherCollegeVos=teacherCollegeService.listTeacherByCourseId(id);

		courseInfo.setTeacherCollegeVos(teacherCollegeVos);
		courseInfo.setBatches(batches);

		return Result.succ(courseInfo);
	}

	@PreAuthorize("hasAuthority('work:course:list')")
	@GetMapping("/list")
	public Result list(String name) {

		Page<CourseInfo> pageData = courseInfoService.page(getPage(), new QueryWrapper<CourseInfo>()
				.like(StrUtil.isNotBlank(name), "name", name));


		pageData.getRecords().forEach(u ->{
			u.setBatches(batchService.listBatchByCourseId(u.getId()));
			u.setSysUserList(sysUserService.listUserByUserId(u.getPublisherId()));

		});


		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:course:save')")
	public Result save(@Validated @RequestBody CourseInfo courseInfo) {


//		courseInfo.setStatus(Const.STATUS_ON);
		courseInfoService.save(courseInfo);
		return Result.succ(courseInfo);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:course:update')")
	public Result update(@Validated @RequestBody CourseInfo courseInfo) {
		courseInfoService.updateById(courseInfo);
		return Result.succ(courseInfo);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:course:delete')")
	public Result delete(@RequestBody Long[] ids) {

		courseInfoService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}

	@Transactional
	@PostMapping("/batch/{courseId}")
	@PreAuthorize("hasAuthority('work:course:batch')")
	public Result rolePerm(@PathVariable("courseId") Long courseId, @RequestBody Long[] roleIds) {


		List<CourseBatch> courseBatches = new ArrayList<>();


		Arrays.stream(roleIds).forEach(r -> {

			CourseBatch courseBatch = new CourseBatch();
			courseBatch.setBatchId(r);
			courseBatch.setCourseId(courseId);

			courseBatches.add(courseBatch);

		});


		courseBatchService.remove(new QueryWrapper<CourseBatch>().eq("course_id", courseId));
		courseBatchService.saveBatch(courseBatches);


		// 删除缓存
		CourseInfo courseInfo = courseInfoService.getById(courseId);
		courseInfoService.clearUserAuthorityInfo(courseInfo.getName());


		return Result.succ("");
	}

	@Transactional
	@PostMapping("/teacher/{courseId}")

	public Result teacherPerm(@PathVariable("courseId") Long courseId, @RequestBody Long[] teacherIds) {

		List<TeacherCourse> teacherCourses = new ArrayList<>();

		Arrays.stream(teacherIds).forEach(r -> {
			TeacherCourse teacherCourse = new TeacherCourse();
			teacherCourse.setTeacherId(r);
			teacherCourse.setCourseId(courseId);

			teacherCourses.add(teacherCourse);

		});


		teacherCourseService.remove(new QueryWrapper<TeacherCourse>().eq("course_id", courseId));
		teacherCourseService.saveBatch(teacherCourses);


		// 删除缓存
		CourseInfo courseInfo = courseInfoService.getById(courseId);
		courseInfoService.clearUserAuthorityInfo(courseInfo.getName());


		return Result.succ("");
	}

}

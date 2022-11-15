package com.markerhub.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 授课信息
 */
@RestController
@RequestMapping("/work/teach")
public class WorkTeachController extends BaseController {


	@PreAuthorize("hasAuthority('work:teach:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		Teach teach = teachService.getById(id);
		return Result.succ(teach);
	}

	@PreAuthorize("hasAuthority('work:teach:list')")
	@GetMapping("/list")
	public Result list(Long batchId) {

		Page<Teach> pageData = teachService.findAll(new Page<>(), batchId);
		pageData.getRecords().forEach(u->{
			//学院信息
			u.setCollegeInfos((collegeInfoService.findById(u.getCollegeId())));
			//课程信息
			u.setCourseInfos(courseInfoService.findById(u.getCourseId()));
			//教师信息
			u.setUsers(sysUserService.findById(u.getTeacherId()));
			//班级信息
			u.setClassInfos(classInfoService.findById(u.getClassId()));
		});


		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:teach:save')")
	public Result save(@Validated @RequestBody Teach teach) {
		System.out.println(teach);
		teachService.save(teach);
		return Result.succ(teach);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:teach:update')")
	public Result update(@Validated @RequestBody Teach teach) {
		teachService.updateById(teach);

		return Result.succ(teach);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:teach:delete')")
	public Result delete(@RequestBody Long[] ids) {

		teachService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}


}

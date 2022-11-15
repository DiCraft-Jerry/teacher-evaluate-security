package com.markerhub.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.entity.vo.TeacherVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 学院信息
 */
@RestController
@RequestMapping("/work/teacher")
public class WorkTeacherController extends BaseController {


	@PreAuthorize("hasAuthority('work:teacher:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		CollegeInfo collegeInfo = collegeInfoService.getById(id);

		return Result.succ(collegeInfo);
	}

//	@PreAuthorize("hasAuthority('work:teacher:list')")
	@GetMapping("/list")
	public Result list() {

//		Page<TeacherCollegeVo> pageData=teacherCollegeService.findCTVo(new Page<>());

		Page<TeacherVo> pageData=teacherVoService.findCTVo(new Page<>());

		return Result.succ(pageData);
	}



}

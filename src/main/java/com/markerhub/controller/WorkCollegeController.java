package com.markerhub.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.Batch;
import com.markerhub.entity.CollegeInfo;
import com.markerhub.entity.CollegeTeacher;
import com.markerhub.entity.SysRoleMenu;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学院信息
 */
@RestController
@RequestMapping("/work/college")
public class WorkCollegeController extends BaseController {


	@PreAuthorize("hasAuthority('work:college:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		CollegeInfo collegeInfo = collegeInfoService.getById(id);

		return Result.succ(collegeInfo);
	}

	@PreAuthorize("hasAuthority('work:college:list')")
	@GetMapping("/list")
	public Result list(String name) {

		Page<CollegeInfo> pageData = collegeInfoService.page(getPage(), new QueryWrapper<CollegeInfo>()
				.like(StrUtil.isNotBlank(name), "name", name));



		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:college:save')")
	public Result save(@Validated @RequestBody CollegeInfo collegeInfo) {

//		batch.setStatus(Const.STATUS_ON);
		collegeInfoService.save(collegeInfo);
		return Result.succ(collegeInfo);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:college:update')")
	public Result update(@Validated @RequestBody CollegeInfo collegeInfo) {
		collegeInfoService.updateById(collegeInfo);

		return Result.succ(collegeInfo);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:college:delete')")
	public Result delete(@RequestBody Long[] ids) {

		collegeInfoService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}


}

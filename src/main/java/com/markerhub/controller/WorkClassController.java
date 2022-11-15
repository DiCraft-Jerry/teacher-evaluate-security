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
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 班级信息
 */
@RestController
@RequestMapping("/work/class")
public class WorkClassController extends BaseController {


	@PreAuthorize("hasAuthority('work:class:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		ClassInfo classInfo = classInfoService.getById(id);

		return Result.succ(classInfo);
	}

	@PreAuthorize("hasAuthority('work:class:list')")
	@GetMapping("/list")
	public Result list(String name) {

		Page<ClassInfo> pageData = classInfoService.page(getPage(), new QueryWrapper<ClassInfo>()
				.like(StrUtil.isNotBlank(name), "name", name));



		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:class:save')")
	public Result save(@Validated @RequestBody ClassInfo classInfo) {

		ClassInfo classList = classInfoService.findByName(classInfo.getName());
		System.out.println(classList);
		if(!Objects.isNull(classList)){
			return  Result.fail("该班级已存在！！！");
		}else{
			classInfoService.save(classInfo);
		}

		return Result.succ(classInfo);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:class:update')")
	public Result update(@Validated @RequestBody ClassInfo classInfo) {
		classInfoService.updateById(classInfo);

		return Result.succ(classInfo);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:class:delete')")
	public Result delete(@RequestBody Long[] ids) {

//		classInfoService.removeByIds(Arrays.asList(ids));

		// 删除授课表缓存
		Teach teachinfo = teachService.getById(ids);
		teachService.clearUserAuthorityInfo(teachinfo.getId());
		return Result.succ("");
	}


}

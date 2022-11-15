package com.markerhub.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.Batch;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 批次信息
 */
@RestController
@RequestMapping("/work/batch")
public class WorkBatchController extends BaseController {


	@PreAuthorize("hasAuthority('work:batch:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		Batch batch = batchService.getById(id);
		return Result.succ(batch);
	}

	@PreAuthorize("hasAuthority('work:batch:list')")
	@GetMapping("/list")
	public Result list(String bName) {

		Page<Batch> pageData = batchService.page(getPage(), new QueryWrapper<Batch>()
				.like(StrUtil.isNotBlank(bName), "b_name", bName));



		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:batch:save')")
	public Result save(@Validated @RequestBody Batch batch) {

//		batch.setStatus(Const.STATUS_ON);
		batchService.save(batch);
		return Result.succ(batch);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('work:batch:update')")
	public Result update(@Validated @RequestBody Batch batch) {
		batchService.updateById(batch);

		return Result.succ(batch);
	}

	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:batch:delete')")
	public Result delete(@RequestBody Long[] ids) {

		batchService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}


}

package com.markerhub.controller;


import cn.hutool.core.date.DateTime;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.markerhub.common.dto.SysMenuDto;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.listener.QuotaReadingListener;
import com.markerhub.service.QuotaOptionsService;
import com.markerhub.service.QuotaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sys/quota")
public class SysQuotaController extends BaseController {

	@Resource
	private QuotaService quotaService;

	@Resource
	private QuotaOptionsService quotaOptionsService;

	@RequestMapping("/upload")
	public Result upload(@RequestBody MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			System.out.println("----------------------------------------------------bbbb");
			return Result.fail("上件文件为空");
		} else {
			System.out.println("----------------------------------------------------aaaaa");
			EasyExcel.read(file.getInputStream(), new QuotaReadingListener(quotaService))
					.ignoreEmptyRow(true).sheet().doRead();
			quotaOptionsService.updateOptionsScore();
			return Result.succ("解析成功");
		}

	}

	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('sys:quota:list')")
	public Result info(@PathVariable(name = "id") Long id) {
		return Result.succ(quotaService.getById(id));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('sys:quota:list')")
	public Result list() {

		List<Quota> quotas = quotaService.tree();
		return Result.succ(quotas);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:quota:update')")
	public Result update(@Validated @RequestBody Quota quota) {
		quota.setUpdatedTime(DateTime.now());
		quotaService.updateById(quota);

		return Result.succ(quota);
	}

	@PostMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('sys:quota:delete')")
	public Result delete(@PathVariable("id") Long id) {

		quotaService.removeById(id);

		return Result.succ("");
	}


}

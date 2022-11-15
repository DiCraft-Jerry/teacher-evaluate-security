package com.markerhub.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Const;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.entity.vo.EvaluationVo;
import com.markerhub.service.EvaluationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 评教信息
 */
@RestController
@RequestMapping("/work/evaluation")
public class WorkEvaluationController extends BaseController {

	@PreAuthorize("hasAuthority('work:evaluation:role')")
	@GetMapping("/role")
	public Result role() {

		Page<SysRole> list = sysRoleService.findName(new Page<SysRole>());
		return Result.succ(list);
	}

	@PreAuthorize("hasAuthority('work:evaluation:list')")
	@GetMapping("/info/{id}")
	public Result info(@PathVariable("id") Long id) {

		Evaluation evaluation = evaluationService.getById(id);

		// 获取角色相关联的指标id
		List<SysRoleQuota> roleQuotas = sysRoleQuotaService.list(new QueryWrapper<SysRoleQuota>().eq("role_id", evaluation.getRoleId()));
		List<Long> quotaIds = roleQuotas.stream().map(p -> p.getQuotaId()).collect(Collectors.toList());

		evaluation.setQuotaIds(quotaIds);

		return Result.succ(evaluation);
	}


	@PreAuthorize("hasAuthority('work:evaluation:list')")
	@GetMapping("/list")
	public Result list(String name) {

		Page<EvaluationVo> pageData = evaluationVoService.listByRoleId(new Page<EvaluationVo>());

		return Result.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('work:evaluation:save')")
	public Result save(@Validated @RequestBody Evaluation evaluation) {
		evaluation.setStatus(Const.STATUS_ON);
		evaluationService.save(evaluation);
		return Result.succ(evaluation);
	}

	@PostMapping("/update/{id}/{status}")
	@PreAuthorize("hasAuthority('work:evaluation:update')")
	public Result update(@PathVariable("id") Long id, @PathVariable("status") Long status) {
		boolean a = evaluationService.updateStatusById(id, status);


		List<String> s = new ArrayList<>();
		if (a){
			s.add("123");
			return Result.succ(s);
		} else {
			return Result.succ(s);
		}



	}

	@PostMapping("/end/{id}/{status}")
	@PreAuthorize("hasAuthority('work:evaluation:end')")
	public Result updateEnd(@PathVariable("id") Long id, @PathVariable("status") Long status) {
		boolean a = evaluationService.updateStatusIsFalseById(id, status);

		List<String> s = new ArrayList<>();
		if (a){
			s.add("123");
			return Result.succ(s);
		} else {
			return Result.succ(s);
		}



	}


	@Transactional
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('work:evaluation:delete')")
	public Result delete(@RequestBody Long[] ids) {

		evaluationService.removeByIds(Arrays.asList(ids));
		return Result.succ("");
	}


	@Transactional
	@PostMapping("/perm/{roleId}")
	@PreAuthorize("hasAuthority('sys:evaluation:perm')")
	public Result info(@PathVariable("roleId") Long roleId, @RequestBody Long[] quotaIds) {

		List<SysRoleQuota> sysRoleQuotas = new ArrayList<>();

		Arrays.stream(quotaIds).forEach(quotaId -> {

			SysRoleQuota roleQuota = new SysRoleQuota();
			roleQuota.setQuotaId(quotaId);
			roleQuota.setRoleId(roleId);

			sysRoleQuotas.add(roleQuota);
		});

		// 先删除原来的记录，再保存新的
		sysRoleQuotaService.remove(new QueryWrapper<SysRoleQuota>().eq("role_id", roleId));
		sysRoleQuotaService.saveBatch(sysRoleQuotas);

		// 删除缓存
//		sysUserService.clearUserAuthorityInfoByRoleId(roleId);

		return Result.succ(quotaIds);
	}
}

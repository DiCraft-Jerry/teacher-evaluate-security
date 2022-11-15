package com.markerhub.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.controller.NewController;
import com.markerhub.service.*;
import com.markerhub.service.voService.TeacherVoService;
import com.markerhub.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class BaseController {

	@Autowired
	HttpServletRequest req;

	@Autowired
	RedisUtil redisUtil;

	@Autowired
	SysUserService sysUserService;

	@Autowired
	SysRoleService sysRoleService;

	@Autowired
	SysMenuService sysMenuService;

	@Autowired
	SysUserRoleService sysUserRoleService;

	@Autowired
	SysRoleMenuService sysRoleMenuService;

	@Autowired
	CourseInfoService courseInfoService;

	@Autowired
	BatchService batchService;

	@Autowired
	CourseBatchService courseBatchService;


	@Autowired
	CourseResoureService courseResoureService;

	@Autowired
	CatalogueService catalogueService;

	@Autowired
	UserCourseService userCourseService;

	@Autowired
	StudyRecordService studyRecordService;

	@Autowired
	ExamScoreService examScoreService;

	@Autowired
	QuotaService quotaService;

	@Autowired
	CollegeInfoService collegeInfoService;

	@Autowired
	ClassInfoService classInfoService;

	@Autowired
	EvaluationService evaluationService;

	@Autowired
	CollegeTeacherService collegeTeacherService;

	@Autowired
	TeacherCollegeService teacherCollegeService;

	@Autowired
	TeacherVoService teacherVoService;

	@Autowired
	TeacherCourseService teacherCourseService;

	@Autowired
	StudentClassService studentClassService;

	@Autowired
	TeachService teachService;

	@Autowired
	EvaluationVoService evaluationVoService;

	@Autowired
	SysRoleQuotaService sysRoleQuotaService;

	@Autowired
	QuotaOptionsService quotaOptionsService;

	@Autowired
	OptionVoService optionVoService;

	@Autowired
	StudentTeachService studentTeachService;

	@Autowired
	UserEvaluateService userEvaluateService;

	@Autowired
	TeachingResultsService teachingResultsService;

	@Autowired
	ScoreResultService scoreResultService;

	@Resource
	NewController newController;

	/**
	 * 获取页面
	 * @return
	 */
	public Page getPage() {
		int current = ServletRequestUtils.getIntParameter(req, "cuurent", 1);
		int size = ServletRequestUtils.getIntParameter(req, "size", 10);

		return new Page(current, size);
	}

}

package com.markerhub.common.controller;

import com.markerhub.common.lang.Result;
import com.markerhub.controller.BaseController;
import com.markerhub.entity.SysUserRole;
import com.markerhub.entity.vo.OptionsVo;
import com.markerhub.service.OptionVoService;
import com.markerhub.service.SysUserRoleService;
import com.markerhub.service.UserEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dicraft
 */
@Component
public class NewController {

    @Autowired
    OptionVoService optionVoService;

    @Autowired
    UserEvaluateService userEvaluateService;

    @Autowired
    SysUserRoleService sysUserRoleService;

    public Result getCommonMethodByOptions( Long id, Long userId) {
        Boolean isInfo = userEvaluateService.isNewEvaluateInfo(id, userId);

        List<OptionsVo> optionsVos = new ArrayList<>();
        if (isInfo) {


            List<SysUserRole> sysUserRole=sysUserRoleService.listRoleByUserId(userId);

            optionsVos=optionVoService.listOptionsByRoleId(sysUserRole.get(0).getRoleId());

            return Result.succ(optionsVos);
        } else {


            return Result.succ(optionsVos);
        }
    }

}

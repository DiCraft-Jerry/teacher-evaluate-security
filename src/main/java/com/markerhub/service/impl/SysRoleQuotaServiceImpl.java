package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysRoleQuota;
import com.markerhub.service.SysRoleQuotaService;
import com.markerhub.mapper.SysRoleQuotaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【sys_role_quota】的数据库操作Service实现
* @createDate 2022-11-08 11:40:50
*/
@Service
public class SysRoleQuotaServiceImpl extends ServiceImpl<SysRoleQuotaMapper, SysRoleQuota>
    implements SysRoleQuotaService{

    @Resource
    private SysRoleQuotaMapper sysRoleQuotaMapper;

}





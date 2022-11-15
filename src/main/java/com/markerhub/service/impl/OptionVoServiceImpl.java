package com.markerhub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.vo.OptionsVo;
import com.markerhub.mapper.QuotaOptionsMapper;
import com.markerhub.mapper.voMapper.OptionsVoMapper;
import com.markerhub.service.OptionVoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* @author ASUS
* @description 针对表【batch】的数据库操作Service实现
* @createDate 2022-10-05 10:29:04
*/
@Service
public class OptionVoServiceImpl extends ServiceImpl<OptionsVoMapper, OptionsVo>
    implements OptionVoService {


    @Resource
    private OptionsVoMapper optionsVoMapper;

    @Override
    public List<OptionsVo> listOptionsByRoleId(Long roleId) {

        return optionsVoMapper.listOptionsByRoleId(roleId);
    }

    @Override
    public List<OptionsVo> listOptionsByRoleIdByTeacher(Long roleId) {
        return optionsVoMapper.listOptionsByRoleIdByTeacher(roleId);
    }

    @Override
    public List<OptionsVo> listOptionsByRoleIdByMine(Long roleId) {
        return optionsVoMapper.listOptionsByRoleIdByMine(roleId);
    }
}





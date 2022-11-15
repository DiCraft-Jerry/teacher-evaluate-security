package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CollegeInfo;
import com.markerhub.entity.SysRole;
import com.markerhub.service.CollegeInfoService;
import com.markerhub.mapper.CollegeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_info】的数据库操作Service实现
* @createDate 2022-10-24 10:52:24
*/
@Service
public class CollegeInfoServiceImpl extends ServiceImpl<CollegeInfoMapper, CollegeInfo>
    implements CollegeInfoService{

    @Autowired
    private CollegeInfoMapper collegeInfoMapper;

    @Override
    public List<CollegeInfo> listCollegeByUserId(Long userId) {
        List<CollegeInfo> collegeInfoList = this.list(new QueryWrapper<CollegeInfo>()
                .inSql("id", "select college_id from college_teacher where user_id = " + userId));

        return collegeInfoList;
    }

    @Override
    public List<CollegeInfo> findById(Long collegeId) {
        return collegeInfoMapper.findById(collegeId);
    }


}





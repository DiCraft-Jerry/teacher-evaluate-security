package com.markerhub.service;

import com.markerhub.entity.CollegeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysRole;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_info】的数据库操作Service
* @createDate 2022-10-24 10:52:24
*/
public interface CollegeInfoService extends IService<CollegeInfo> {

    /**
     * 根据用户id查学院信息
     * @param userId
     * @return
     */
    List<CollegeInfo> listCollegeByUserId(Long userId);


    List<CollegeInfo> findById(Long collegeId);
}

package com.markerhub.mapper;

import com.markerhub.entity.CollegeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_info】的数据库操作Mapper
* @createDate 2022-10-24 10:52:24
* @Entity com.markerhub.entity.CollegeInfo
*/
public interface CollegeInfoMapper extends BaseMapper<CollegeInfo> {

    List<CollegeInfo> findById(Long collegeId);
}





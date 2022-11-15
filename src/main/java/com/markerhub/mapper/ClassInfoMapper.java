package com.markerhub.mapper;

import com.markerhub.entity.ClassInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【class_info】的数据库操作Mapper
* @createDate 2022-10-24 11:05:37
* @Entity com.markerhub.entity.ClassInfo
*/
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {

    ClassInfo findByName(String name);


    List<ClassInfo> findById(Long classId);
}





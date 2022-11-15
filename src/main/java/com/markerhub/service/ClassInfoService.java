package com.markerhub.service;

import com.markerhub.entity.ClassInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.CollegeInfo;

import java.util.List;

/**
* @author ASUS
* @description 针对表【class_info】的数据库操作Service
* @createDate 2022-10-24 11:05:37
*/
public interface ClassInfoService extends IService<ClassInfo> {

    /**
     * 根据用户id查班级信息
     * @param userId
     * @return
     */
    List<ClassInfo> listClassByUserId(Long userId);

    /**
     * 查班级名称
     * @param name
     * @return
     */
    ClassInfo findByName(String name);

    List<ClassInfo> findById(Long classId);
}

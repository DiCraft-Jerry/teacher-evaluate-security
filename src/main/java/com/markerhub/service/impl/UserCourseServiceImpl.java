package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CourseBatch;
import com.markerhub.entity.UserCourse;
import com.markerhub.mapper.UserCourseMapper;
import com.markerhub.service.UserCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author ASUS
* @description 针对表【user_course】的数据库操作Service实现
* @createDate 2022-10-08 23:12:30
*/
@Service
public class UserCourseServiceImpl extends ServiceImpl<UserCourseMapper, UserCourse>
    implements UserCourseService{

    @Resource
    private UserCourseMapper userCourseMapper;

    @Override
    public Page<UserCourse> finAllCT(Page<UserCourse> page, Long batchId) {
        return userCourseMapper.finAllCT(page,batchId);
    }

    @Override
    public Page<UserCourse> findAll(Page<UserCourse> page, Long batchId,Long userId) {
        return userCourseMapper.finAll(page,batchId,userId);
    }



}





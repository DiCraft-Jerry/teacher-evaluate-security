package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CourseInfo;
import com.markerhub.mapper.CourseInfoMapper;
import com.markerhub.service.CourseInfoService;
import com.markerhub.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【course_info】的数据库操作Service实现
* @createDate 2022-10-05 10:29:04
*/
@Service
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo>
    implements CourseInfoService{

    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<CourseInfo> listCourseByResoureId(Long resoureId) {

        List<CourseInfo> courseInfoList=this.list(new QueryWrapper<CourseInfo>()
                .inSql("id","select course_id from catalogue where resoure_id="+resoureId));


        return courseInfoList;
    }

    @Override
    public List<CourseInfo> findById(Long courseId) {
        List<CourseInfo> courseInfoList = courseInfoMapper.findById(courseId);
        return courseInfoList;
    }

    @Override
    public void clearUserAuthorityInfo(String name) {
        redisUtil.del("Course:" + name);
    }

    @Override
    public List<CourseInfo> listCourseBybatchId(Long batchId) {

        List<CourseInfo> courseInfoList=this.list(new QueryWrapper<CourseInfo>()
                .inSql("id","select course_id from course_batch where batch_id="+batchId));

        return courseInfoList;
    }

    @Override
    public Page<CourseInfo> finAll(Page<CourseInfo> page, Long courseId) {
        return courseInfoMapper.finAll(page,courseId);
    }
}





package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.CourseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【course_info】的数据库操作Mapper
* @createDate 2022-10-05 10:29:04
* @Entity com.markerhub.entity.CourseInfo
*/
@Mapper
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {

    List<CourseInfo> findById(Long courseId);

    Page<CourseInfo> finAll(Page<CourseInfo> page, Long courseId);
}





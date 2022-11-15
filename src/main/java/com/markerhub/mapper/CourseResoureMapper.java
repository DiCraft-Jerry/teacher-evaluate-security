package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.CourseResoure;

import java.util.List;

/**
* @author ASUS
* @description 针对表【course_resoure】的数据库操作Mapper
* @createDate 2022-10-07 17:44:48
* @Entity com.markerhub.entity.CourseResoure
*/
public interface CourseResoureMapper extends BaseMapper<CourseResoure> {

    List<CourseResoure> findById(Long id);

    Page<CourseResoure> finAll(Page<CourseResoure> page, Long id);
}





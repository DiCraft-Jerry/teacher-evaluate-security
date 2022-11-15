package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user_course】的数据库操作Mapper
* @createDate 2022-10-08 23:12:30
* @Entity com.markerhub.entity.UserCourse
*/
@Mapper
public interface UserCourseMapper extends BaseMapper<UserCourse> {

    Page<UserCourse> finAllCT(Page<UserCourse> page,Long batchId);

    Page<UserCourse> finAll(Page<UserCourse> page,Long batchId,Long userId);
}





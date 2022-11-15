package com.markerhub.mapper;

import com.markerhub.entity.StudentTeach;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【student_teach】的数据库操作Mapper
* @createDate 2022-11-12 20:09:12
* @Entity com.markerhub.entity.StudentTeach
*/
public interface StudentTeachMapper extends BaseMapper<StudentTeach> {

    List<StudentTeach> findByBatchId(Long batchId);
}





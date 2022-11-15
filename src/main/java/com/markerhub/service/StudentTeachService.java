package com.markerhub.service;

import com.markerhub.entity.StudentTeach;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ASUS
* @description 针对表【student_teach】的数据库操作Service
* @createDate 2022-11-12 20:09:12
*/
public interface StudentTeachService extends IService<StudentTeach> {

    List<StudentTeach> findByBatchId(Long batchId);
}

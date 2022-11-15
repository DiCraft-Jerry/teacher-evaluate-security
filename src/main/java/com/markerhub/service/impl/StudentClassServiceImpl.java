package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.StudentClass;
import com.markerhub.service.StudentClassService;
import com.markerhub.mapper.StudentClassMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【student_class】的数据库操作Service实现
* @createDate 2022-11-01 08:42:13
*/
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassMapper, StudentClass>
    implements StudentClassService{

}





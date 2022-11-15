package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.StudentTeach;
import com.markerhub.service.StudentTeachService;
import com.markerhub.mapper.StudentTeachMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【student_teach】的数据库操作Service实现
* @createDate 2022-11-12 20:09:12
*/
@Service
public class StudentTeachServiceImpl extends ServiceImpl<StudentTeachMapper, StudentTeach>
    implements StudentTeachService{

    @Resource
    private StudentTeachMapper studentTeachMapper;
    @Override
    public List<StudentTeach> findByBatchId(Long batchId) {
        return studentTeachMapper.findByBatchId(batchId);
    }
}





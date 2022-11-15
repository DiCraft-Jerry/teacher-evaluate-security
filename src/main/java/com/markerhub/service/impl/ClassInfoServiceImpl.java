package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.ClassInfo;
import com.markerhub.service.ClassInfoService;
import com.markerhub.mapper.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ASUS
* @description 针对表【class_info】的数据库操作Service实现
* @createDate 2022-10-24 11:05:37
*/
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo>
    implements ClassInfoService{

    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public List<ClassInfo> listClassByUserId(Long userId) {
        List<ClassInfo> classInfoList=this.list(new QueryWrapper<ClassInfo>()
        .inSql("id","select class_id from student_class where student_id="+userId));
        return classInfoList;
    }

    @Override
    public ClassInfo findByName(String name) {
        return classInfoMapper.findByName(name);
    }

    @Override
    public List<ClassInfo> findById(Long classId) {
        return classInfoMapper.findById(classId);
    }


}





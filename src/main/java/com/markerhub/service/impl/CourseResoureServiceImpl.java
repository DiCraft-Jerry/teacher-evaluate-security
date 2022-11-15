package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.CourseResoure;
import com.markerhub.mapper.CourseResoureMapper;
import com.markerhub.service.CourseResoureService;
import com.markerhub.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author ASUS
* @description 针对表【course_resoure】的数据库操作Service实现
* @createDate 2022-10-07 17:44:48
*/
@Service
public class CourseResoureServiceImpl extends ServiceImpl<CourseResoureMapper, CourseResoure>
    implements CourseResoureService{
    @Autowired
    RedisUtil redisUtil;

    @Resource
    private CourseResoureMapper courseResoureMapper;

    @Override
    public List<CourseResoure> findById(Long id) {
        return courseResoureMapper.findById(id);
    }

    @Override
    public List<CourseResoure> listResoureByCourseId(Long courseId) {
        List<CourseResoure> courseResoures=this.list(new QueryWrapper<CourseResoure>()
                .inSql("id","select resoure_id from catalogue where course_id="+courseId));

        return courseResoures;
    }

    @Override
    public void clearUserAuthorityInfo(String name) {
        redisUtil.del("GrantedAuthority:" + name);
    }

    @Override
    public Page<CourseResoure> finAll(Page<CourseResoure> page, Long id) {
        return courseResoureMapper.finAll(page,id);
    }
}





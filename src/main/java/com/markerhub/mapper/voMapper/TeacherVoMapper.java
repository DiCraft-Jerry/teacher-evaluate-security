package com.markerhub.mapper.voMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.vo.TeacherCollegeVo;
import com.markerhub.entity.vo.TeacherVo;

import java.util.List;

/**
* @author ASUS
* @description 针对表【college_teacher】的数据库操作Mapper
* @createDate 2022-10-25 10:01:51
* @Entity com.markerhub.entity.CollegeTeacher
*/
public interface TeacherVoMapper extends BaseMapper<TeacherVo> {

    Page<TeacherVo> findCTVo(Page<TeacherVo> page);


}





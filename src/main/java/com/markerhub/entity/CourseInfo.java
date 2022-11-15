package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.markerhub.entity.vo.TeacherCollegeVo;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @TableName course_info
 */
@TableName(value ="course_info")
@Data
public class CourseInfo implements Serializable {
    /**
     * 课程ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 发布人
     */
    @TableField(value = "publisher_id")
    private Long publisherId;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<Batch> batches=new ArrayList<>();

    @TableField(exist = false)
    private List<SysUser> sysUserList=new ArrayList<>();

    @TableField(exist = false)
    private List<CourseResoure> courseResoures=new ArrayList<>();

    @TableField(exist = false)
    private List<CollegeTeacher> collegeTeachers=new ArrayList<>();

    @TableField(exist = false)
    private List<TeacherCollegeVo> teacherCollegeVos=new ArrayList<>();

}

package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @TableName user_course
 */
@TableName(value ="user_course")
@Data
public class UserCourse implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 课程ID
     */
    @TableField(value = "course_id")
    private Long courseId;

    /**
     * 批次ID
     */
    @TableField(value = "batch_id")
    private Long batchId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<SysUser> sysUserList=new ArrayList<>();

    @TableField(exist = false)
    private List<CourseInfo> courseInfoList=new ArrayList<>();

    @TableField(exist = false)
    private List<Batch> batches=new ArrayList<>();

    @TableField(exist = false)
    private List<CollegeInfo> collegeInfos=new ArrayList<>();
}

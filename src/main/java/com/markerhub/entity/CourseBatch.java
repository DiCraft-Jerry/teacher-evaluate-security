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
 * @TableName course_batch
 */
@TableName(value ="course_batch")
@Data
public class CourseBatch implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次ID
     */
    @TableField(value = "batch_id")
    private Long batchId;

    /**
     * 课程ID
     */
    @TableField(value = "course_id")
    private Long courseId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<CourseInfo> courseInfos=new ArrayList<>();

    @TableField(exist = false)
    private List<SysUser> users=new ArrayList<>();

    @TableField(exist = false)
    private List<ClassInfo> classInfos=new ArrayList<>();

    @TableField(exist = false)
    private List<CollegeInfo> collegeInfos=new ArrayList<>();
}

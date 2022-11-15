package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 *
 * @TableName teach
 */
@TableName(value ="teach")
@Data
public class Teach implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学期id
     */
    @TableField(value = "batch_id")
    private Long batchId;

    /**
     * 学院id
     */
    @TableField(value = "college_id")
    private Long collegeId;

    /**
     * 教师id
     */
    @TableField(value = "teacher_id")
    private Long teacherId;

    /**
     * 班级id
     */
    @TableField(value = "class_id")
    private Long classId;

    /**
     * 课程id
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

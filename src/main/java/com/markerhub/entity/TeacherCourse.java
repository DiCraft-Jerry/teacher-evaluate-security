package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName teacher_course
 */
@TableName(value ="teacher_course")
@Data
public class TeacherCourse implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师id
     */
    @TableField(value = "teacher_id")
    private Long teacherId;

    /**
     * 课程id
     */
    @TableField(value = "course_id")
    private Long courseId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName student_class
 */
@TableName(value ="student_class")
@Data
public class StudentClass implements Serializable {
    /**
     * 学院班级ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学院ID
     */
    @TableField(value = "student_id")
    private Long studentId;

    /**
     * 班级ID
     */
    @TableField(value = "class_id")
    private Long classId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName student_teach
 */
@TableName(value ="student_teach")
@Data
public class StudentTeach implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学期Id
     */
    @TableField(value = "batch_id")
    private Long batchId;

    /**
     * 授课表id
     */
    @TableField(value = "teach_id")
    private Long teachId;

    /**
     * 学生id
     */
    @TableField(value = "student_id")
    private Long studentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

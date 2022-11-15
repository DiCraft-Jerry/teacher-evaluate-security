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
 * @TableName study_record
 */
@TableName(value ="study_record")
@Data
public class StudyRecord implements Serializable {
    /**
     * 学习时间表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次ID
     */
    @TableField(value = "b_id")
    private Long bId;

    /**
     * 学生课程表ID
     */
    @TableField(value = "sc_id")
    private Long scId;

    /**
     * 课件表ID
     */
    @TableField(value = "sr_id")
    private Long srId;

    /**
     * 学习时间
     */
    @TableField(value = "time")
    private Integer time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<Batch> batches=new ArrayList<>();

    @TableField(exist = false)
    private UserCourse userCourse=new UserCourse();

    @TableField(exist = false)
    private List<CourseResoure> courseResoure=new ArrayList<>();

}

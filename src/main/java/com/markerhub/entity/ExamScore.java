package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName exam_score
 */
@TableName(value ="exam_score")
@Data
public class ExamScore implements Serializable {
    /**
     * 成绩分析表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生课程表ID
     */
    @TableField(value = "sc_id")
    private Integer scId;

    /**
     * 成绩分数
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 目录表
     */
    @TableField(value = "ca_id")
    private Integer caId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private UserCourse userCourse=new UserCourse();

    @TableField(exist = false)
    private Catalogue catalogue=new Catalogue();
}

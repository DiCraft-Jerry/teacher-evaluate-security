package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName score_result
 */
@TableName(value ="score_result")
@Data
public class ScoreResult implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *  授课表id
     */
    @TableField(value = "teach_id")
    private Integer teachId;

    /**
     * 分数
     */
    @TableField(value = " score")
    private String score;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
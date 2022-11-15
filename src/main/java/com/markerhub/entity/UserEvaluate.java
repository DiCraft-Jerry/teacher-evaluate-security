package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName user_evaluate
 */
@TableName(value ="user_evaluate")
@Data
public class UserEvaluate implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 本次评教得分
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 得分
     */
    @TableField(value = "first_score")
    private String firstScore;


    /**
     * 授课id
     */
    @TableField(value = "teach_id")
    private Integer teachId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

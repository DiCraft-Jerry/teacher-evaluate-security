package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName quota_options
 */
@TableName(value ="quota_options")
@Data
public class QuotaOptions implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 指标id
     */
    @TableField(value = "quota_id")
    private Integer quotaId;

    /**
     * 选项名称
     */
    @TableField(value = "options_name")
    private String optionsName;

    /**
     * 分数
     */
    @TableField(value = "score")
    private Integer score;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
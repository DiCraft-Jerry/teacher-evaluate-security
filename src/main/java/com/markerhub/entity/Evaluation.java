package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 *
 * @TableName evaluation
 */
@TableName(value ="evaluation")
@Data
public class Evaluation implements Serializable {
    /**
     * 评教ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     *
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     *
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<Long> quotaIds = new ArrayList<>();
}

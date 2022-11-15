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
 * @TableName college_info
 */
@TableName(value ="college_info")
@Data
public class CollegeInfo implements Serializable {
    /**
     * 学院id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}

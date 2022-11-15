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
 * @TableName college_teacher
 */
@TableName(value ="college_teacher")
@Data
public class CollegeTeacher implements Serializable {
    /**
     * 学院教师表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院id
     */
    @TableField(value = "college_id")
    private Long collegeId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    @TableField(exist = false)
    private List<SysUser> teachers = new ArrayList<>();
}

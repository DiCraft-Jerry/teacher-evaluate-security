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
 * @TableName catalogue
 */
@TableName(value ="catalogue")
@Data
public class Catalogue implements Serializable {
    /**
     * 目录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程id
     */
    @TableField(value = "course_id")
    private Long courseId;

    /**
     * 资料id
     */
    @TableField(value = "resoure_id")
    private Long resoureId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<CourseResoure> courseResoureList=new ArrayList<>();

}

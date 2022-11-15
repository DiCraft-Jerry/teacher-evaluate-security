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
 * @TableName course_resoure
 */
@TableName(value ="course_resoure")
@Data
public class CourseResoure implements Serializable {
    /**
     * 课程资源表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资料名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 资料类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 文件大小（kb)
     */
    @TableField(value = "size")
    private Long size;

    /**
     * 资料地址
     */
    @TableField(value = "c_id")
    private Integer cId;

    /**
     * 下载链接
     */
    @TableField(value = "url")
    private String url;

    /**
     * 文件md5
     */
    @TableField(value = "md5")
    private String md5;

    /**
     * 学习时间
     */
    @TableField(value = "study_time")
    private String studyTime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     * 是否禁用链接
     */
    @TableField(value = "enable")
    private Integer enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<CourseInfo> courseInfoList=new ArrayList<>();
}

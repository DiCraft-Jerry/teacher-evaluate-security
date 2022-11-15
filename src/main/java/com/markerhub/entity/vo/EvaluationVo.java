package com.markerhub.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ASUS
 */
@Data
public class EvaluationVo {
    /**
     * 评教id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String name;

    /**
     * 评教开启时间
     */
    private Date startTime;
    /**
     * 评教结束时间
     */
    private Date endTime;
    /**
     * 评教状态
     */
    private Integer status;

}

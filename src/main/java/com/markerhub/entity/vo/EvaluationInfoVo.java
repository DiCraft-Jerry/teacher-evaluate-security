package com.markerhub.entity.vo;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-11-14 12:36
 * @package: com.markerhub.entity.vo
 * @Version: 1.0
 * @Decsription:
 */

@Data
public class EvaluationInfoVo {
    Integer id;
    Integer userId;
    String userName;
    String roleName;
    String score;
    String teacherName;
    String courseName;
    String batchName;

}

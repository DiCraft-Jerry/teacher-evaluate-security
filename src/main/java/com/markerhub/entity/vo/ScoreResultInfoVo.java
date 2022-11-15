package com.markerhub.entity.vo;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-11-14 19:15
 * @package: com.markerhub.entity.vo
 * @Version: 1.0
 * @Decsription:
 */
@Data
public class ScoreResultInfoVo {
    Integer id;
    String teacherName;
    Integer teacherId;
    String batchName;
    String courseName;
    String collegeName;
    String className;
    String score;
}

package com.markerhub.entity.vo;

import lombok.Data;

@Data
public class TeacherCollegeVo {
    private Long id;
    private Long userId;
    private Long collegeId;
    private Long roleId;
    private String username;
    private String name;
}

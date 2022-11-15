package com.markerhub.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ASUS
 */
@Data
public class OptionsVo {

    private Long id;

    private Long quotaId;

    private String quotaName;

    private String quotaRight;

    private String optionsName;

    private Long score;

}

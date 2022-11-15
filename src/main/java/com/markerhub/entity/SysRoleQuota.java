package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName sys_role_quota
 */
@TableName(value ="sys_role_quota")
@Data
public class SysRoleQuota implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     *
     */
    @TableField(value = "quota_id")
    private Long quotaId;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

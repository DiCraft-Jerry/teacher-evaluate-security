package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 *
 * @TableName quota
 */
@TableName(value ="quota")
@Data
public class Quota implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 指标名称
     */
    private String quotaName;

    /**
     * 权重
     */
    private String quotaRight;

    /**
     * 父指标id
     */
    private int parentId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */

    private Date updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Quota other = (Quota) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getQuotaName() == null ? other.getQuotaName() == null : this.getQuotaName().equals(other.getQuotaName()))
                && (this.getQuotaRight() == null ? other.getQuotaRight() == null : this.getQuotaRight().equals(other.getQuotaRight()))
                && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
                && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQuotaName() == null) ? 0 : getQuotaName().hashCode());
        result = prime * result + ((getQuotaRight() == null) ? 0 : getQuotaRight().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", quotaName=").append(quotaName);
        sb.append(", quotaRight=").append(quotaRight);
        sb.append(", parentId=").append(parentId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @TableField(exist = false)
    private List<Quota> children = new ArrayList<>();


}

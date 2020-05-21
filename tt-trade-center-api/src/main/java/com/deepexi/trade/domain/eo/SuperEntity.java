package com.deepexi.trade.domain.eo;

import com.baomidou.mybatisplus.annotation.*;
import com.deepexi.util.config.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SuperEntity implements Serializable {

    private static final long serialVersionUID = -3023221879862316801L;

    private String id;

    //多租户标识
    @TableField(fill = FieldFill.INSERT)
    private String tenantCode;

    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    //@JsonSerialize(using = JsonDateSerializer.class)
    private Date createdAt;

    @TableField(fill = FieldFill.UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.UPDATE)
    //@JsonSerialize(using = JsonDateSerializer.class)
    private Date updatedAt;

    @TableLogic
    private Integer dr = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static List<String> toListSplit(String str){
        return Arrays.asList(str.split(","));
    }
}
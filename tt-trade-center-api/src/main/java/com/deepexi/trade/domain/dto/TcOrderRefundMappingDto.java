package com.deepexi.trade.domain.dto;

import com.deepexi.trade.domain.eo.TcOrderRefundMapping;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/**
 * @desc tc_order_refund_mapping
 * @author admin
 */
public class TcOrderRefundMappingDto implements Serializable {
    private String id;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private Integer  version;

    private Boolean dr;

    private String tenantCode;

    private String refundOrderId;

    private Boolean refundStatus;

    private String refundTransNo;


    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public Date getCreatedAt(){
        return this.createdAt;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public String getCreatedBy(){
        return this.createdBy;
    }

    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt(){
        return this.updatedAt;
    }

    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy(){
        return this.updatedBy;
    }

    public void setVersion(Integer  version){
        this.version = version;
    }

    public Integer  getVersion(){
        return this.version;
    }

    public void setDr(Boolean dr){
        this.dr = dr;
    }

    public Boolean getDr(){
        return this.dr;
    }

    public void setTenantCode(String tenantCode){
        this.tenantCode = tenantCode;
    }

    public String getTenantCode(){
        return this.tenantCode;
    }

    public void setRefundOrderId(String refundOrderId){
        this.refundOrderId = refundOrderId;
    }

    public String getRefundOrderId(){
        return this.refundOrderId;
    }

    public void setRefundStatus(Boolean refundStatus){
        this.refundStatus = refundStatus;
    }

    public Boolean getRefundStatus(){
        return this.refundStatus;
    }

    public void setRefundTransNo(String refundTransNo){
        this.refundTransNo = refundTransNo;
    }

    public String getRefundTransNo(){
        return this.refundTransNo;
    }
}


package com.deepexi.trade.domain.vo.orderdetail;


import com.deepexi.trade.domain.eo.TcOrderRefundWater;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @Author: lc_xin.
 * @Date: 2019/4/25 14:31
 */
public class OrderRefundInfo implements Serializable{


    //@ApiModelProperty(value = "订单关联id")
    private String orderId;
    //@ApiModelProperty(value = "订单状态: 1、待退款 4、退款成功 6、退款中")
    private Integer refundStatus;
    //@ApiModelProperty(value = "退款订单号")
    private String refundNo;
    //@ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;
    //@ApiModelProperty(value = "退款方式：1、原路退款")
    private Integer refundType;
    //@ApiModelProperty(value = "退款操作类型：1、过期自动退款")
    private Integer refundOperationType;
    //@ApiModelProperty(value = "退款成功时间")
    private Date refundTime;
    //@ApiModelProperty(value = "退款映射表成功的订单号")
    private String refundTransNo;
    //@ApiModelProperty(value = "退款流水号(第三方的退款订单号)")
    private String refundThirdOrderNo;

    private String id;

    private String tenantCode;

    private Integer version;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    private Integer dr;

    /**
     * 支付方式(原路的支付方式就是退款的原路)
     */
    private Integer payType;

    /**
     * 退款的流程进度流水
     */
    List<TcOrderRefundWater> refundWaterList;

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public Integer getRefundOperationType() {
        return refundOperationType;
    }

    public void setRefundOperationType(Integer refundOperationType) {
        this.refundOperationType = refundOperationType;
    }

    public List<TcOrderRefundWater> getRefundWaterList() {
        return refundWaterList;
    }

    public void setRefundWaterList(List<TcOrderRefundWater> refundWaterList) {
        this.refundWaterList = refundWaterList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefundTransNo() {
        return refundTransNo;
    }

    public void setRefundTransNo(String refundTransNo) {
        this.refundTransNo = refundTransNo;
    }

    public String getRefundThirdOrderNo() {
        return refundThirdOrderNo;
    }

    public void setRefundThirdOrderNo(String refundThirdOrderNo) {
        this.refundThirdOrderNo = refundThirdOrderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}


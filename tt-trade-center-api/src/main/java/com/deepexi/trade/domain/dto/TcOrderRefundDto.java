package com.deepexi.trade.domain.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @desc tc_order_refund
 * @author admin
 */
public class TcOrderRefundDto implements Serializable {

    //退款表id
    private String id;

    //订单表的id
    private String orderId;

    //编号
    @NotNull(message = "订单号不能为空")
    private String orderNo;

    /**
     * 商品id
     */
    @NotNull(message = "商品ID不能为空")
    private String awardId ;

    /**
     * 商品类型 1、单商品  2、组合优惠商品
     */
    private Integer awardType;

    /**
     * 退款件数
     */
    @NotNull(message = "退款件数不能为空")
    private Integer refundCount;

    /**
     * 退款状态
     */
    private Integer refundStatus;

    //排序条件
    private String orderBy;


    //@ApiModelProperty(value = "退款操作类型：1 手动退款，2、过期自动退款")
    private Integer refundOperationType;

    //@ApiModelProperty(value = "")
//        @QueryParam("orderAwardId")
    private String orderAwardId;

    //@ApiModelProperty(value = "")
//        @QueryParam("remark1")
    private String remark1;

    //@ApiModelProperty(value = "")
//        @QueryParam("remark2")
    private String remark2;

    //@ApiModelProperty(value = "")
//        @QueryParam("remark3")
    private String remark3;

    //@ApiModelProperty(value = "")
//        @QueryParam("remark4")
    private String remark4;



    //@ApiModelProperty(value = "退款订单号")
    private String refundNo;
    //@ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;
    //@ApiModelProperty(value = "退款方式：1、原路退款")
    private Integer refundType;
    //@ApiModelProperty(value = "退款成功时间")
    private Date refundTime;
    //@ApiModelProperty(value = "退款映射表成功的订单号")
    private String refundTransNo;
    //@ApiModelProperty(value = "退款流水号(第三方的退款订单号)")
    private String refundThirdOrderNo;

    //@ApiModelProperty(value = "退款数")
//        @QueryParam("count")
    private Integer count;

    private Integer version;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    private Integer dr;
    private String tenantCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public void addRefundCount(Integer refundCount) {
        if (null != this.refundCount){
            this.refundCount += refundCount;
        }else {
            this.refundCount = refundCount;
        }

    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getRefundOperationType() {
        return refundOperationType;
    }

    public void setRefundOperationType(Integer refundOperationType) {
        this.refundOperationType = refundOperationType;
    }

    public String getOrderAwardId() {
        return orderAwardId;
    }

    public void setOrderAwardId(String orderAwardId) {
        this.orderAwardId = orderAwardId;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }


    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}


package com.deepexi.trade.domain.eo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_refund
 * @author admin
 */
//@ApiModel(description = "退款表")
public class TcOrderRefund extends SuperEntity implements Serializable{

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
    //@ApiModelProperty(value = "退款操作类型：1 手动退款，2、过期自动退款")
    private Integer refundOperationType;
    //@ApiModelProperty(value = "退款成功时间")
    private Date refundTime;
    //@ApiModelProperty(value = "退款映射表成功的订单号")
    private String refundTransNo;
    //@ApiModelProperty(value = "退款流水号(第三方的退款订单号)")
    private String refundThirdOrderNo;

    //@ApiModelProperty(value = "退款数")
//        @QueryParam("count")
    private Integer count;

    //@ApiModelProperty(value = "奖品ID")
//        @QueryParam("awardId")
    private String awardId;

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



    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public void setRefundNo(String refundNo){
        this.refundNo = refundNo;
    }

    public String getRefundNo(){
        return this.refundNo;
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

    public void setRefundTime(Date refundTime){
        this.refundTime = refundTime;
    }

    public Date getRefundTime(){
        return this.refundTime;
    }

    public String getRefundTransNo() {
        return refundTransNo;
    }

    public void setRefundTransNo(String refundTransNo) {
        this.refundTransNo = refundTransNo;
    }

    public Integer getRefundOperationType() {
        return refundOperationType;
    }

    public void setRefundOperationType(Integer refundOperationType) {
        this.refundOperationType = refundOperationType;
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

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
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
}


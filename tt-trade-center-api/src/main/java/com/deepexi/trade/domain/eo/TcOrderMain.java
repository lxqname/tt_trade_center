package com.deepexi.trade.domain.eo;


import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_main
 * @author admin
 */
//@ApiModel(description = "订单主表")
public class TcOrderMain extends SuperEntity implements Serializable{

    //@ApiModelProperty(value = "订单状态：0、已取消订单(关闭订单)1、待付款2、待发货3、待核销(待收货)4、已完成")
    private Integer orderStatus;
    //@ApiModelProperty(value = "会员关联id")
    private String memberId;
    //@ApiModelProperty(value = "会员关联名称")
    private String memberName;
    //@ApiModelProperty(value = "主订单号")
    private String orderNo;
    //@ApiModelProperty(value = "订单类型：1、兑换")
    private Integer orderType;
    //@ApiModelProperty(value = "支付方式：1、微信 2、支付宝 3、云闪付")
    private Integer payType;
    //@ApiModelProperty(value = "支付金额")
    private BigDecimal amount;
    //@ApiModelProperty(value = "支付订单号(支付成功后才有)")
    private String orderPayNo;
    //@ApiModelProperty(value = "消耗的积分")
    private String expendIntegral;
    //@ApiModelProperty(value = "消耗的优惠券id")
    private String expendCouponId;
    //@ApiModelProperty(value = "操作的状态 用户关闭、取消订单时中间状态")
    private Integer operatingStatus;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderPayNo() {
        return orderPayNo;
    }

    public void setOrderPayNo(String orderPayNo) {
        this.orderPayNo = orderPayNo;
    }

    public String getExpendIntegral() {
        return expendIntegral;
    }

    public void setExpendIntegral(String expendIntegral) {
        this.expendIntegral = expendIntegral;
    }

    public String getExpendCouponId() {
        return expendCouponId;
    }

    public void setExpendCouponId(String expendCouponId) {
        this.expendCouponId = expendCouponId;
    }

    public Integer getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }


    @Override
    public String toString() {
        return "TcOrderMain{" +
                "orderStatus=" + orderStatus +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderType=" + orderType +
                ", payType=" + payType +
                ", amount=" + amount +
                ", orderPayNo='" + orderPayNo + '\'' +
                ", expendIntegral='" + expendIntegral + '\'' +
                ", expendCouponId='" + expendCouponId + '\'' +
                ", operatingStatus=" + operatingStatus +
                '}';
    }
}


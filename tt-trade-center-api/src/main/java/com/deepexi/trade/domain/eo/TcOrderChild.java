package com.deepexi.trade.domain.eo;


import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_child
 * @author admin
 */
//@ApiModel(description = "子订单表")
public class TcOrderChild extends SuperEntity implements Serializable{

    //@ApiModelProperty(value = "主表订单关联id")
    private String orderId;
    //@ApiModelProperty(value = "子订单号")
    private String childNo;
    //@ApiModelProperty(value = "订单状态：0、已取消订单(关闭订单)1、待付款2、待发货3、待核销(待收货)4、已完成")
    private Integer childStatus;
    //@ApiModelProperty(value = "支付方式：1、微信 2、支付宝 3、云闪付")
    private Integer childPayType;
    //@ApiModelProperty(value = "支付金额")
    private BigDecimal childAmount;
    //@ApiModelProperty(value = "支付订单号(支付成功后才有)")
    private String orderPayNo;
    //@ApiModelProperty(value = "商户关联id")
    private String merchantId;
    //@ApiModelProperty(value = "商户关联名称")
    private String merchantName;
    //@ApiModelProperty(value = "活动关联id")
    private String eventId;
    //@ApiModelProperty(value = "活动关联名称")
    private String eventName;
    //@ApiModelProperty(value = "活动编号")
    private String eventNo;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChildNo() {
        return childNo;
    }

    public void setChildNo(String childNo) {
        this.childNo = childNo;
    }

    public Integer getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(Integer childStatus) {
        this.childStatus = childStatus;
    }

    public Integer getChildPayType() {
        return childPayType;
    }

    public void setChildPayType(Integer childPayType) {
        this.childPayType = childPayType;
    }

    public BigDecimal getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(BigDecimal childAmount) {
        this.childAmount = childAmount;
    }

    public String getOrderPayNo() {
        return orderPayNo;
    }

    public void setOrderPayNo(String orderPayNo) {
        this.orderPayNo = orderPayNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo;
    }
}


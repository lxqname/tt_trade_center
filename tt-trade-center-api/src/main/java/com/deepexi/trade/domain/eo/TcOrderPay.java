package com.deepexi.trade.domain.eo;


import java.io.Serializable;
import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_pay
 * @author admin
 */
//@ApiModel(description = "支付表")
public class TcOrderPay extends SuperEntity implements Serializable{

    //@ApiModelProperty(value = "订单关联id")
    private String orderId;
    //@ApiModelProperty(value = "订单状态：0、已取消订单(关闭订单)1、待付款 4、支付成功")
    private Integer orderStatus;
    //@ApiModelProperty(value = "支付订单号")
    private String transNo;
    //@ApiModelProperty(value = "支付中心的交易订单号")
    private String payCenterTransNo;
    //@ApiModelProperty(value = "支付方式：1、微信 2、支付宝 3、云闪付")
    private Integer payType;
    //@ApiModelProperty(value = "支付成功时间")
    private Date payTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getPayCenterTransNo() {
        return payCenterTransNo;
    }

    public void setPayCenterTransNo(String payCenterTransNo) {
        this.payCenterTransNo = payCenterTransNo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}


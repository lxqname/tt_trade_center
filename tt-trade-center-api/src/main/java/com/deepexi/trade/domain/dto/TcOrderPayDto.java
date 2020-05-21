package com.deepexi.trade.domain.dto;

import com.deepexi.trade.domain.eo.TcOrderPay;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/**
 * @desc tc_order_pay
 * @author admin
 */
public class TcOrderPayDto implements Serializable {

    private String id;

    @NotNull(message = "订单ID不能为空")
    private String orderId;

    @NotNull(message = "支付类型不能为空")
    private Integer payType;

    private Integer orderStatus;

    private String transNo;

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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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


}


package com.deepexi.trade.domain.vo.orderdetail;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @Author: lc_xin.
 * @Date: 2019/4/25 14:31
 */
public class OrderPayInfo implements Serializable{

    /**
     * 支付订单号
     */
    private String transNo;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 支付方式名称
     */
    private String payTypeName;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountsAmount;

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getDiscountsAmount() {
        return discountsAmount;
    }

    public void setDiscountsAmount(BigDecimal discountsAmount) {
        this.discountsAmount = discountsAmount;
    }
}


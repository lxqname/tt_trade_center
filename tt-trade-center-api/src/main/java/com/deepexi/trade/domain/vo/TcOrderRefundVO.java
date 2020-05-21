package com.deepexi.trade.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/7 17:44
 */
public class TcOrderRefundVO implements Serializable {

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 主订单号
     */
    private String orderNo;

    /**
     * 商品id
     */
    private String awardId;

    /**
     * 商品类型 1、单商品  2、组合优惠商品
     */
    private Integer awardType;

    /**
     * 退款件数
     */
    private Integer refundCount;

    /**
     * 支付方式：1、微信 2、支付宝 3、云闪付
     */
    private Integer refundType;

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
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

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }
}

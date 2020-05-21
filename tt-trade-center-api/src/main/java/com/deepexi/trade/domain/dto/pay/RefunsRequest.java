package com.deepexi.trade.domain.dto.pay;

import java.math.BigDecimal;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 17:51
 */
public class RefunsRequest extends BasePayRequest {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 支付中心提供的交易单号
     */
    private String tranNo;

    /**
     * 退款金额
     */
    private BigDecimal applyDeductionAmount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public BigDecimal getApplyDeductionAmount() {
        return applyDeductionAmount;
    }

    public void setApplyDeductionAmount(BigDecimal applyDeductionAmount) {
        this.applyDeductionAmount = applyDeductionAmount;
    }
}

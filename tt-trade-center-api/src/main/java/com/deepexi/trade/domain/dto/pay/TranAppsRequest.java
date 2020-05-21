package com.deepexi.trade.domain.dto.pay;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:08
 */
public class TranAppsRequest extends BasePayRequest {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 申请扣款金额(支付金额)
     */
    private String applyDeductionAmount;

    /**
     * 交易描述
     */
    private String tradingSummary;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApplyDeductionAmount() {
        return applyDeductionAmount;
    }

    public void setApplyDeductionAmount(String applyDeductionAmount) {
        this.applyDeductionAmount = applyDeductionAmount;
    }

    public String getTradingSummary() {
        return tradingSummary;
    }

    public void setTradingSummary(String tradingSummary) {
        this.tradingSummary = tradingSummary;
    }
}

package com.deepexi.trade.domain.dto.pay;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 16:08
 */
public class TranActionRequest extends BasePayRequest {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 支付中心返回的交易单号
     */
    private String tranNo;

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
}

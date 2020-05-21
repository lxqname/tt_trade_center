package com.deepexi.trade.domain.vo.pay;

import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:02
 */
public class BasePayResponse implements Serializable {

    /**
     * 请求结果说明
     */
    private String message;

    /**
     * 结果状态码
     */
    private String code;

    /**
     * 跳转地址
     */
    private String jumpUrl;

    /**
     * 订单号，接收到的订单中心全局唯一订单号
     */
    private String orderId;

    /**
     * 交易单号，支付中心产生的用于支付的全局唯一 编号
     */
    private String tranNo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

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

package com.deepexi.trade.domain.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/26 12:02
 */
public class TcCallBackDto implements Serializable {

//    private String applyDeductionAmount;//":""0.02",
//    private String code;//;//":""SUCCESS",
//    private String feeAmount;//":"0,
//    private String message;//;//":""支付成功",
//    private String orderId;//;//":""00320190522185208592",
//    private String payChannel;//;//":""WECHAT",
//    private String payTotalAmount;//":"0.02,
//    private String signType;//;//":""MD5",
//    private String signature;//;//":""24528349920fcdb06acba7f69c002eb4",
//    private String status;//;//":""SUCCESS",
//    private String tranNo;//;//":""e44f41357d2f478c98ec550b3b7b581d",
//    private String tranType;//;//":""PAY"


    /**
     * 结果描述
     */
    private String message;

    /**
     * 前端跳转URL
     */
    private String jumpUrl;



    /**
     * 交易订单
     */
    private String tranNo;

    /**
     * 签名方式
     */
    private String signType;


    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 交易类型
     */
    private String tranType;



    /**
     * 支付订单号
     */
    @NotNull(message = "支付订单号不能为空")
    private String orderId;

    /**
     * 申请扣款金额
     */
    private String applyDeductionAmount;

    /**
     * 支付状态
     */
    @NotNull(message = "支付状态不能为空")
    private String status;

    /**
     * 支付总金额
     */
    private String payTotalAmount;

    /**
     * 手续费，渠道产生的手续费，没有产生手续费 时费用为0
     */
    private String feeAmount;

    /**
     * 支付成功时间
     */
    private String payTime;

    /**
     * 支付状态编码,与【PayStatusEnum】保持对 应
     */
    private String code;

    /**
     * 支付结果描述
     */
    private String msg;

    /**
     * 回调结果验签
     */
    @NotNull(message = "验签数据不能为空")
    private String signature;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayTotalAmount() {
        return payTotalAmount;
    }

    public void setPayTotalAmount(String payTotalAmount) {
        this.payTotalAmount = payTotalAmount;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
}


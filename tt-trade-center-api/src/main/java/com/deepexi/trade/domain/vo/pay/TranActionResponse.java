package com.deepexi.trade.domain.vo.pay;

import java.math.BigDecimal;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 17:13
 */
public class TranActionResponse extends BasePayResponse {

    /**
     * 跳转类型
     */
    private String jumpType;

    /**
     * 跳转数据
     */
    private String jumpData;

    /**
     * 交易状态
     */
    private String status;

    /**
     * 手续费
     */
    private BigDecimal feeAmount;

    /**
     * 验签
     */
    private String signature;

    /**
     * 验签类型
     */
    private String signType;

    /**
     * 申请付款金额
     */
    private BigDecimal applyDeductionAmount;

    /**
     * 实际付款总额
     */
    private BigDecimal payTotalAmount;

    public String getJumpType() {
        return jumpType;
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType;
    }

    public String getJumpData() {
        return jumpData;
    }

    public void setJumpData(String jumpData) {
        this.jumpData = jumpData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public void setApplyDeductionAmount(BigDecimal applyDeductionAmount) {
        this.applyDeductionAmount = applyDeductionAmount;
    }

    public void setPayTotalAmount(BigDecimal payTotalAmount) {
        this.payTotalAmount = payTotalAmount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}

package com.deepexi.trade.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 17:02
 */
public class TcOrderPayVO implements Serializable {

    /**
     * 租户ID，与配置系统信息时，配置的租户ID一致
     */
    private String tenantId;
    /**
     * 订单号，接收到的订单中心全局唯一订单号(对应收银台的orderId)
     */
    private String orderNo;

    /**
     * 交易单号，支付中心产生的用于支付的全局唯一 编号
     */
    private String tranNo;

    /**
     * 系统唯一编码
     */
    private String paySysAccessAuthCode;

    /**
     * 系统业务编码
     */
    private String paySysBizTypeCode;

    /**
     * 支付应用编码
     */
    private String payApplicationCode;

    /**
     * 支付金额
     */
    private BigDecimal applyDeductionAmount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getPaySysAccessAuthCode() {
        return paySysAccessAuthCode;
    }

    public void setPaySysAccessAuthCode(String paySysAccessAuthCode) {
        this.paySysAccessAuthCode = paySysAccessAuthCode;
    }

    public String getPaySysBizTypeCode() {
        return paySysBizTypeCode;
    }

    public void setPaySysBizTypeCode(String paySysBizTypeCode) {
        this.paySysBizTypeCode = paySysBizTypeCode;
    }

    public String getPayApplicationCode() {
        return payApplicationCode;
    }

    public void setPayApplicationCode(String payApplicationCode) {
        this.payApplicationCode = payApplicationCode;
    }

    public BigDecimal getApplyDeductionAmount() {
        return applyDeductionAmount;
    }

    public void setApplyDeductionAmount(BigDecimal applyDeductionAmount) {
        this.applyDeductionAmount = applyDeductionAmount;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}

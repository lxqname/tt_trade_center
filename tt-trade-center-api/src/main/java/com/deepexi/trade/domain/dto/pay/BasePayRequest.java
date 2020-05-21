package com.deepexi.trade.domain.dto.pay;

import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:02
 */
public class BasePayRequest implements Serializable {

    /**
     * 数据签名
     */
    private String signature;

    /**
     * 签名类型，默认为MD5，目前支持MD5，后续 会增加HMAC-SHA256。如果使用HMACSHA25，该字段必填。
     */
    private String signType;

    /**
     * 32~64 系统编码，对接支付中心前在配置中心配置商户 信息时产生的唯一编码
     */
    private String paySysAccessAuthCode;

    /**
     * 32~64 系统业务编码,对接支付中心前在配置中心配置商 户信息时产生的唯一编码
     */
    private String paySysBizTypeCode;

    /**
     * 32~64 支付应用编码，对接支付中心前在配置中心配置 商户信息时产生的唯一编码
     */
    private String payApplicationCode;

    /**
     * 系统域名,对接支付中心前在配置中心配置商户信 息时配置的系统域名
     */
    private String doMain;

    /**
     * 系统IP ,对接支付中心前在配置中心配置商户信息 时配置的系统IP
     */
    private String ip;

    /**
     * 租户ID，与配置系统信息时，配置的租户ID一致
     */
    private String tenantId;

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

    public String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}

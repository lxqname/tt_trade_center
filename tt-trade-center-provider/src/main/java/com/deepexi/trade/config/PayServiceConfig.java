package com.deepexi.trade.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 支付服务配置
 * @Author: lc_xin.
 * @Date: 2019/5/5 10:31
 */
@Component
@ConfigurationProperties(prefix = "deepexi.payconfig")
public class PayServiceConfig {
    /**
     * 请求的根路径
     */
    private static String baseUrl;
    /**
     * 系统编码，对接支付中心前在配置中心配置商户 信息时产生的唯一编码
     */
    private static String paySysAccessAuthCode;
    /**
     * 系统业务编码,对接支付中心前在配置中心配置商 户信息时产生的唯一编码
     */
    private static String paySysBizTypeCode;
    /**
     * 支付应用编码，对接支付中心前在配置中心配置 商户信息时产生的唯一编码
     */
    private static String payApplicationCode;
    /**
     * 系统域名,对接支付中心前在配置中心配置商户信 息时配置的系统域名
     */
    private static String doMain;
    /**
     * ip
     */
    private static String ip;

    /**
     * 请求timeout时间
     */
    private static String timeOut;

    /**
     * 系统授权码
     */
    private static String authCode;

    /**
     * 租户在支付中心的ID
     */
    private static String tenantId;

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        PayServiceConfig.tenantId = tenantId;
    }

    public void setBaseUrl(String baseUrl) {
        PayServiceConfig.baseUrl = baseUrl;
    }

    public static String getPaySysAccessAuthCode() {
        return paySysAccessAuthCode;
    }

    public void setPaySysAccessAuthCode(String paySysAccessAuthCode) {
        PayServiceConfig.paySysAccessAuthCode = paySysAccessAuthCode;
    }

    public static String getPaySysBizTypeCode() {
        return paySysBizTypeCode;
    }

    public void setPaySysBizTypeCode(String paySysBizTypeCode) {
        PayServiceConfig.paySysBizTypeCode = paySysBizTypeCode;
    }

    public static String getPayApplicationCode() {
        return payApplicationCode;
    }

    public void setPayApplicationCode(String payApplicationCode) {
        PayServiceConfig.payApplicationCode = payApplicationCode;
    }

    public static String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        PayServiceConfig.doMain = doMain;
    }

    public static String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        PayServiceConfig.ip = ip;
    }

    public static String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        PayServiceConfig.timeOut = timeOut;
    }

    public static String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        PayServiceConfig.authCode = authCode;
    }
}

package com.deepexi.trade.enums;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 10:31
 */
public enum PayURLEnum {

    TRAN_APPS_PAY("支付下单","/pays/tranApps"),
    TRAN_ACTION("交易记录","/pays/tran"),
    REFUNS("退款","/refuns/tran"),
    ;
    /**
     * 请求名称
     */
    private String name;
    /**
     * 请求URL
     */
    private String url;

    PayURLEnum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

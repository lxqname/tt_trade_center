package com.deepexi.trade.domain.vo.pay;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:08
 */
public class TranAppsResponse extends BasePayResponse {

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
}

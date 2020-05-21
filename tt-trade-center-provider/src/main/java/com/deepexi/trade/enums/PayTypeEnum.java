package com.deepexi.trade.enums;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 17:37
 */
@SuppressWarnings({"AliWrapperTypeEquality", "AliControlFlowStatementWithoutBraces"})
public enum PayTypeEnum {
    WECHAT_PAY(1, "微信"),
    ALI_PAY(2, "支付宝"),
    UNION_PAY(3, "云闪付"),
    ;

    private Integer code;

    private String desc;

    PayTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static PayTypeEnum getEnumByCode(Integer code) {
        for (PayTypeEnum e : values()) {
            //noinspection AliControlFlowStatementWithoutBraces,AliWrapperTypeEquality
            if (e.getCode() == code) return e;
        }
        return null;
    }
}

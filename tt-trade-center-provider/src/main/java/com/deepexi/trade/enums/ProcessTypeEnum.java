package com.deepexi.trade.enums;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/28 17:37
 */
@SuppressWarnings({"AliWrapperTypeEquality", "AliControlFlowStatementWithoutBraces"})
public enum ProcessTypeEnum {
    REQUEST_OPERATION(1, "发起"),
    PLATFORM_AUDIT_OPERATION(2, "平台审核"),
    CHANNEL_ACCEPT(3, "渠道受理"),
    INTO_ACCOUNT_OPERATION(4, "到账"),
    ;

    private Integer code;

    private String desc;

    ProcessTypeEnum(Integer code, String desc) {
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

    public static ProcessTypeEnum getEnumByCode(Integer code) {
        for (ProcessTypeEnum e : values()) {
            //noinspection AliControlFlowStatementWithoutBraces,AliWrapperTypeEquality
            if (e.getCode() == code) return e;
        }
        return null;
    }
}

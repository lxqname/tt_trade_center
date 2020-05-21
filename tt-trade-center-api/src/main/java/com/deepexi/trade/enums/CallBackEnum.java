package com.deepexi.trade.enums;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 17:37
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
public enum CallBackEnum {
    SUCCESS("SUCCESS", "成功"),
    FAILURE("FAILURE", "失败"),
    ;

    private String code;

    private String desc;

    CallBackEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CallBackEnum getEnumByCode(Integer code) {
        for (CallBackEnum e : values()) {
            //noinspection AliControlFlowStatementWithoutBraces
            if (e.getCode().equals(code)) return e;
        }
        return null;
    }

    public static CallBackEnum setMsg(CallBackEnum callBackEnum, String desc){
        callBackEnum.setDesc(desc);
        return callBackEnum;
    }
}

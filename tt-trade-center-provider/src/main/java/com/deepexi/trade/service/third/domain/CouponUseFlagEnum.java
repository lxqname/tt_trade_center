package com.deepexi.trade.service.third.domain;

/**
 * 优惠券使用条件
 *
 * @author 蝈蝈
 */
public enum CouponUseFlagEnum {

    /**
     * 无门槛
     */
    NO_LIMIT(0, "无门槛"),
    /**
     * 满额
     */
    FULL_AMOUNT(1, "满额"),
    /**
     * 自定义
     */
    CUSTOMIZE(2, "自定义"),
    ;
    private Integer state;

    private String msg;

    CouponUseFlagEnum(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

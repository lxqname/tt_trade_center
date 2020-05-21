package com.deepexi.trade.enums;

import com.deepexi.util.constant.BaseEnumType;

/**
 * Created by donh on 2019/1/8.
 */
public enum ResultEnum implements BaseEnumType{
    UNKNOWN_ERROR("500", "系统出异常啦!请联系管理员!!!"),
    SUCCESS("200", "success"),
    USER_EXIST("100002", "用户已存在！"),
    NETWORK_LIMIT("100001", "网络限流！"),
    PARAMETER_ERROR("100004","入参错误"),
    TOKEN_NOT_FOUND("200001", "token不能为空！"),
    TENANT_NOT_FOUND("200002", "tenantId不能为空！"),
    RPC_ERROR("300000", "RPC调用异常!请检查服务是否正常!!!"),

    PAY_SUCCESS("200006","该订单已支付成功"),
    REFUND_SUCCESS("200007","该订单已退款成功"),
    PAY_NOT_SUCCESS("200008","该订单并未支付成功"),
    PAY_FAIL("200009","该订单已关闭"),
    EVENT_NOT_FOUND("200010", "商户信息不能为空！"),
    AWARD_NOT_FOUND("200011", "商品信息有误"),
    UNDERSTOCK("200012", "库存不足"),
    AWARD_OVERDUE("200013", "该笔订单中的商品已过期，不能退款"),
    AWARD_ALL_USE("200014", "该笔订单的优惠券都已使用,不能退款"),
    ORDER_NOT_FOUND("200015", "不存在该笔订单"),


     ;
    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResultEnum setMsg(ResultEnum resultEnum, String msg){
        resultEnum.setMsg(msg);
        return resultEnum;
    }
}
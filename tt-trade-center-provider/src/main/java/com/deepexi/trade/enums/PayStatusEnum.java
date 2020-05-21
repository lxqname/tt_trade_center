package com.deepexi.trade.enums;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 19:35
 */
public enum PayStatusEnum {

    //支付成功
    SUCCESS("SUCCESS","支付成功"),
    //支付失败
    FAILURE("FAILURE","支付失败"),
    //未知
    UNKNOW("UNKNOW","未知结果"),
    //退款成功
    REFUND("REFUND","退款成功"),
    //退款失败
    REFUND_FAILURE("REFUND_FAILURE","退款失败"),
    //退款处理中
    PROCESSING("PROCESSING","退款处理中"),
    //退款关闭
    REFUNDCLOSE("REFUNDCLOSE","退款关闭"),
    //退款申请成功
    REFUND_APPLY_SUCCESS("REFUND_APPLY_SUCCESS","退款申请成功"),
    //退款申请失败
    REFUND_APPLY_FAILURE("REFUND_APPLY_FAILURE","退款申请失败"),
    //未支付
    NOPAY("NOPAY","未支付"),
    //未支付
    CANCEL_PAY("CANCELPAY","取消支付");

    private String code;

    private String msg;

    PayStatusEnum(String code, String msg){
        this.code=code;
        this.msg=msg;
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

    public static String getMsg(String code) {
        for(PayStatusEnum ae : PayStatusEnum.values()){
            if(ae.getCode().equals(code)){
                return ae.getMsg();
            }
        }
        return null;
    }

}

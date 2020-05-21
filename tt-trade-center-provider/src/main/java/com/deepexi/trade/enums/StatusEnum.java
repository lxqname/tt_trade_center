package com.deepexi.trade.enums;

import com.deepexi.trade.domain.eo.TcOrderMain;
import com.deepexi.util.extension.ApplicationException;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 17:37
 */
@SuppressWarnings({"AliWrapperTypeEquality", "AliControlFlowStatementWithoutBraces"})
public enum StatusEnum {
    FAIL(0, "关闭"),
    PAY_PENDING(1, "待付款"),
    SHIPMENTS_PENDING(2, "待发货"),
    CHARGE_OFF_PENDING(3, "待核销"),
    CHARGE_PART(9, "部分核销"),
    CHARGE_ALL(10, "全部核销"),
    SUCCESS(4, "支付或退款已成功"),//这里退款和订单公用了
    REFUND_SUCCESS(8, "退款成功"),//订单专用
    CLOSE_PENDING(5, "关闭处理中的中间状态"),
    REFUND_PENDING(6, "退款中"),
    REFUND_FAILURE(7, "退款失败"),
    ;

    private Integer code;

    private String desc;

    StatusEnum(Integer code, String desc) {
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

    public static StatusEnum getEnumByCode(Integer code) {
        for (StatusEnum e : values()) {
            //noinspection AliControlFlowStatementWithoutBraces,AliWrapperTypeEquality
            if (e.getCode() == code) return e;
        }
        return null;
    }

    public static StatusEnum canPay(TcOrderMain tcOrderMain) {
        //noinspection AliControlFlowStatementWithoutBraces
        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);

        //noinspection AliControlFlowStatementWithoutBraces
        if(StatusEnum.SUCCESS.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.PAY_SUCCESS);
        //noinspection AliControlFlowStatementWithoutBraces
        if(!StatusEnum.PAY_PENDING.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "订单状态非待付款不能支付！"+tcOrderMain.toString()));

        return PAY_PENDING;
    }
    public static StatusEnum canPayCallBack(TcOrderMain tcOrderMain) {
        //noinspection AliControlFlowStatementWithoutBraces
        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);

        //noinspection AliControlFlowStatementWithoutBraces
        if(StatusEnum.SUCCESS.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.PAY_SUCCESS);
        //noinspection AliControlFlowStatementWithoutBraces
        if(!StatusEnum.PAY_PENDING.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "订单状态非待付款不能支付！"));

        return SUCCESS;
    }

    public static StatusEnum canCharge(TcOrderMain tcOrderMain) {
        //noinspection AliControlFlowStatementWithoutBraces
        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);

        if(StatusEnum.SUCCESS.getCode().equals(tcOrderMain.getOrderStatus())
                || StatusEnum.CHARGE_PART.getCode().equals(tcOrderMain.getOrderStatus())) {
            return CHARGE_PART;//上层需判断部分还是全部
        }else {
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "未达到核销条件"));
        }
    }

    public static StatusEnum canRefund(TcOrderMain tcOrderMain) {
        //noinspection AliControlFlowStatementWithoutBraces
        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);

        if(StatusEnum.SUCCESS.getCode().equals(tcOrderMain.getOrderStatus())
            || StatusEnum.CHARGE_PART.getCode().equals(tcOrderMain.getOrderStatus())) {
            return REFUND_PENDING;
        }else {
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "未达到退款条件"));
        }
    }

    public static StatusEnum canRefundCallBack(TcOrderMain tcOrderMain) {
        //noinspection AliControlFlowStatementWithoutBraces
        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);

        //noinspection AliControlFlowStatementWithoutBraces
        if(!StatusEnum.REFUND_PENDING.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "退款回调！"));

        return REFUND_SUCCESS;//上层区分订单和退款单
    }
}

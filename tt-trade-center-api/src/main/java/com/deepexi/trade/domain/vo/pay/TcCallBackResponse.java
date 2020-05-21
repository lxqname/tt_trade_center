package com.deepexi.trade.domain.vo.pay;

import com.deepexi.trade.enums.CallBackEnum;

import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:08
 */
public class TcCallBackResponse implements Serializable {

    /**
     * SUCCESS/FAILURE,SUCCESS表示商户接收通知成功并校 验成功
     */
    private String returnCode;

    /**
     * 返回信息，如非空，为错误原因如：参数格式校验错误
     */
    private String returnMsg;

    public TcCallBackResponse() {

    }

    public TcCallBackResponse(CallBackEnum callBackEnum) {
        this.returnCode = callBackEnum.getCode();
        this.returnMsg = callBackEnum.getDesc();
    }

    public TcCallBackResponse(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}

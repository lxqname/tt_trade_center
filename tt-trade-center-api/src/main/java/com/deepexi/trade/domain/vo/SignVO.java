package com.deepexi.trade.domain.vo;

import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/9 11:54
 */
@SuppressWarnings("AlibabaPojoMustOverrideToString")
public class SignVO implements Serializable {

    /**
     * 签名
     */
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

package com.deepexi.trade.domain.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/9 11:48
 */
public class MakeSignDto implements Serializable {

    /**
     * 加签明文json字符串
     */
    @NotNull(message = "加签明文不能为空")
    private String objJsonStr;

    /**
     * 签名类型，默认为MD5，可选：MD5、HMACSHA256
     */
    private String signType;

    public String getObjJsonStr() {
        return objJsonStr;
    }

    public void setObjJsonStr(String objJsonStr) {
        this.objJsonStr = objJsonStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}

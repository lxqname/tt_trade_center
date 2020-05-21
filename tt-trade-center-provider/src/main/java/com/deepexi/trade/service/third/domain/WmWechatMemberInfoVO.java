package com.deepexi.trade.service.third.domain;

/**
 * @version V1.0
 * @author: LuoGuang
 * @Package com.deepexi.user.domain.vo
 * @Description:
 * @date: 2019/6/5 21:42
 */
public class WmWechatMemberInfoVO extends WmWechatMemberInfo {

    /**
     * 公众号APPId
     */
    private String appId;
    /**
     * 会员ID
     */
    private String memberId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}

package com.deepexi.trade.service.third.domain;


import com.deepexi.trade.domain.eo.SuperEntity;

import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc wm_wechat_member_info
 * @author admin
 */
//@ApiModel(description = "微信会员基本信息")
public class WmWechatMemberInfo extends SuperEntity {

    //@ApiModelProperty(value = "公众号原始ID")
    private String wechatNumberId;
    //@ApiModelProperty(value = "用户的标识，对当前公众号唯一")
    private String openId;
    //@ApiModelProperty(value = "用户的昵称")
    private String nickname;
    /**
     * 性别
     */
    private Integer sexDesc;
    //@ApiModelProperty(value = "用户的性别，值为1时是男性，值为2时是女性，值为0时是未知")
    private Integer sex;
    //@ApiModelProperty(value = "所在城市")
    private String city;
    //@ApiModelProperty(value = "用户所在国家")
    private String country;
    //@ApiModelProperty(value = "用户所在省份")
    private String province;
    //@ApiModelProperty(value = "用户的语言，简体中文为zh_CN")
    private String language;
    //@ApiModelProperty(value = "用户头像")
    private String headImgUrl;
    //@ApiModelProperty(value = "用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。")
    private Boolean subscribe;
    //@ApiModelProperty(value = "unionid")
    private String unionId;
    //@ApiModelProperty(value = "用户关注时间")
    private Date subscribeTime;
    //@ApiModelProperty(value = "返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他")
    private String subscribeScene;

    public String getWechatNumberId() {
        return wechatNumberId;
    }

    public void setWechatNumberId(String wechatNumberId) {
        this.wechatNumberId = wechatNumberId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(Integer sexDesc) {
        this.sexDesc = sexDesc;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    @Override
    public String toString() {
        return "WmWechatMemberInfo{" +
                "wechatNumberId='" + wechatNumberId + '\'' +
                ", openId='" + openId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sexDesc=" + sexDesc +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", subscribe=" + subscribe +
                ", unionId='" + unionId + '\'' +
                ", subscribeTime=" + subscribeTime +
                ", subscribeScene='" + subscribeScene + '\'' +
                '}';
    }
}


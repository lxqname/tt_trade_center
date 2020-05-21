package com.deepexi.trade.domain.vo.orderdetail;


import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @Author: lc_xin.
 * @Date: 2019/4/25 14:31
 */
public class MemberInfo implements Serializable{


    /**
     * 账户ID
     */
    private String accountId;
    /**
     * 会员账户名
     */
    private String accountName;
    /**
     * 微信unionId
     */
    private String unionId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 1:启用 0:禁用
     */
    private Boolean state;
    /**
     * 会员手机号码(加密)
     */
    private String mobile;
    /**
     * 会员手机号码(真实)
     */
    private String realMobile;
    /**
     * 1:绑定 0:未绑定
     */
    private Boolean bindMobile;
    /**
     * 会员等级ID
     */
    private String memberLevelId;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 职业
     */
    private String job;
    /**
     * 年龄
     */
    private Integer  age;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;
    /**
     * 姓名
     */
    private String name;
    /**
     * 会员头像
     */
    private String headImg;
    /**
     * QQ
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 微信
     */
    private String wechat;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 邀请者会员ID
     */
    private String inviterMemberId;
    /**
     * 邀请项目ID
     */
    private String inviterItemId;
    /**
     * 会员来源：1：会员端H5-自助注册，2：运营平台-批量导入
     */
    private Integer source;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRealMobile() {
        return realMobile;
    }

    public void setRealMobile(String realMobile) {
        this.realMobile = realMobile;
    }

    public Boolean getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(Boolean bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(String memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInviterMemberId() {
        return inviterMemberId;
    }

    public void setInviterMemberId(String inviterMemberId) {
        this.inviterMemberId = inviterMemberId;
    }

    public String getInviterItemId() {
        return inviterItemId;
    }

    public void setInviterItemId(String inviterItemId) {
        this.inviterItemId = inviterItemId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}


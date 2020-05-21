package com.deepexi.trade.service.third.domain;

import java.io.Serializable;

/**
 * @version V1.0
 * @author: LuoGuang
 * @Package com.deepexi.user.domain.vo
 * @Description:
 * @date: 2019/4/15 11:01
 */
public class UcMerchantDetailVO implements Serializable {
    /**
     * ID
     */
    private String id;
    /**
     * 商户名称
     */
    private String name;
    /**
     * 商户简称
     */
    private String shortName;
    /**
     * 商户电话
     */
    private String mobile;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactMobile;
    /**
     * 性别
     */
    private String sex;
    /**
     * 商户LOGO
     */
    private String logo;
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
     * 1:店长 2:店员
     */
    private Integer type;
    /**
     * 商户编码/店员编号
     */
    private String code;
    /**
     * 营业执照
     */
    private String licenseImg;
    /**
     * 法人姓名
     */
    private String legalPersonName;
    /**
     * 法人身份证号码
     */
    private String legalPersonCardNum;
    /**
     * 法人身份证正面
     */
    private String legalPersonCardPositive;
    /**
     * 法人身份证反面照片
     */
    private String legalPersonCardNegative;

    /**
     * 登陆账户
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 账户状态0：正常，1：需要激活
     */
    private Integer status;

    /**
     * 商户类型名
     */
    private String merchantSortName;
    /**
     * 商户分类ID
     */
    private String merchantSortId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMerchantSortId() {
        return merchantSortId;
    }

    public void setMerchantSortId(String merchantSortId) {
        this.merchantSortId = merchantSortId;
    }

    public String getMerchantSortName() {
        return merchantSortName;
    }

    public void setMerchantSortName(String merchantSortName) {
        this.merchantSortName = merchantSortName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getLicenseImg() {
        return licenseImg;
    }

    public void setLicenseImg(String licenseImg) {
        this.licenseImg = licenseImg;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonCardNum() {
        return legalPersonCardNum;
    }

    public void setLegalPersonCardNum(String legalPersonCardNum) {
        this.legalPersonCardNum = legalPersonCardNum;
    }

    public String getLegalPersonCardPositive() {
        return legalPersonCardPositive;
    }

    public void setLegalPersonCardPositive(String legalPersonCardPositive) {
        this.legalPersonCardPositive = legalPersonCardPositive;
    }

    public String getLegalPersonCardNegative() {
        return legalPersonCardNegative;
    }

    public void setLegalPersonCardNegative(String legalPersonCardNegative) {
        this.legalPersonCardNegative = legalPersonCardNegative;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

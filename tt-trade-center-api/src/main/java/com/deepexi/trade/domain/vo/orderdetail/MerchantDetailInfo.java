package com.deepexi.trade.domain.vo.orderdetail;


import java.io.Serializable;


/**
 * @Author: lc_xin.
 * @Date: 2019/4/25 14:31
 */
public class MerchantDetailInfo implements Serializable{

    /**
     * 商户名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactMobile;
    /**
     * 详细地址
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


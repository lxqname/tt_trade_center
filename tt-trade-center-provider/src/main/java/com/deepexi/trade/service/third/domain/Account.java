package com.deepexi.trade.service.third.domain;/**
 * Created by chenshaowen on 2018/11/26.
 */


import com.deepexi.util.mapper.SuperEntity;

import java.util.Date;

/**
 * program: deepexi-auth-center
 * <p>
 * description: 账户表
 *
 * @author: shaowin
 * <p>
 * created on : 2018-11-26 17:07
 **/

/**
* Account
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class Account extends SuperEntity {
    private static final long serialVersionUID = 3709194792043028370L;

    private String username; //用户名

    private String phone; //手机

    private String email; //邮箱

    private String password; //密码

    private Integer status;//账户状态

    private Date lastLoginAt; //最近一次登录时间

    private Date registerAt; //注册时间

    private String ext1; //预留字段1

    private String ext2; //预留字段2

    private String name;
    private Integer sex;
    private Date registerTime;
    private Date lastLoginTime;
    private Integer platformType;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }
}

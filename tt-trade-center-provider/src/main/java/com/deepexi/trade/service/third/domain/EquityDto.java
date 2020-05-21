package com.deepexi.trade.service.third.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 权益DTO
 *
 * @author 蝈蝈
 */
public class EquityDto implements Serializable {

    private String id;

    /**
     * 创建方式（1-权益包、2-权益包+优惠券）
     */
    private Integer createType;

    /**
     * 申请权益类型（1-优惠券）
     */
    private Integer type;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动金额
     */
    private BigDecimal amount;

    /**
     * 占用金额
     */
    private BigDecimal frozenAmount;

    /**
     * 活动素材/资料名称
     */
    private String fileName;

    /**
     * 活动素材/资料URL
     */
    private String fileUrl;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户编码
     */
    private String merchantCode;

    /**
     * 商户电话
     */
    private String merchantMobile;

    /**
     * 商户联系人
     */
    private String merchantContactPerson;

    /**
     * 商户联系电话
     */
    private String merchantContactMobile;

    /**
     * 商户-省份
     */
    private String merchantProvince;

    /**
     * 商户-市
     */
    private String merchantCity;

    /**
     * 商户-区
     */
    private String merchantArea;

    /**
     * 商户详细地址
     */
    private String merchantAddress;

    /**
     * 审核状态（0-待审核、1-已通过、2-未通过）
     */
    private Integer auditStatus;

    /**
     * 审核说明
     */
    private String auditRemark;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 优惠券信息
     */
    private CouponDetailForEquityDto couponInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantMobile() {
        return merchantMobile;
    }

    public void setMerchantMobile(String merchantMobile) {
        this.merchantMobile = merchantMobile;
    }

    public String getMerchantContactPerson() {
        return merchantContactPerson;
    }

    public void setMerchantContactPerson(String merchantContactPerson) {
        this.merchantContactPerson = merchantContactPerson;
    }

    public String getMerchantContactMobile() {
        return merchantContactMobile;
    }

    public void setMerchantContactMobile(String merchantContactMobile) {
        this.merchantContactMobile = merchantContactMobile;
    }

    public String getMerchantProvince() {
        return merchantProvince;
    }

    public void setMerchantProvince(String merchantProvince) {
        this.merchantProvince = merchantProvince;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public String getMerchantArea() {
        return merchantArea;
    }

    public void setMerchantArea(String merchantArea) {
        this.merchantArea = merchantArea;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CouponDetailForEquityDto getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(CouponDetailForEquityDto couponInfo) {
        this.couponInfo = couponInfo;
    }
}


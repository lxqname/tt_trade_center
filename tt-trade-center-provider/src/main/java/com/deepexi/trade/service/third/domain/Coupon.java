package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券
 *
 * @author 蝈蝈
 */
@TableName("ac_coupon")
public class Coupon extends SuperEntity implements Serializable {

    /**
     * 商品类型 0-电子卡券
     */
    private Integer productType;

    /**
     * 权益ID
     */
    private String equityId;

    /**
     * 优惠券编码
     */
    private String code;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 面值
     */
    private BigDecimal faceValue;

    /**
     * 预计发放数量
     */
    private Integer expectIssueNum;

    /**
     * 实际发放数量（已发放数量）
     */
    private Integer actualIssueNum;

    /**
     * 核销数量
     */
    private Integer useNum;

    /**
     * 使用条件（核销条件）-（0-无门槛、1-满额、2-自定义）
     */
    private Integer useLimitFlag;

    /**
     * 自定义核销条件说明
     */
    private String useDivRemark;

    /**
     * 满额金额
     */
    private BigDecimal fullAmount;

    /**
     * 使用时间类型（0-不限制、1-指定时间、2-自领取后规定天数有效）
     */
    private Integer useTimeFlag;

    /**
     * 使用开始时间
     */
    private Date useStartTime;

    /**
     * 使用结束时间
     */
    private Date useEndTime;

    /**
     * 有效天数（自领取日起）
     */
    private Integer validDay;

    /**
     * 描述
     */
    private String description;

    /**
     * 使用说明
     */
    private String useDescription;

    /**
     * 优惠券主图图片url
     */
    private String imageUrl;

    /**
     * 优惠券副图图片url（逗号分隔）
     */
    private String subImageUrls;

    /**
     * 后端类目id
     */
    private String categoryId;

    /**
     * 审核状态（0-待审核、1-已通过、2-未通过）
     */
    private Integer auditStatus;

    /**
     * 优惠券状态
     */
    private Integer status;

    /**
     * 关联活动状态 (0=未关联 1=已关联)
     */
    private Integer activityRelationStatus;

    /**
     * 应用类型(1-运营平台、2-商户平台)
     */
    private Integer applicationType;

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public Integer getExpectIssueNum() {
        return expectIssueNum;
    }

    public void setExpectIssueNum(Integer expectIssueNum) {
        this.expectIssueNum = expectIssueNum;
    }

    public Integer getActualIssueNum() {
        return actualIssueNum;
    }

    public void setActualIssueNum(Integer actualIssueNum) {
        this.actualIssueNum = actualIssueNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getUseLimitFlag() {
        return useLimitFlag;
    }

    public void setUseLimitFlag(Integer useLimitFlag) {
        this.useLimitFlag = useLimitFlag;
    }

    public String getUseDivRemark() {
        return useDivRemark;
    }

    public void setUseDivRemark(String useDivRemark) {
        this.useDivRemark = useDivRemark;
    }

    public BigDecimal getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(BigDecimal fullAmount) {
        this.fullAmount = fullAmount;
    }

    public Integer getUseTimeFlag() {
        return useTimeFlag;
    }

    public void setUseTimeFlag(Integer useTimeFlag) {
        this.useTimeFlag = useTimeFlag;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public Integer getValidDay() {
        return validDay;
    }

    public void setValidDay(Integer validDay) {
        this.validDay = validDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSubImageUrls() {
        return subImageUrls;
    }

    public void setSubImageUrls(String subImageUrls) {
        this.subImageUrls = subImageUrls;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActivityRelationStatus() {
        return activityRelationStatus;
    }

    public void setActivityRelationStatus(Integer activityRelationStatus) {
        this.activityRelationStatus = activityRelationStatus;
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }
}


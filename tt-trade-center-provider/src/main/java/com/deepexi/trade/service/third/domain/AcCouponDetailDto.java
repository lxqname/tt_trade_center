package com.deepexi.trade.service.third.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   * Created by JiaMing on 2019/4/24.
 */
public class AcCouponDetailDto implements Serializable{

    private String id;

    /**
     * 权益ID
     */
    private String equityId;
    /**
     * 权益名称
     */
    private String equityName;
    /**
     * 权益金额
     */
    private BigDecimal equityAmount;
    /**
     * 权益占用金额
     */
    private BigDecimal equityFrozenAmount;
    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 优惠券编码（奖品编码）
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

    private String tenantCode;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private Integer  version;

    private Integer dr;

    /**
     * 优惠券状态
     */
    private Integer status;
    /**
     * 权益包数组
     */
    private List<EquityDto> equityList = new ArrayList<>();

    /**
     * 优惠券面额/数值/条件
     */
    List<CouponItemDto> items = new ArrayList<>();

    /**
     * 关联活动状态
     */
    private Integer activityRelationStatus;

    private String relationId;

    /**
     * 商品类型 0-电子卡券
     */
    private Integer productType;

    /**
     * 优惠券图片(保存在award表)
     */
    private String imageUrl;

    /**
     * 后端类目ID
     */
    private String categoryId;

    /**
     * 后端类目名称
     */
    private String categoryName;

    /**
     * 后端类目名称数组
     */
    private List<String> categoryNames = new ArrayList<>();

    /**
     * 商品标签ID列表
     */
    private List<String> tagIds = new ArrayList<>();

    /**
     * 商品标签名称列表
     */
    private List<String> tagNames = new ArrayList<>();

    /**
     * 应用类型(1-运营平台、2-商户平台)
     */
    private Integer applicationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
    }

    public String getEquityName() {
        return equityName;
    }

    public void setEquityName(String equityName) {
        this.equityName = equityName;
    }

    public BigDecimal getEquityAmount() {
        return equityAmount;
    }

    public void setEquityAmount(BigDecimal equityAmount) {
        this.equityAmount = equityAmount;
    }

    public BigDecimal getEquityFrozenAmount() {
        return equityFrozenAmount;
    }

    public void setEquityFrozenAmount(BigDecimal equityFrozenAmount) {
        this.equityFrozenAmount = equityFrozenAmount;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EquityDto> getEquityList() {
        return equityList;
    }

    public void setEquityList(List<EquityDto> equityList) {
        this.equityList = equityList;
    }

    public List<CouponItemDto> getItems() {
        return items;
    }

    public void setItems(List<CouponItemDto> items) {
        this.items = items;
    }

    public Integer getActivityRelationStatus() {
        return activityRelationStatus;
    }

    public void setActivityRelationStatus(Integer activityRelationStatus) {
        this.activityRelationStatus = activityRelationStatus;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<String> tagIds) {
        this.tagIds = tagIds;
    }

    public List<String> getTagNames() {
        return tagNames;
    }

    public void setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }
}

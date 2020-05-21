package com.deepexi.trade.service.third.domain;

import java.util.Date;
import java.util.List;

/**
 * 优惠券详情-权益专用
 *
 * @author 蝈蝈
 * @since 2019年07月03日 17:24
 */
public class CouponDetailForEquityDto {

    /**
     * 商品类型 0-电子卡券
     */
    private Integer productType;

    /**
     * 优惠券名称
     */
    private String name;

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
     * 后端类目id
     */
    private String categoryId;

    /**
     * 后端类目名称数组（用于前端回显）
     */
    private List<String> categoryNames;

    /**
     * 商品标签ID列表
     */
    private List<String> tagIds;

    /**
     * 商品标签名称列表（用于前端回显）
     */
    private List<String> tagNames;

    /**
     * 优惠券主图图片url
     */
    private String imageUrl;

    /**
     * 优惠券副图图片url（逗号分隔）
     */
    private String subImageUrls;

    /**
     * 优惠券面额/数值/条件（用于前端回显）
     */
    private List<CouponItemDto> items;

    /**
     * 描述
     */
    private String description;

    /**
     * 使用说明
     */
    private String useDescription;

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public List<CouponItemDto> getItems() {
        return items;
    }

    public void setItems(List<CouponItemDto> items) {
        this.items = items;
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
}

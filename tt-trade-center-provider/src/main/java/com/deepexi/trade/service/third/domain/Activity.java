package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动
 *
 * @author 蝈蝈
 */
@TableName("ac_activity")
public class Activity extends SuperEntity implements Serializable{

    /**
     * 活动类型（1-领取优惠券活动、2-助力活动）
     */
    private Integer type;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 活动真实结束时间
     */
    private Date realEndTime;

    /**
     * 预告时间
     */
    private Integer trailTime;

    /**
     * 有效时间
     */
    private BigDecimal validTime;

    /**
     * 活动封面URL
     */
    private String imageUrl;

    /**
     * 助力者活动封面URL
     */
    private String boostImageUrl;

    /**
     * 缩略图URL
     */
    private String thumbnailUrl;

    /**
     * 会员端邀请海报URL
     */
    private String inviteImageUrl;

    /**
     * 推广平台海报URL
     */
    private String promotionImageUrl;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 助力说明
     */
    private String boostDescription;

    /**
     * 活动状态（0-草稿、1-待审核、2-待生效、3-进行中、4-已失效、5-已驳回）
     */
    private Integer status;

    /**
     * 关联ID
     */
    private String relationId;

    /**
     * 平台推广（0-不允许推广、1-允许推广）
     */
    private Integer platformPromotion;

    /**
     * 渠道推广（0-不允许推广、1-允许全部渠道推广、2-允许部分渠道推广）
     */
    private Integer channelPromotion;

    /**
     * 助力奖品发放条件类型（
     * 1-满足任一阶梯后即发放每一阶梯的奖品
     * 2-满足活动最高阶梯后即发放全部阶梯的奖品
     * 3-活动结束后发放所满足的全部阶梯奖品
     * 4-活动结束后发放所满足的最高阶梯奖品
     * 5-有效期结束后发放所满足的全部阶梯奖品
     * 6-有效期结束后发放所满足的最高阶梯奖品）
     */
    private Integer boostAwardIssueType;

    private String distributeNow;

    private Date distributeTime;

    public final static String DISTRIBUTENOW_YES = "1";
    public final static String DISTRIBUTENOW_NO = "0";

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    public Integer getTrailTime() {
        return trailTime;
    }

    public void setTrailTime(Integer trailTime) {
        this.trailTime = trailTime;
    }

    public BigDecimal getValidTime() {
        return validTime;
    }

    public void setValidTime(BigDecimal validTime) {
        this.validTime = validTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBoostImageUrl() {
        return boostImageUrl;
    }

    public void setBoostImageUrl(String boostImageUrl) {
        this.boostImageUrl = boostImageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getInviteImageUrl() {
        return inviteImageUrl;
    }

    public void setInviteImageUrl(String inviteImageUrl) {
        this.inviteImageUrl = inviteImageUrl;
    }

    public String getPromotionImageUrl() {
        return promotionImageUrl;
    }

    public void setPromotionImageUrl(String promotionImageUrl) {
        this.promotionImageUrl = promotionImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBoostDescription() {
        return boostDescription;
    }

    public void setBoostDescription(String boostDescription) {
        this.boostDescription = boostDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Integer getPlatformPromotion() {
        return platformPromotion;
    }

    public void setPlatformPromotion(Integer platformPromotion) {
        this.platformPromotion = platformPromotion;
    }

    public Integer getChannelPromotion() {
        return channelPromotion;
    }

    public void setChannelPromotion(Integer channelPromotion) {
        this.channelPromotion = channelPromotion;
    }

    public Integer getBoostAwardIssueType() {
        return boostAwardIssueType;
    }

    public void setBoostAwardIssueType(Integer boostAwardIssueType) {
        this.boostAwardIssueType = boostAwardIssueType;
    }

    public String getDistributeNow() {
        return distributeNow;
    }

    public void setDistributeNow(String distributeNow) {
        this.distributeNow = distributeNow;
    }

    public Date getDistributeTime() {
        return distributeTime;
    }

    public void setDistributeTime(Date distributeTime) {
        this.distributeTime = distributeTime;
    }
}


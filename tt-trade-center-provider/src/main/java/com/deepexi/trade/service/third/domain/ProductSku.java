package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku表
 *
 *   @author JiaMing  2019/5/17.
 */
@TableName("ac_product_sku")
public class ProductSku extends SuperEntity implements Serializable{

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品类型
     */
    private Integer type;
    /**
     * 商品简称
     */
    private String shortName;

    /**
     * 优惠券总金额
     */
    private BigDecimal couponSumPrice;

    /**
     * 商品原价
     */
    private BigDecimal prePrice;

    /**
     * 商品最终价格
     */
    private BigDecimal finalPrice;

    /**
     * 商品会员价格
     */
    private BigDecimal vipPrice;

    /**
     * 商品总库存
     */
    private Integer totalStock;

    /**
     * 商品剩余库存
     */
    private Integer remainStock;

    /**
     * 商品冻结库存
     */
    private Integer frozenStock;

    /**
     * 商品作废库存
     */
    private Integer obsoleteStock;

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 商品状态 0-过期 1-可用
     */
    private Integer status;

    /**
     * 商品图片url 列表推广图
     */
    private String imageUrl;

    /**
     * 商品图片url 详情轮播图  xxx,xxx
     */
    private String imageUrls;

    /**
     * 使用说明
     */
    private String useDescription;

    /**
     * 描述
     */
    private String description;

    /**
     * 上架时间类型 1-立即上架 2-定时上架
     */
    private Integer onShelfTimeType;

    /**
     * 上架时间
     */
    private Date onShelfTime;

    /**
     * 实际上架时间
     */
    private Date realOnShelfTime;

    /**
     * 下架时间类型 1-无限制(需手动下架) 2-定时上架
     */
    private Integer offShelfTimeType;

    /**
     * 下架时间
     */
    private Date offShelfTime;

    /**
     * 实际下架时间
     */
    private Date realOffShelfTime;

    /**
     * 平台推广（0-不允许推广、1-允许推广）
     */
    private Integer platformPromotion;

    /**
     * 渠道推广（0-不允许推广、1-允许全部渠道推广、2-允许部分渠道推广）
     */
    private Integer channelPromotion;

    /**
     * 购券目标对象类型  1-全部会员 2-部分会员
     */
    private Integer buyTargetType;

    /**
     * 购券限制 0-不限制 1-限制
     */
    private Integer buyNumLimitFlag;

    /**
     * 限制数量
     */
    private Integer limitNum;

    /**
     * 推广平台海报URL
     */
    private String promotionImageUrl;

    /**
     * 审核状态（0-草稿、1-待审核、2-审核通过、3-已驳回/审核不通过）
     */
    private Integer auditStatus;

    /**
     * 上架状态（0-待上架、1-已上架、2-已下架）
     */
    private Integer shelfStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BigDecimal getCouponSumPrice() {
        return couponSumPrice;
    }

    public void setCouponSumPrice(BigDecimal couponSumPrice) {
        this.couponSumPrice = couponSumPrice;
    }

    public BigDecimal getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getRemainStock() {
        return remainStock;
    }

    public void setRemainStock(Integer remainStock) {
        this.remainStock = remainStock;
    }

    public Integer getFrozenStock() {
        return frozenStock;
    }

    public void setFrozenStock(Integer frozenStock) {
        this.frozenStock = frozenStock;
    }

    public Integer getObsoleteStock() {
        return obsoleteStock;
    }

    public void setObsoleteStock(Integer obsoleteStock) {
        this.obsoleteStock = obsoleteStock;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOnShelfTimeType() {
        return onShelfTimeType;
    }

    public void setOnShelfTimeType(Integer onShelfTimeType) {
        this.onShelfTimeType = onShelfTimeType;
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public Date getRealOnShelfTime() {
        return realOnShelfTime;
    }

    public void setRealOnShelfTime(Date realOnShelfTime) {
        this.realOnShelfTime = realOnShelfTime;
    }

    public Integer getOffShelfTimeType() {
        return offShelfTimeType;
    }

    public void setOffShelfTimeType(Integer offShelfTimeType) {
        this.offShelfTimeType = offShelfTimeType;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public Date getRealOffShelfTime() {
        return realOffShelfTime;
    }

    public void setRealOffShelfTime(Date realOffShelfTime) {
        this.realOffShelfTime = realOffShelfTime;
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

    public Integer getBuyTargetType() {
        return buyTargetType;
    }

    public void setBuyTargetType(Integer buyTargetType) {
        this.buyTargetType = buyTargetType;
    }

    public Integer getBuyNumLimitFlag() {
        return buyNumLimitFlag;
    }

    public void setBuyNumLimitFlag(Integer buyNumLimitFlag) {
        this.buyNumLimitFlag = buyNumLimitFlag;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getPromotionImageUrl() {
        return promotionImageUrl;
    }

    public void setPromotionImageUrl(String promotionImageUrl) {
        this.promotionImageUrl = promotionImageUrl;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Integer shelfStatus) {
        this.shelfStatus = shelfStatus;
    }
}

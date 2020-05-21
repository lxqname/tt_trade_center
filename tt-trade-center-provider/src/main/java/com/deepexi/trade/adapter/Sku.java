package com.deepexi.trade.adapter;

import com.deepexi.trade.service.third.domain.MemberCouponRelationDto;
import com.deepexi.util.StringUtil;

import java.math.BigDecimal;
import java.util.List;

public class Sku {

    //copy from TcOrderSku
    private String skuId;
    //@ApiModelProperty(value = "子订单关联id")
    private String orderSkuId;
    //@ApiModelProperty(value = "商品关联id")
    private String awardId;
    //@ApiModelProperty(value = "商品关联名称")
    private String awardName;
    //@ApiModelProperty(value = "商品类型 1、单商品  2、组合优惠商品")
    private Integer awardType;
    //@ApiModelProperty(value = "商品标志 1=已过期，0=未过期/部分未使用 2=已使用")
    private Integer awardStatus;
    //@ApiModelProperty(value = "数量件数")
    private Integer  count;
    //@ApiModelProperty(value = "原始金额")
    private BigDecimal originalAmount;
    //@ApiModelProperty(value = "优惠金额")
    private BigDecimal  discountsAmount;
    //@ApiModelProperty(value = "小计(总金额)")
    private BigDecimal  subtotal;
    //@ApiModelProperty(value = "商品图片url")
    private String imageUrl;
    //@ApiModelProperty(value = "兑换方式：1、现金")
    private Integer exchangeType;
    //@ApiModelProperty(value = "面值")
    private BigDecimal faceValue;
    //@ApiModelProperty(value = "使用说明)
    private String useDescription;
    //@ApiModelProperty(value = "满额金额")
    private BigDecimal fullAmount;

    //copy from TcOrderchild
    private String merchantId;
    //@ApiModelProperty(value = "商户关联名称")
    private String merchantName;

    private String memberAwardItemRelationId;


    List<MemberCouponRelationDto> memberCouponRelationDtos;

    public List<MemberCouponRelationDto> getMemberCouponRelationDtos() {
        return memberCouponRelationDtos;
    }

    public void setMemberCouponRelationDtos(List<MemberCouponRelationDto> memberCouponRelationDtos) {
        this.memberCouponRelationDtos = memberCouponRelationDtos;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getAwardStatus() {
        return awardStatus;
    }

    public void setAwardStatus(Integer awardStatus) {
        this.awardStatus = awardStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getDiscountsAmount() {
        return discountsAmount;
    }

    public void setDiscountsAmount(BigDecimal discountsAmount) {
        this.discountsAmount = discountsAmount;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }

    public BigDecimal getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(BigDecimal fullAmount) {
        this.fullAmount = fullAmount;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
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

    public String getMemberAwardItemRelationId() {
        return memberAwardItemRelationId;
    }

    public void setMemberAwardItemRelationId(String memberAwardItemRelationId) {
        this.memberAwardItemRelationId = memberAwardItemRelationId;
    }

    public void appendMemberAwardItemRelationId(String memberAwardItemRelationId) {
        if (StringUtil.isNotEmpty(getMemberAwardItemRelationId())){
            this.memberAwardItemRelationId = memberAwardItemRelationId+ "," + getMemberAwardItemRelationId();
        }else {
            this.memberAwardItemRelationId = memberAwardItemRelationId;
        }

    }

    public String getOrderSkuId() {
        return orderSkuId;
    }

    public void setOrderSkuId(String orderSkuId) {
        this.orderSkuId = orderSkuId;
    }
}

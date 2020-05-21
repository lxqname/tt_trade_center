package com.deepexi.trade.domain.vo;

import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.domain.eo.TcOrderChild;
import com.deepexi.trade.domain.eo.TcOrderSku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 14:31
 */
public class TcOrderChildVO extends TcOrderChild implements Serializable {

    private List<TcOrderSku> tcOrderSkus;

    public List<TcOrderSku> getTcOrderSkus() {
        return tcOrderSkus;
    }

    public void setTcOrderSkus(List<TcOrderSku> tcOrderSkus) {
        this.tcOrderSkus = tcOrderSkus;
    }


//    /**
//     * 商品id
//     */
//    private String awardId;
//
//    /**
//     * 商品类型 1、单商品  2、组合优惠商品
//     */
//    private Integer awardType;
//
//    /**
//     * 商品标志 1=已过期，0=未过期/部分未使用 2=已使用
//     */
//    private Integer awardStatus;
//
//    /**
//     * sku的id
//     */
//    private String skuId;
//
//    /**
//     * 商品图片url
//     */
//    private String imageUrl;
//    /**
//     * 商品名称
//     */
//    private String awardName;
//    /**
//     * 商品原始金额
//     */
//    private BigDecimal originalAmount;
//    /**
//     * 兑换的方式
//     */
//    private String exchangeType;
//    /**
//     * 件数
//     */
//    private String count;
//    /**
//     * 小计
//     */
//    private BigDecimal  subtotal;
//    /**
//     * 面值
//     */
//    private BigDecimal faceValue;
//    /**
//     * 使用说明
//     */
//    private String useDescription;
//    /**
//     * 满额金额
//     */
//    private BigDecimal fullAmount;
//
//    public String getAwardId() {
//        return awardId;
//    }
//
//    public void setAwardId(String awardId) {
//        this.awardId = awardId;
//    }
//
//    public Integer getAwardType() {
//        return awardType;
//    }
//
//    public void setAwardType(Integer awardType) {
//        this.awardType = awardType;
//    }
//
//    public Integer getAwardStatus() {
//        return awardStatus;
//    }
//
//    public void setAwardStatus(Integer awardStatus) {
//        this.awardStatus = awardStatus;
//    }
//
//    public String getSkuId() {
//        return skuId;
//    }
//
//    public void setSkuId(String skuId) {
//        this.skuId = skuId;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getAwardName() {
//        return awardName;
//    }
//
//    public void setAwardName(String awardName) {
//        this.awardName = awardName;
//    }
//
//    public BigDecimal getOriginalAmount() {
//        return originalAmount;
//    }
//
//    public void setOriginalAmount(BigDecimal originalAmount) {
//        this.originalAmount = originalAmount;
//    }
//
//    public String getExchangeType() {
//        return exchangeType;
//    }
//
//    public void setExchangeType(String exchangeType) {
//        this.exchangeType = exchangeType;
//    }
//
//    public String getCount() {
//        return count;
//    }
//
//    public void setCount(String count) {
//        this.count = count;
//    }
//
//    public BigDecimal getSubtotal() {
//        return subtotal;
//    }
//
//    public void setSubtotal(BigDecimal subtotal) {
//        this.subtotal = subtotal;
//    }
//
//    public BigDecimal getFaceValue() {
//        return faceValue;
//    }
//
//    public void setFaceValue(BigDecimal faceValue) {
//        this.faceValue = faceValue;
//    }
//
//    public String getUseDescription() {
//        return useDescription;
//    }
//
//    public void setUseDescription(String useDescription) {
//        this.useDescription = useDescription;
//    }
//
//    public BigDecimal getFullAmount() {
//        return fullAmount;
//    }
//
//    public void setFullAmount(BigDecimal fullAmount) {
//        this.fullAmount = fullAmount;
//    }
}

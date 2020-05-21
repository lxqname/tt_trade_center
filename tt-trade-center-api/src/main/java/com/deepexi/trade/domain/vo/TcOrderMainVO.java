package com.deepexi.trade.domain.vo;

import com.deepexi.trade.domain.eo.TcOrderMain;
import com.deepexi.trade.domain.eo.TcOrderSku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 14:31
 */
public class TcOrderMainVO extends TcOrderMain implements Serializable {

    private List<TcOrderChildVO> tcOrderChildVOS;

    public List<TcOrderChildVO> getTcOrderChildVOS() {
        return tcOrderChildVOS;
    }

    public void setTcOrderChildVOS(List<TcOrderChildVO> tcOrderChildVOS) {
        this.tcOrderChildVOS = tcOrderChildVOS;
    }
    /**
     * 订单id
     */
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
//    /**
//     * 商品图片
//     */
//    private String imageUrl;
//    /**
//     * 原始金额
//     */
//    private BigDecimal originalAmount;
    /**
     * 总件数
     */
    private Integer count = 0;
//    /**
//     * 商品id
//     */
//    private String awardId;
//    /**
//     * 商品名称
//     */
//    private String awardName;
//    /**
//     * 商户id
//     */
//    private String merchantId;
//    /**
//     * 商户名称
//     */
//    private String merchantName;
//    /**
//     * 活动id
//     */
//    private String eventId;
//    /**
//     * 活动名称
//     */
//    private String eventName;
//    /**
//     * 活动编号
//     */
//    private String eventNo;
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
    /**
     * 0未退款，1有退款
     */
    private Integer isRefund ;

    public Integer getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
    }

    /**
     * 商品类型 1、单商品  2、组合优惠商品
     */
    private Integer awardType ;

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getCount() {
        Integer t = 0;
        List<TcOrderChildVO> tcOrderChildVOS = getTcOrderChildVOS();
        if (null != tcOrderChildVOS){
            for(TcOrderChildVO tcOrderChildVO :tcOrderChildVOS){
                List<TcOrderSku> tcOrderSkus = tcOrderChildVO.getTcOrderSkus();
                if ( null != tcOrderSkus){
                    for(TcOrderSku tcOrderSku : tcOrderSkus){
                        t += tcOrderSku.getCount();
                    }
                }
            }
        }
        return t > 0 ? t : count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
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
//    private String productId;
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
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
//    public BigDecimal getOriginalAmount() {
//        return originalAmount;
//    }
//
//    public void setOriginalAmount(BigDecimal originalAmount) {
//        this.originalAmount = originalAmount;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public String getMerchantId() {
//        return merchantId;
//    }
//
//    public void setMerchantId(String merchantId) {
//        this.merchantId = merchantId;
//    }
//
//    public String getMerchantName() {
//        return merchantName;
//    }
//
//    public void setMerchantName(String merchantName) {
//        this.merchantName = merchantName;
//    }
//
//    public String getEventId() {
//        return eventId;
//    }
//
//    public void setEventId(String eventId) {
//        this.eventId = eventId;
//    }
//
//    public String getEventName() {
//        return eventName;
//    }
//
//    public void setEventName(String eventName) {
//        this.eventName = eventName;
//    }
//
//    public String getEventNo() {
//        return eventNo;
//    }
//
//    public void setEventNo(String eventNo) {
//        this.eventNo = eventNo;
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
//
//    public String getAwardId() {
//        return awardId;
//    }
//
//    public void setAwardId(String awardId) {
//        this.awardId = awardId;
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
//    public Integer getIsRefund() {
//        return isRefund;
//    }
//
//    public void setIsRefund(Integer isRefund) {
//        this.isRefund = isRefund;
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
//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }
}

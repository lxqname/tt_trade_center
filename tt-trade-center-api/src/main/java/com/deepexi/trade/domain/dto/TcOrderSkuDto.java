package com.deepexi.trade.domain.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.deepexi.trade.domain.eo.TcOrderSku;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/**
 * @desc tc_order_sku
 * @author admin
 */
public class TcOrderSkuDto implements Serializable {
    private Integer chargeCount;

    private String orderChildId;

    private String awardId;

    private String awardName;

    private Integer  count;

    private Integer  discountsAmount;

    private Integer  originalAmount;

    private Integer  subtotal;

    private String imageUrl;

    private Boolean exchangeType;

    private String productId;

    private String orderId;

    //@ApiModelProperty(value = "商品类型 1、单商品  2、组合优惠商品")
    private Integer awardType;
    //@ApiModelProperty(value = "商品标志 1=已过期，0=未过期/部分未使用 2=已使用")
    private Integer awardStatus;
    //@ApiModelProperty(value = "数量件数")
    //@ApiModelProperty(value = "面值")
    private BigDecimal faceValue;
    //@ApiModelProperty(value = "使用说明)
    private String useDescription;
    //@ApiModelProperty(value = "满额金额")
    private BigDecimal fullAmount;

    private String id;

    private String tenantCode;

    private Integer version;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    private Integer dr;


    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public Date getCreatedAt(){
        return this.createdAt;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public String getCreatedBy(){
        return this.createdBy;
    }

    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt(){
        return this.updatedAt;
    }

    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy(){
        return this.updatedBy;
    }

    public void setOrderChildId(String orderChildId){
        this.orderChildId = orderChildId;
    }

    public String getOrderChildId(){
        return this.orderChildId;
    }

    public void setAwardId(String awardId){
        this.awardId = awardId;
    }

    public String getAwardId(){
        return this.awardId;
    }

    public void setAwardName(String awardName){
        this.awardName = awardName;
    }

    public String getAwardName(){
        return this.awardName;
    }

    public void setCount(Integer  count){
        this.count = count;
    }

    public Integer  getCount(){
        return this.count;
    }

    public void setDiscountsAmount(Integer  discountsAmount){
        this.discountsAmount = discountsAmount;
    }

    public Integer  getDiscountsAmount(){
        return this.discountsAmount;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public void setSubtotal(Integer  subtotal){
        this.subtotal = subtotal;
    }

    public Integer  getSubtotal(){
        return this.subtotal;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public void setExchangeType(Boolean exchangeType){
        this.exchangeType = exchangeType;
    }

    public Boolean getExchangeType(){
        return this.exchangeType;
    }

    public Integer getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
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
}


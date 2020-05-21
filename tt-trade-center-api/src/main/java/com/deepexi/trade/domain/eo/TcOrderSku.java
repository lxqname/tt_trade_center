package com.deepexi.trade.domain.eo;



import java.io.Serializable;
import java.math.BigDecimal;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_sku
 * @author admin
 */
//@ApiModel(description = "子订单详情表")
public class TcOrderSku extends SuperEntity implements Serializable{


    private Integer chargeCount;
    //@ApiModelProperty(value = "子订单关联id")
    private String orderChildId;
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

    private String productId;

    private String orderId;

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

    public Integer  getCount(){
        return this.count;
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

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return this.imageUrl;
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
}


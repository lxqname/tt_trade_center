package com.deepexi.trade.domain.dto;

import com.deepexi.trade.domain.eo.TcOrderChild;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

/**
 * @desc tc_order_child
 * @author admin
 */
public class TcOrderChildDto implements Serializable {

    //@ApiModelProperty(value = "主表订单关联id")
    private String orderId;
    //@ApiModelProperty(value = "子订单号")
    private String childNo;
    //@ApiModelProperty(value = "订单状态：0、已取消订单(关闭订单)1、待付款2、待发货3、待核销(待收货)4、已完成")
    private Integer childStatus;
    //@ApiModelProperty(value = "支付方式：1、微信 2、支付宝 3、云闪付")
    private Integer childPayType;
    //@ApiModelProperty(value = "支付金额")
    private BigDecimal childAmount;
    //@ApiModelProperty(value = "支付订单号(支付成功后才有)")
    private String orderPayNo;
    //@ApiModelProperty(value = "商户关联id")
    private String merchantId;
    //@ApiModelProperty(value = "商户关联名称")
    private String merchantName;
    //@ApiModelProperty(value = "活动关联id")
    private String eventId;
    //@ApiModelProperty(value = "活动关联名称")
    private String eventName;
    //@ApiModelProperty(value = "活动编号")
    private String eventNo;

    private String id;

    private String tenantCode;

    private Integer version;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    private Integer dr;



    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public void setChildNo(String childNo){
        this.childNo = childNo;
    }

    public String getChildNo(){
        return this.childNo;
    }


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

    public Integer getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(Integer childStatus) {
        this.childStatus = childStatus;
    }

    public Integer getChildPayType() {
        return childPayType;
    }

    public void setChildPayType(Integer childPayType) {
        this.childPayType = childPayType;
    }

    public BigDecimal getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(BigDecimal childAmount) {
        this.childAmount = childAmount;
    }

    public String getOrderPayNo() {
        return orderPayNo;
    }

    public void setOrderPayNo(String orderPayNo) {
        this.orderPayNo = orderPayNo;
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo;
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


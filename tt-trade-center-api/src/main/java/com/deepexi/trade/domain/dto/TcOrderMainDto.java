package com.deepexi.trade.domain.dto;

import javax.ws.rs.QueryParam;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @desc tc_order_main
 * @author admin
 */
public class TcOrderMainDto extends BaseDto{



    private String id;


    private Integer version;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    private Integer dr;



    //pc wx
    @QueryParam("deviceType")
    private String deviceType;

    //商户名称
    @QueryParam("merchantName")
    private String merchantName;

    //订单编号
    @QueryParam("orderNo")
    private String orderNo;

    //订单类型
    @QueryParam("orderType")
    private Integer orderType;

    //会员id
    @QueryParam("memberId")
    private String memberId;

    //订单关闭时间
    private Integer closeTime;


    //订单状态
    @QueryParam("status")
    private String status;

    //订单状态
    private Integer orderStatus;

    //中间状态操作
    private Integer operatingStatus;

    //排序条件
    private String orderBy ;

    //需要更新的ids
    private List<String> ids;

    //商品id
    private String awardId;

    //租户
    @QueryParam("tenantId")
    private String tenantCode;

    //支付订单号(支付成功后才有)
    private String orderPayNo;


    //@ApiModelProperty(value = "会员关联名称")
    private String memberName;
    //@ApiModelProperty(value = "支付方式：1、微信 2、支付宝 3、云闪付")
    private Integer payType;
    //@ApiModelProperty(value = "支付金额")
    private BigDecimal amount;
    //@ApiModelProperty(value = "消耗的积分")
    private String expendIntegral;
    //@ApiModelProperty(value = "消耗的优惠券id")
    private String expendCouponId;





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Integer getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getOrderPayNo() {
        return orderPayNo;
    }

    public void setOrderPayNo(String orderPayNo) {
        this.orderPayNo = orderPayNo;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getExpendIntegral() {
        return expendIntegral;
    }

    public void setExpendIntegral(String expendIntegral) {
        this.expendIntegral = expendIntegral;
    }

    public String getExpendCouponId() {
        return expendCouponId;
    }

    public void setExpendCouponId(String expendCouponId) {
        this.expendCouponId = expendCouponId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}


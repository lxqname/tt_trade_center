package com.deepexi.trade.service.third.domain;


import com.deepexi.equity.domain.dto.CouponAndPackageDto;
import com.deepexi.product.domain.eo.Product;

import javax.ws.rs.QueryParam;
import java.io.Serializable;
import java.util.Date;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc MemberCouponRelationDto
 * @author yunzi7758
 * @Date: Sat Oct 19 10:35:30 CST 2019
 *
 *
 * //@ApiModel(description = "ac_member_coupon_relation")
 * //@TableName("ac_member_coupon_relation")
 */
public class MemberCouponRelationDto implements Serializable  {


        /** //@ApiModelProperty(value = "ID主键") */
        /** ID主键 */
        @QueryParam("id")
        private String id;

        /** //@ApiModelProperty(value = "会员ID") */
        /** 会员ID */
        @QueryParam("memberId")
        private String memberId;

        /** //@ApiModelProperty(value = "优惠券ID") */
        /** 优惠券ID */
        @QueryParam("couponId")
        private String couponId;

        /** //@ApiModelProperty(value = "优惠券组合包ID") */
        /** 优惠券组合包ID */
        @QueryParam("couponPackageId")
        private String couponPackageId;

        /** //@ApiModelProperty(value = "活动优惠券关系ID") */
        /** 活动优惠券关系ID */
        @QueryParam("activityCouponRelationId")
        private String activityCouponRelationId;

        /** //@ApiModelProperty(value = "活动ID") */
        /** 活动ID */
        @QueryParam("activityId")
        private String activityId;

        /** //@ApiModelProperty(value = "商品ID") */
        /** 商品ID */
        @QueryParam("productId")
        private String productId;

        /** //@ApiModelProperty(value = "订单ID") */
        /** 订单ID */
        @QueryParam("orderId")
        private String orderId;

        /** //@ApiModelProperty(value = "订单奖品ID") */
        /** 订单奖品ID */
        @QueryParam("orderAwardId")
        private String orderAwardId;

        /** //@ApiModelProperty(value = "核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期、5-冻结中、6-退款失效）") */
        /** 核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期、5-冻结中、6-退款失效） */
        @QueryParam("verificationStatus")
        private Integer verificationStatus;

        /** //@ApiModelProperty(value = "领取方式（0-系统发放、1-线上领取、2-线上购买）") */
        /** 领取方式（0-系统发放、1-线上领取、2-线上购买） */
        @QueryParam("receiveType")
        private Integer receiveType;

        /** //@ApiModelProperty(value = "领取时间") */
        /** 领取时间 */
        @QueryParam("receiveTime")
        private Date receiveTime;

        /** //@ApiModelProperty(value = "核销时间") */
        /** 核销时间 */
        @QueryParam("verificationTime")
        private Date verificationTime;

        /** //@ApiModelProperty(value = "核销人员类型（1-商户、2-渠道）") */
        /** 核销人员类型（1-商户、2-渠道） */
        @QueryParam("verificationPersonType")
        private Integer verificationPersonType;

        /** //@ApiModelProperty(value = "核销人员ID") */
        /** 核销人员ID */
        @QueryParam("verificationPersonId")
        private String verificationPersonId;

        /** //@ApiModelProperty(value = "核销人员账号ID") */
        /** 核销人员账号ID */
        @QueryParam("verificationPersonAccountId")
        private String verificationPersonAccountId;

        /** //@ApiModelProperty(value = "租户") */
        /** 租户 */
        @QueryParam("tenantCode")
        private String tenantCode;

        /** //@ApiModelProperty(value = "创建时间") */
        /** 创建时间 */
        @QueryParam("createdAt")
        private Date createdAt;

        /** //@ApiModelProperty(value = "创建人") */
        /** 创建人 */
        @QueryParam("createdBy")
        private String createdBy;

        /** //@ApiModelProperty(value = "更新时间") */
        /** 更新时间 */
        @QueryParam("updatedAt")
        private Date updatedAt;

        /** //@ApiModelProperty(value = "更新人") */
        /** 更新人 */
        @QueryParam("updatedBy")
        private String updatedBy;

        /** //@ApiModelProperty(value = "版本记录,修改时自增") */
        /** 版本记录,修改时自增 */
        @QueryParam("version")
        private Integer version;

        /** //@ApiModelProperty(value = "删除标志 1=已删除, 0=未删除") */
        /** 删除标志 1=已删除, 0=未删除 */
        @QueryParam("dr")
        private Integer dr;


        private Integer type;
        private String typeId;

        /**
         * 企业ID
         */
        private String enterpriseId;

        /**
         * 企业名称
         */
        private String enterpriseName;

        /**
         * 企业简称
         */
        private String enterpriseShortName;

        /**
         * 部门ID
         */
        private String organizationId;


        /**
         * 数量
         */
        private Integer count;

        private CouponAndPackageDto couponAndPackageDto;

        private Product product;


        public String getEnterpriseId() {
                return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
                this.enterpriseId = enterpriseId;
        }

        public String getEnterpriseName() {
                return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
                this.enterpriseName = enterpriseName;
        }

        public String getEnterpriseShortName() {
                return enterpriseShortName;
        }

        public void setEnterpriseShortName(String enterpriseShortName) {
                this.enterpriseShortName = enterpriseShortName;
        }

        public String getOrganizationId() {
                return organizationId;
        }

        public void setOrganizationId(String organizationId) {
                this.organizationId = organizationId;
        }

        public void setId(String id){
        /** ID主键 */
        this.id = id;
        }

        public String getId(){
        /** ID主键 */
        return this.id;
        }

        public void setMemberId(String memberId){
        /** 会员ID */
        this.memberId = memberId;
        }

        public String getMemberId(){
        /** 会员ID */
        return this.memberId;
        }

        public void setCouponId(String couponId){
        /** 优惠券ID */
        this.couponId = couponId;
        }

        public String getCouponId(){
        /** 优惠券ID */
        return this.couponId;
        }

        public void setCouponPackageId(String couponPackageId){
        /** 优惠券组合包ID */
        this.couponPackageId = couponPackageId;
        }

        public String getCouponPackageId(){
        /** 优惠券组合包ID */
        return this.couponPackageId;
        }

        public void setActivityCouponRelationId(String activityCouponRelationId){
        /** 活动优惠券关系ID */
        this.activityCouponRelationId = activityCouponRelationId;
        }

        public String getActivityCouponRelationId(){
        /** 活动优惠券关系ID */
        return this.activityCouponRelationId;
        }

        public void setActivityId(String activityId){
        /** 活动ID */
        this.activityId = activityId;
        }

        public String getActivityId(){
        /** 活动ID */
        return this.activityId;
        }

        public void setProductId(String productId){
        /** 商品ID */
        this.productId = productId;
        }

        public String getProductId(){
        /** 商品ID */
        return this.productId;
        }

        public void setOrderId(String orderId){
        /** 订单ID */
        this.orderId = orderId;
        }

        public String getOrderId(){
        /** 订单ID */
        return this.orderId;
        }

        public void setOrderAwardId(String orderAwardId){
        /** 订单奖品ID */
        this.orderAwardId = orderAwardId;
        }

        public String getOrderAwardId(){
        /** 订单奖品ID */
        return this.orderAwardId;
        }

        public void setVerificationStatus(Integer verificationStatus){
        /** 核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期、5-冻结中、6-退款失效） */
        this.verificationStatus = verificationStatus;
        }

        public Integer getVerificationStatus(){
        /** 核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期、5-冻结中、6-退款失效） */
        return this.verificationStatus;
        }

        public void setReceiveType(Integer receiveType){
        /** 领取方式（0-系统发放、1-线上领取、2-线上购买） */
        this.receiveType = receiveType;
        }

        public Integer getReceiveType(){
        /** 领取方式（0-系统发放、1-线上领取、2-线上购买） */
        return this.receiveType;
        }

        public void setReceiveTime(Date receiveTime){
        /** 领取时间 */
        this.receiveTime = receiveTime;
        }

        public Date getReceiveTime(){
        /** 领取时间 */
        return this.receiveTime;
        }

        public void setVerificationTime(Date verificationTime){
        /** 核销时间 */
        this.verificationTime = verificationTime;
        }

        public Date getVerificationTime(){
        /** 核销时间 */
        return this.verificationTime;
        }

        public void setVerificationPersonType(Integer verificationPersonType){
        /** 核销人员类型（1-商户、2-渠道） */
        this.verificationPersonType = verificationPersonType;
        }

        public Integer getVerificationPersonType(){
        /** 核销人员类型（1-商户、2-渠道） */
        return this.verificationPersonType;
        }

        public void setVerificationPersonId(String verificationPersonId){
        /** 核销人员ID */
        this.verificationPersonId = verificationPersonId;
        }

        public String getVerificationPersonId(){
        /** 核销人员ID */
        return this.verificationPersonId;
        }

        public void setVerificationPersonAccountId(String verificationPersonAccountId){
        /** 核销人员账号ID */
        this.verificationPersonAccountId = verificationPersonAccountId;
        }

        public String getVerificationPersonAccountId(){
        /** 核销人员账号ID */
        return this.verificationPersonAccountId;
        }

        public void setTenantCode(String tenantCode){
        /** 租户 */
        this.tenantCode = tenantCode;
        }

        public String getTenantCode(){
        /** 租户 */
        return this.tenantCode;
        }

        public void setCreatedAt(Date createdAt){
        /** 创建时间 */
        this.createdAt = createdAt;
        }

        public Date getCreatedAt(){
        /** 创建时间 */
        return this.createdAt;
        }

        public void setCreatedBy(String createdBy){
        /** 创建人 */
        this.createdBy = createdBy;
        }

        public String getCreatedBy(){
        /** 创建人 */
        return this.createdBy;
        }

        public void setUpdatedAt(Date updatedAt){
        /** 更新时间 */
        this.updatedAt = updatedAt;
        }

        public Date getUpdatedAt(){
        /** 更新时间 */
        return this.updatedAt;
        }

        public void setUpdatedBy(String updatedBy){
        /** 更新人 */
        this.updatedBy = updatedBy;
        }

        public String getUpdatedBy(){
        /** 更新人 */
        return this.updatedBy;
        }

        public void setVersion(Integer version){
        /** 版本记录,修改时自增 */
        this.version = version;
        }

        public Integer getVersion(){
        /** 版本记录,修改时自增 */
        return this.version;
        }

        public void setDr(Integer dr){
        /** 删除标志 1=已删除, 0=未删除 */
        this.dr = dr;
        }

        public Integer getDr(){
        /** 删除标志 1=已删除, 0=未删除 */
        return this.dr;
        }


        @Override
        public String toString() {
        return "MemberCouponRelation{" +
        /** ID主键 */
        "id=" + id +
        /** 会员ID */
        "memberId=" + memberId +
        /** 优惠券ID */
        "couponId=" + couponId +
        /** 优惠券组合包ID */
        "couponPackageId=" + couponPackageId +
        /** 活动优惠券关系ID */
        "activityCouponRelationId=" + activityCouponRelationId +
        /** 活动ID */
        "activityId=" + activityId +
        /** 商品ID */
        "productId=" + productId +
        /** 订单ID */
        "orderId=" + orderId +
        /** 订单奖品ID */
        "orderAwardId=" + orderAwardId +
        /** 核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期、5-冻结中、6-退款失效） */
        "verificationStatus=" + verificationStatus +
        /** 领取方式（0-系统发放、1-线上领取、2-线上购买） */
        "receiveType=" + receiveType +
        /** 领取时间 */
        "receiveTime=" + receiveTime +
        /** 核销时间 */
        "verificationTime=" + verificationTime +
        /** 核销人员类型（1-商户、2-渠道） */
        "verificationPersonType=" + verificationPersonType +
        /** 核销人员ID */
        "verificationPersonId=" + verificationPersonId +
        /** 核销人员账号ID */
        "verificationPersonAccountId=" + verificationPersonAccountId +
        /** 租户 */
        "tenantCode=" + tenantCode +
        /** 创建时间 */
        "createdAt=" + createdAt +
        /** 创建人 */
        "createdBy=" + createdBy +
        /** 更新时间 */
        "updatedAt=" + updatedAt +
        /** 更新人 */
        "updatedBy=" + updatedBy +
        /** 版本记录,修改时自增 */
        "version=" + version +
        /** 删除标志 1=已删除, 0=未删除 */
        "dr=" + dr +
        '}';
        }


        public Integer getCount() {
                return count;
        }

        public void setCount(Integer count) {
                this.count = count;
        }

        public Integer getType() {
                return type;
        }

        public void setType(Integer type) {
                this.type = type;
        }

        public String getTypeId() {
                return typeId;
        }

        public void setTypeId(String typeId) {
                this.typeId = typeId;
        }

        public CouponAndPackageDto getCouponAndPackageDto() {
                return couponAndPackageDto;
        }

        public void setCouponAndPackageDto(CouponAndPackageDto couponAndPackageDto) {
                this.couponAndPackageDto = couponAndPackageDto;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }
}


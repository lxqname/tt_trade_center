package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员奖品项关系
 *
 * @author 蝈蝈
 */
@TableName("ac_member_award_item_relation")
public class MemberAwardItemRelation extends SuperEntity implements Serializable {

    /**
     * 会员ID
     */
    private String memberId;

    /**
     * 会员账号
     */
    private String memberAccount;

    /**
     * 会员手机号
     */
    private String memberMobile;

    /**
     * 奖品项ID
     */
    private String awardItemId;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 活动奖品关系ID
     */
    private String activityAwardRelationId;

    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 商品ID
     */
    private String productId;


    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单奖品ID
     */
    private String orderAwardId;

    /**
     * 核销状态（-1-预定、0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期）
     */
    private Integer verificationStatus;

    /**
     * 核销时间
     */
    private Date verificationTime;

    /**
     * 核销人员ID
     */
    private String verificationPersonId;

    /**
     * 核销人员类型（1-商户、2-渠道）
     */
    private Integer verificationPersonType;

    /**
     * 核销人员账号ID
     */
    private String verificationPersonAccountId;

    /**
     * 领取时间
     */
    private Date receiveTime;

    /**
     * 领取方式（0-系统发放、1-线上领取）
     */
    private Integer receiveType;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getAwardItemId() {
        return awardItemId;
    }

    public void setAwardItemId(String awardItemId) {
        this.awardItemId = awardItemId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getActivityAwardRelationId() {
        return activityAwardRelationId;
    }

    public void setActivityAwardRelationId(String activityAwardRelationId) {
        this.activityAwardRelationId = activityAwardRelationId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderAwardId() {
        return orderAwardId;
    }

    public void setOrderAwardId(String orderAwardId) {
        this.orderAwardId = orderAwardId;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public String getVerificationPersonId() {
        return verificationPersonId;
    }

    public void setVerificationPersonId(String verificationPersonId) {
        this.verificationPersonId = verificationPersonId;
    }

    public Integer getVerificationPersonType() {
        return verificationPersonType;
    }

    public void setVerificationPersonType(Integer verificationPersonType) {
        this.verificationPersonType = verificationPersonType;
    }

    public String getVerificationPersonAccountId() {
        return verificationPersonAccountId;
    }

    public void setVerificationPersonAccountId(String verificationPersonAccountId) {
        this.verificationPersonAccountId = verificationPersonAccountId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }
}


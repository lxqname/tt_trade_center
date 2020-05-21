package com.deepexi.trade.service.third.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 优惠券面值/数量/使用条件DTO
 *
 * @author 蝈蝈
 * @since 2019年07月01日 21:17
 */
public class CouponItemDto implements Serializable {

    /**
     * 面值
     */
    private BigDecimal faceValue;

    /**
     * 预计发放数量
     */
    private Integer expectIssueNum;

    /**
     * 实际发放数量（已发放数量）
     */
    private Integer actualIssueNum;

    /**
     * 使用条件（核销条件）-（0-无门槛、1-满额、2-自定义）
     */
    private Integer useLimitFlag;

    /**
     * 自定义核销条件说明
     */
    private String useDivRemark;

    /**
     * 满额金额
     */
    private BigDecimal fullAmount;

    public CouponItemDto() {
    }

    public CouponItemDto(Coupon coupon) {
        this.faceValue = coupon.getFaceValue();
        this.expectIssueNum = coupon.getExpectIssueNum();
        this.actualIssueNum = coupon.getActualIssueNum() == null ? 0 : coupon.getActualIssueNum();
        this.useLimitFlag = coupon.getUseLimitFlag();
        if (Objects.equals(CouponUseFlagEnum.NO_LIMIT.getState(), coupon.getUseLimitFlag())) {
            this.fullAmount = new BigDecimal(0);
        } else if (Objects.equals(CouponUseFlagEnum.FULL_AMOUNT.getState(), coupon.getUseLimitFlag())) {
            this.fullAmount = coupon.getFullAmount();
        } else if (Objects.equals(CouponUseFlagEnum.CUSTOMIZE.getState(), coupon.getUseLimitFlag())) {
            this.useDivRemark = coupon.getUseDivRemark() == null ? "" : coupon.getUseDivRemark();
        }
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public Integer getExpectIssueNum() {
        return expectIssueNum;
    }

    public void setExpectIssueNum(Integer expectIssueNum) {
        this.expectIssueNum = expectIssueNum;
    }

    public Integer getActualIssueNum() {
        return actualIssueNum;
    }

    public void setActualIssueNum(Integer actualIssueNum) {
        this.actualIssueNum = actualIssueNum;
    }

    public Integer getUseLimitFlag() {
        return useLimitFlag;
    }

    public void setUseLimitFlag(Integer useLimitFlag) {
        this.useLimitFlag = useLimitFlag;
    }

    public String getUseDivRemark() {
        return useDivRemark;
    }

    public void setUseDivRemark(String useDivRemark) {
        this.useDivRemark = useDivRemark;
    }

    public BigDecimal getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(BigDecimal fullAmount) {
        this.fullAmount = fullAmount;
    }
}

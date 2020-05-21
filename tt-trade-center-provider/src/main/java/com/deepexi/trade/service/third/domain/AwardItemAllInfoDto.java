package com.deepexi.trade.service.third.domain;


/**
 * 奖品项全部信息DTO
 *
 * @author 蝈蝈
 */
public class AwardItemAllInfoDto extends AwardItem {

    /**
     * 奖品项总数量
     */
    private Integer awardNum;

    /**
     * 奖品项可用数量
     */
    private Integer awardRemainNum;

    /**
     * 奖品项冻结数量
     */
    private Integer awardFrozenNum;

    /**
     * 奖品项作废数量
     */
    private Integer awardObsoleteNum;

    /**
     * 优惠券全部信息DTO
     */
    private CouponAllInfoDto couponAllInfoDto;

    public Integer getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
    }

    public Integer getAwardRemainNum() {
        return awardRemainNum;
    }

    public void setAwardRemainNum(Integer awardRemainNum) {
        this.awardRemainNum = awardRemainNum;
    }

    public Integer getAwardFrozenNum() {
        return awardFrozenNum;
    }

    public void setAwardFrozenNum(Integer awardFrozenNum) {
        this.awardFrozenNum = awardFrozenNum;
    }

    public Integer getAwardObsoleteNum() {
        return awardObsoleteNum;
    }

    public void setAwardObsoleteNum(Integer awardObsoleteNum) {
        this.awardObsoleteNum = awardObsoleteNum;
    }

    public CouponAllInfoDto getCouponAllInfoDto() {
        return couponAllInfoDto;
    }

    public void setCouponAllInfoDto(CouponAllInfoDto couponAllInfoDto) {
        this.couponAllInfoDto = couponAllInfoDto;
    }
}

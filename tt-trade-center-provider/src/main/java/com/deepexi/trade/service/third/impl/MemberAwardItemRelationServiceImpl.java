package com.deepexi.trade.service.third.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.activity.domain.dto.MemberCouponRelationListDto;
import com.deepexi.activity.domain.dto.MemberCouponRelationQueryDto;
import com.deepexi.activity.domain.eo.MemberCouponRelation;
import com.deepexi.activity.service.MemberCouponRelationService;
import com.deepexi.trade.service.third.MemberAwardItemRelationService;
import com.deepexi.trade.service.third.domain.MemberAwardItemRelation;
import com.deepexi.trade.service.third.domain.MemberCouponRelationDto;
import com.deepexi.util.CollectionUtil;
import com.deepexi.util.extension.ApplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MemberAwardItemRelationServiceImpl implements MemberAwardItemRelationService {

    @Reference(version = "${demo.service.version}",check = false /*,url = "dubbo://129.204.78.116:28101"*//*,url = "dubbo://203.195.178.170:28104"*/)
    private MemberCouponRelationService memberCouponRelationService;

    /**
     * 新增-交易使用
     *
     *  memberId           会员ID
     *  type               关联类型（1-优惠券、2-优惠券组合包）
     *  typeId             类型ID
     *  productId          商品ID
     *  orderId            订单ID
     *  orderAwardId       订单奖品ID
     *  verificationStatus 核销状态
     *  receiveType        领取方式
     */
    @Override
    public Boolean create(MemberCouponRelationDto eo) {

        try {
            memberCouponRelationService.createForTrade(
                    eo.getMemberId(),
                    eo.getType(),
                    eo.getTypeId(),
                    eo.getProductId(),
                    eo.getOrderId(),
                    eo.getOrderAwardId(),
                    eo.getVerificationStatus(),
                    eo.getReceiveType());
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
        return true;
    }

    @Override
    public Boolean update(String pk, MemberCouponRelationDto eo) {

        try {
            MemberCouponRelation memberCouponRelation = new MemberCouponRelation();
            memberCouponRelation.setId(eo.getId());
            memberCouponRelation.setVerificationStatus(eo.getVerificationStatus());
            memberCouponRelation.setVerificationTime(eo.getVerificationTime());
            return memberCouponRelationService.updateById(memberCouponRelation);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

    }

    @Override
    public List<MemberCouponRelationDto> findAll(MemberCouponRelationDto eo) {

        List<MemberCouponRelationListDto> allWithOnlyEo = null;
        try {
            MemberCouponRelationQueryDto queryDto = new MemberCouponRelationQueryDto();
            queryDto.setOrderAwardId(eo.getOrderAwardId());
            queryDto.setOrderId(eo.getOrderId());
            queryDto.setVerificationStatus(eo.getVerificationStatus());
            queryDto.setCouponId(eo.getCouponId());
            allWithOnlyEo = memberCouponRelationService.findAllWithOnlyEo(queryDto);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        List<MemberCouponRelationDto> rets = new ArrayList<>(8);
        if (CollectionUtil.isNotEmpty(allWithOnlyEo)){
            for (MemberCouponRelationListDto memberCouponRelationListDto : allWithOnlyEo) {
                MemberCouponRelationDto memberAwardItemRelation = new MemberCouponRelationDto();
                BeanUtils.copyProperties(memberCouponRelationListDto,memberAwardItemRelation);
                rets.add(memberAwardItemRelation);
            }
            return rets;
        }
        return null;
    }

    @Override
    public Boolean create(MemberAwardItemRelation eo) {


        return null;
    }

    @Override
    public Boolean update(String pk, MemberAwardItemRelation eo) {
        return null;
    }

    @Override
    public Boolean delete(String... pk) {
        return null;
    }

    @Override
    public String getVerificationPersonNameByIdAndType(Integer verificationPersonType, String verificationPersonId) {
        return null;
    }

    @Override
    public List<MemberAwardItemRelation> findAll(MemberAwardItemRelation eo) {
        return null;
    }

    @Override
    public Long countBoostActivityAward(String memberId, Integer verificationStatus) {
        return null;
    }

    @Override
    public List<String> findIdsByActivityIdAndAwardId(String activityId, String awardId) {
        return null;
    }

    @Override
    public MemberAwardItemRelation detail(String memberAwardItemId) {
        return null;
    }

    @Override
    public Boolean receive(String memberAwardItemId) {
        return null;
    }

    @Override
    public List<String> receiveByActivityIdAndAwardId(String activityId, String awardId) {
        return null;
    }

    @Override
    public void updateVerificationStatus(String activityId, String memberId, Date operateTime) {

    }

    @Override
    public Boolean use(String memberAwardItemId, Integer personType) {
        return null;
    }

    @Override
    public Boolean checkCouponMerchantWithLoginMerchant(String memberAwardItemId) {
        return null;
    }

    @Override
    public Integer expireMemberCoupon() {
        return null;
    }

    @Override
    public Long countByMemberIdAndStatus(String memberId, Integer status) {
        return null;
    }

    @Override
    public Long countBoostAwardByMemberIdAndCouponStatusAndCommodity(String memberId, Integer couponStatus, Integer commodityStatus) {
        return null;
    }

    @Override
    public Integer couponExpiredRemind() {
        return null;
    }
}

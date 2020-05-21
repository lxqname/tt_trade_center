package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;

import java.util.Date;
import java.util.List;

/**
 * 会员奖品项关系服务
 *
 * @author 蝈蝈
 */
public interface MemberAwardItemRelationService {

    /**
     * 新增
     *
     * @param eo 数据
     * @return Boolean
     */
    Boolean create(MemberCouponRelationDto eo);

    /**
     * 编辑
     *
     * @param pk 主键ID
     * @param eo 数据
     * @return Boolean
     */
    Boolean update(String pk, MemberCouponRelationDto eo);

    /**
     * 删除
     *
     * @param pk 主键ID列表
     * @return Boolean
     */
//    Boolean delete(String... pk);

    /**
     * 查询列表
     *
     * @param eo 查询条件（会根据token查询会员ID）
     * @return List
     */
    List<MemberCouponRelationDto> findAll(MemberCouponRelationDto eo);


    /**
     * 查询详情
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @return MemberAwardItemRelation
     */
//    MemberAwardItemRelation detail(String memberAwardItemId);

    /**
     * 新增
     *
     * @param eo 数据
     * @return Boolean
     */
    Boolean create(MemberAwardItemRelation eo);

    /**
     * 编辑
     *
     * @param pk 主键ID
     * @param eo 数据
     * @return Boolean
     */
    Boolean update(String pk, MemberAwardItemRelation eo);

    /**
     * 删除
     *
     * @param pk 主键ID列表
     * @return Boolean
     */
    Boolean delete(String... pk);

    /**
     * 列表-分页
     *
     * @param query 查询条件
     * @param page  页码
     * @param size  页大小
     * @return PageBean
     */
//    PageBean<MemberAwardItemRelation> findPage(MemberAwardItemRelation query, Integer page, Integer size);

    /**
     * 查询列表-活动详情页内使用
     *
     * @param queryDto 查询DTO
     * @param page     页码
     * @param size     页大小
     * @return PageBean
     */
//    PageBean<MemberAwardItemRelationResDto> findPageByCount(MemberAwardItemRelationQueryDto queryDto, Integer page, Integer size);

    /**
     * 查询列表-活动详情页内使用
     *
     * @param queryDto 查询DTO
     * @return List
     */
//    List<MemberAwardItemRelationResDto> findAllByCount(MemberAwardItemRelationQueryDto queryDto);

    /**
     * 根据核销人员类型及ID查询名称
     *
     * @param verificationPersonType 核销人员类型
     * @param verificationPersonId   核销人员ID
     * @return String
     */
    String getVerificationPersonNameByIdAndType(Integer verificationPersonType, String verificationPersonId);

    /**
     * 根据DTO分页查询列表
     *
     * @param queryDto 查询DTO
     * @param page     页码
     * @param size     页大小
     * @return PageBean
     */
//    PageBean<MemberAwardItemRelation> findPageByCondition(MemberAwardItemRelationQueryDto queryDto, Integer page, Integer size);

    /**
     * 查询列表
     *
     * @param eo 查询条件（会根据token查询会员ID）
     * @return List
     */
    List<MemberAwardItemRelation> findAll(MemberAwardItemRelation eo);


    /**
     * 查询列表
     *
     * @param eo 查询条件（会根据token查询会员ID）
     * @return List
     */
//    List<MemberAwardItemRelationForDataVO> findListForData(MemberAwardItemRelation eo, Date startDate, Date endDate);

    /**
     * 统计
     *
     * @param query 查询条件
     * @return int
     */
//    int countByCondition(MemberAwardItemRelationQueryDto query);

    /**
     * 统计会员数量
     *
     * @param query 查询条件
     * @return int
     */
//    int countMemberIdByCondition(MemberAwardItemRelationQueryDto query);

    /**
     * 根据活动ID查询当前会员的奖品信息
     *
     * @param activityId 活动ID
     * @return List
     */
//    List<MemberAwardItemRelationResDto> findByActivityId(String activityId);

    /**
     * 根据活动ID查询当前会员的礼品信息
     *
     * @param activityId 活动ID
     * @return List
     */
//    List<BoostActivityAwardDto> findBoostActivityAwardList(String activityId);

    /**
     * 查询助力活动的礼品列表
     *
     * @param page               页码
     * @param size               页大小
     * @param verificationStatus 核销状态（0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期）
     * @return List
     */
//    PageBean<BoostActivityAwardDto> findBoostActivityAwardList(Integer page, Integer size, Integer verificationStatus);

    /**
     * 查询助力活动的礼品列表
     *
     * @param memberId           会员ID
     * @param verificationStatus 核销状态（0-待领取、1-未使用/未核销、2-使用中、3-已使用/已核销、4-已过期）
     * @return Long
     */
    Long countBoostActivityAward(String memberId, Integer verificationStatus);

    /**
     * 查询助力活动的礼品列表
     *
     * @param couponStatusList    优惠券核销状态
     * @param commodityStatusList 实物核销状态
     * @param page                页码
     * @param size                页大小
     * @return PageBean
     */
//    PageBean<AwardViewDto> findBoostAwardList(List<Integer> couponStatusList, List<Integer> commodityStatusList, Integer page, Integer size);

    /**
     * 根据活动ID及奖品ID查询主键ID列表
     *
     * @param activityId 活动ID
     * @param awardId    奖品ID
     * @return List
     */
    List<String> findIdsByActivityIdAndAwardId(String activityId, String awardId);

    /**
     * 查询详情
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @return MemberAwardItemRelation
     */
    MemberAwardItemRelation detail(String memberAwardItemId);

    /**
     * 查询奖品详情
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @param personType        人员类型（1-商户、2-渠道、3-会员）
     * @return AwardViewDto
     */
//    AwardViewDto detail(String memberAwardItemId, Integer personType);

    /**
     * 领取奖品项
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @return Boolean
     */
    Boolean receive(String memberAwardItemId);

    /**
     * 领取奖品
     *
     * @param activityId 活动ID
     * @param awardId    奖品ID
     * @return List 会员奖品项关系ID列表
     */
    List<String> receiveByActivityIdAndAwardId(String activityId, String awardId);

    /**
     * 更新用户预定的奖品核销状态
     *
     * @param activityId  活动ID
     * @param memberId    会员ID，为null则更新全部会员的
     * @param operateTime 操作时间
     */
    void updateVerificationStatus(String activityId, String memberId, Date operateTime);

    /**
     * 核销/使用奖品项
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @param personType        人员类型（1-商户、2-渠道）
     * @return Boolean
     */
    Boolean use(String memberAwardItemId, Integer personType);

    /**
     * 校验优惠券关联权益商户与当前登录商户是否一致
     *
     * @param memberAwardItemId 会员奖品项关系ID
     * @return Boolean true相同，false不相同
     */
    Boolean checkCouponMerchantWithLoginMerchant(String memberAwardItemId);

    /**
     * 渠道端核销礼品记录
     *
     * @param page 页码
     * @param size 页大小
     * @return List
     */
//    PageBean<AwardViewDto> channelRecord(Integer page, Integer size);

    /**
     * 商户端核销优惠券记录
     *
     * @param startTime 核销开始时间
     * @param endTime   核销结束时间
     * @param page      页码
     * @param size      页大小
     * @return List
     */
//    PageBean<AwardViewDto> merchantRecord(Date startTime, Date endTime, Integer page, Integer size);

    /**
     * 会员优惠券过期处理
     *
     * @return Integer 影响行数
     */
    Integer expireMemberCoupon();

    /**
     *  根据活动id分页查询用户核销记录
     *
     * @param page
     * @param size
     * @param memberMobile
     * @param activityId
     * @return
     */
//    PageBean<MemberCouponUsedListDto> getVerificationListByPage(Integer page, Integer size, String memberMobile, String activityId);

    /**
     * 统计优惠卷数字
     * @param memberId
     * @param status
     * @return
     */
    Long countByMemberIdAndStatus(String memberId, Integer status);

    /**
     * 统计
     * @param memberId
     * @param couponStatus
     * @param commodityStatus
     * @return
     */
    Long countBoostAwardByMemberIdAndCouponStatusAndCommodity(String memberId, Integer couponStatus, Integer commodityStatus);

    /**
     * 获取订单券信息列表
     *
     * @param orderId 订单ID
     * @return List
     */
//    List<OrderAwardDto> findAwardItemInfoByOrderId(String orderId);

    /**
     * 优惠券过期提醒
     *
     * @return Integer 提醒行数
     */
    Integer couponExpiredRemind();

    /**
     * 获得购卷记录列表
     * @param queryDTO
     * @param page
     * @param size
     * @return
     */
//    PageBean<ProductVerificationRecordVO> findProductBuyRecordList(ProductVerificationRecordQueryDTO queryDTO, Integer page, Integer size);

    /**
     * 购卷记录与核销明细统计
     * @param productId 商品ID
     * @return
     */
//    ProductRecordCountVO productRecordCount(String productId);


    /**
     * 获得领卷活动数据统计 会员领取列表数据
     * @param queryDto
     * @param page
     * @param size
     * @return
     */
//    PageBean<CouponVerificationRecordVO> findPageByCouponData(MemberAwardItemRelationQueryDto queryDto, Integer page, Integer size);

    /**
     * 领卷活动-优惠卷信息统计
     * @param activityId
     * @return
     */
//    CouponUseDataVO couponUseData(String activityId);


    /**
     * 权益领卷活动数据统计
     * @param couponId 优惠卷ID
     * @param activityId 活动ID
     * @return
     */
//    CouponUseDataVO couponUseDataByCouponIdAndActivityId(String couponId, String activityId);
    /**
     * 权益领卷商品数据统计
     * @param couponId 优惠卷ID
     * @param productId 商品ID
     * @return
     */
//    CouponUseDataVO couponUseDataByCouponIdAndProductId(String couponId, String productId);

    /**
     * 获得领卷活动数据统计 会员领取列表数据-通过活动优惠卷查询
     * @param queryDto
     * @param couponId 优惠卷ID
     * @param page
     * @param size
     * @return
     */
//    PageBean<CouponVerificationRecordVO> findPageByCouponDataAndCouponId(MemberAwardItemRelationQueryDto queryDto, String couponId, Integer page, Integer size);

    /**
     * 根据商户ID和时间范围获取，优惠券 领取人数，核销人数，核销金额
     *
     * @param dto 条件
     * @return BoostCouponStat
     */
//    BoostCouponStat merchantCouponStat(MerchantCouponStatDTO dto);

    /**
     * 根据状态统计数量-按会员分组
     *
     * @param activityId   活动ID
     * @param memberMobile 会员手机号
     * @param page         页码
     * @param size         页大小
     * @return PageBean
     */
//    PageBean<MemberAwardItemStatusCountDto> countStatusGroupByMemberId(String activityId, String memberMobile, Integer page, Integer size);
}
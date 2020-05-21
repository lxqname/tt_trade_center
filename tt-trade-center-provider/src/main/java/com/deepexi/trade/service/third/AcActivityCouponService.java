package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;

import java.util.List;

/**
 * 领券活动服务
 *
 * @author 梁家铭
 */
public interface AcActivityCouponService {

    /**
     * 新增
     *
     * @param dto 领券活动新增DTO
     * @return Boolean
     */
//    Boolean create(CouponActivityCreateDto dto);

    /**
     * 编辑
     *
     * @param pk  主键ID
     * @param dto 数据
     * @return Boolean
     */
//    Boolean update(String pk, CouponActivityCreateDto dto);

    /**
     * 删除
     *
     * @param pks 主键ID
     * @return Boolean
     */
    Boolean delete(String... pks);

    /**
     * 列表-分页
     *
     * @param queryDto  查询条件
     * @param page 页码
     * @param size 页大小
     * @return PageBean
     */
//    PageBean<CouponActivityListDto> findPage(ActivityQueryDto queryDto, Integer page, Integer size);

    /**
     * 列表
     *
     * @param dto 查询条件
     * @return List
     */
//    List<CouponActivityListDto> findAll(AcActivityCouponQueryDto dto);

    /**
     * 详情
     *
     * @param pk 主键ID
     * @return CouponActivityDetailDto
     */
//    CouponActivityDetailDto detail(String pk);

    /**
     * 详情-移动端
     *
     * @param pk         主键ID
     * @param personType 人员类型（1-商户、2-渠道、3-会员）
     * @return CouponActivityDetailDto
     */
//    CouponActivityDetailDto detailForFront(String pk, Integer personType);

    /**
     * 根据活动EO 组装 CouponActivityDetailDto
     *
     * @param activity EO数据
     * @return CouponActivityDetailDto
     */
//    CouponActivityDetailDto getCouponActivityDetailDtoFromEo(Activity activity);

    /**
     * 审核
     *
     * @param activityId 活动ID
     * @param auditDto   审核DTO
     * @return Boolean
     */
//    Boolean audit(String activityId, AuditDto auditDto);

    /**
     * 已弃用，下一版本删除 2019/7/18
     *
     * @param activityId 活动ID
     * @return Boolean
     */
    Boolean stop(String activityId);

    /**
     * 领券活动-列表-移动端(进行中活动及达到预告时间未开始活动)
     *
     * @param frontCategoryId 前端类目ID
     * @param page            页码
     * @param size            页大小
     * @return PageBean
     */
//    PageBean<CouponActivityDetailDto> findListByStartedAndNotStart(String frontCategoryId, Integer page, Integer size);

    /**
     * 领券活动列表查询
     * -特定条件（进行中活动及达到预告时间未开始活动）
     * -特定排序（进行中（距结束时间升序）>未开始（距开始时间升序）>已抢光（随机））
     *
     * @param queryDto 查询DTO
     * @param page     页码
     * @param size     页大小
     * @return PageBean
     */
//    PageBean<Activity> findListBySpecialCondition(ActivityQueryDto queryDto, Integer page, Integer size);

    /**
     * 获取详情
     *
     * @param activityId 活动ID
     * @return AcActivityCouponDetailForFrontDto
     */
//    AcActivityCouponDetailForFrontDto getCouponDetailForFront(String activityId);

    /**
     * 领券活动-领取操作
     *
     * @param activityId 活动ID
     * @return List 会员奖品项关系ID列表
     */
    List<String> receiveFromFront(String activityId);

    /**
     * 会员端-我的优惠券列表
     *
     * @param page       页码
     * @param size       页大小
     * @param statusList 状态
     * @return PageBean
     */
//    PageBean<AcActivityCouponDetailForFrontDto> getMyCouponListForFront(Integer page, Integer size, List<Integer> statusList);

    /**
     * 会员端-我的优惠券详情
     *
     * @param relationId 会员奖品项关系ID
     * @param couponId   优惠券ID
     * @return AcActivityCouponDetailForFrontDto
     */
//    AcActivityCouponDetailForFrontDto getMyCouponDetail(String relationId, String couponId);

    /**
     * 校验活动有效性（有效则返回活动信息）
     *
     * @param activityId 活动ID
     * @return Activity 活动信息
     */
    Activity checkActivityEffectiveness(String activityId);

    /**
     * 根据领券活动id查询活动所关联优惠券的信息统计数据
     *
     * @param activityId 活动ID
     * @return CouponStatisticsByActivityIdDto
     */
//    CouponStatisticsByActivityIdDto getCouponDataStatisticsByActivityId(String activityId);

    /**
     * 根据活动id分页查询用户核销记录
     *
     * @param page       页码
     * @param size       页大小
     * @param memberId   会员ID
     * @param activityId 活动ID
     * @return PageBean
     */
//    PageBean<MemberCouponUsedListDto> getVerificationListByPage(Integer page, Integer size, String memberId, String activityId);

    /**
     * 根据活动id查询领取活动对应优惠券相关数据
     *
     * @param activityId 活动ID
     * @return ActivityCouponStatisticDto
     */
//    ActivityCouponStatisticDto findActivityCouponDataByActivityId(String activityId);

    /**
     * 根据权益id查询权益关联活动的相关数据统计
     *
     * @param equityId 权益ID
     * @return ActivityEquityStatisticsDataDto
     */
//    ActivityEquityStatisticsDataDto getActivityEquityStatisticDataByEquityId(String equityId);

    /**
     * 优惠卷统计数量
     *
     * @param status 状态
     * @return Long
     */
    Long myCouponCount(Integer status);

    /**
     * 获得会员奖品详情
     *
     * @param id 会员奖品项关系ID
     * @return MemberAwardDetailVO
     */
//    MemberAwardDetailVO memberAwardRelationDetail(String id);
}
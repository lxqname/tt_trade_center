package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;

import java.util.Date;
import java.util.List;

public interface AcCouponService {

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @param page  页码
     * @param size  页大小
     * @return PageBean
     */
//    PageBean<AcCouponDetailDto> findPage(CouponQueryDto query, Integer page, Integer size);

//    List<AcCouponDetailDto> findAll(AcCouponListPageDto dto);

    /**
     * 根据权益ID查询优惠券列表
     *
     * @param equityId 权益ID
     * @return List
     */
    List<Coupon> findByEquityId(String equityId);

    /**
     * 详情
     *
     * @param pk 主键ID
     * @return CouponDetailDto
     */
//    CouponDetailDto detail(String pk);

    /**
     * 新增（优惠券）
     *
     * @param couponCreateDto 数据
     * @return Boolean
     */
//    Boolean create(CouponCreateDto couponCreateDto);

    /**
     * 新增（优惠券-奖品项-奖品）
     *
     * @param couponCreateDto 数据
     * @return Boolean
     */
//    Boolean createToAward(CouponCreateDto couponCreateDto);

    /**
     * 更新
     *
     * @param pk              主键ID
     * @param couponCreateDto 数据
     * @return Boolean
     */
//    Boolean update(String pk, CouponCreateDto couponCreateDto);

    /**
     * 删除（优惠券-奖品项-奖品）
     *
     * @param pkList 主键ID列表
     * @return Boolean
     */
    Boolean deleteToAward(String... pkList);

    /**
     * 根据权益ID删除（优惠券）
     *
     * @param equityId 权益ID
     * @return Boolean
     */
    Boolean deleteByEquityId(String equityId);

    /**
     * 过期操作
     *
     * @return Integer 影响数
     */
    Integer expire();

    /**
     * 过期操作
     *
     * @param expiredCoupon 过期优惠券信息
     * @return Boolean
     */
    Boolean expire(Coupon expiredCoupon);

    /**
     * 根据权益id查询的数据统计
     * @param page
     * @param size
     * @param equityId
     * @return
     */
//    PageBean<AcCouponStatisticsDto> findStatisticsByEquityId(Integer page, Integer size, String equityId);

    /**
     * 优惠券有效期验证
     * @param couponId 优惠券id
     * @param receiveTime 领取时间
     * @return
     */
    Boolean checkCouponValid(String couponId, Date receiveTime);

    /**
     * 活动结束返还优惠券
     * @param couponId 优惠券id
     * @param awardItemRelationId 奖品项关系id
     * @return
     */
    Boolean couponReturnFromActivityEnd(String awardItemRelationId, String couponId);

    /**
     * 占用优惠券数量
     *
     * @param couponId 优惠券ID
     * @param num      优惠券数量
     * @return Boolean
     */
    Boolean occupyNum(String couponId, Integer num);

    /**
     * 返还优惠券数量
     *
     * @param couponId 优惠券ID
     * @param num      优惠券数量
     * @return Boolean
     */
    Boolean releaseNum(String couponId, Integer num);

    /**
     * 获取优惠券剩余数量
     *
     * @param couponId 优惠券ID
     * @return Integer
     */
    Integer getRemainNum(String couponId);

    /**
     * 创建活动占用优惠券数量
     * @param couponId 优惠券id
     * @param num 优惠券占用数量
     * @return
     */
    Boolean couponOccupyFromActivityCreate(String couponId, Integer num);

    /**
     * 核销优惠券(优惠券使用数量 + 1)
     * @param couponId 优惠券id
     * @return
     */
    Boolean verificationCoupon(String couponId);

    /**
     * 创建优惠券与活动关联
     *
     * @param couponId 优惠券id
     * @return Boolean
     */
    Boolean connectActivityRelationStatus(String couponId);

    /**
     * 创建优惠券与活动关联
     * @param couponId 优惠券id
     * @return
     */
    Boolean createActivityRelationStatus(String couponId);

    /**
     * 移除优惠券与活动关联
     *
     * @param couponId 优惠券id
     * @return Boolean
     */
    Boolean removeActivityRelationStatus(String couponId);

    /**
     * 根据权益ID更新优惠券审核状态
     *
     * @param equityId    权益ID
     * @param auditStatus 审核状态
     */
    void updateAuditStatusByEquityId(String equityId, Integer auditStatus);

    /**
     * 检查是否关联活动或商品
     *
     * @param id 优惠券ID
     * @return Boolean true 已关联，false 未关联
     */
    Boolean checkConnectActivityOrProduct(String id);
}
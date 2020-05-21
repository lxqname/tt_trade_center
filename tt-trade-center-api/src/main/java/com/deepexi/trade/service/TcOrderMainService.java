package com.deepexi.trade.service;

import com.deepexi.trade.domain.dto.*;
import com.deepexi.trade.domain.eo.OrderSkuWriteoff;
import com.deepexi.trade.domain.eo.TcOrderPay;
import com.deepexi.trade.domain.vo.OrderCouponVO;
import com.deepexi.trade.domain.vo.TcOrderMainVO;
import com.deepexi.trade.domain.vo.TcOrderPayVO;
import com.deepexi.trade.domain.vo.orderdetail.TcOrderMainDetailVO;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.TcOrderMain;

import java.util.*;

public interface TcOrderMainService {

    PageBean<TcOrderMainVO> findPage(TcOrderMainDto eo, Integer page, Integer size);

    List<TcOrderMainVO> findAll(TcOrderMainDto eo);

    TcOrderMainDetailVO detail(String pk);

    Boolean update(String pk, TcOrderMainDto eo);

    Boolean create(TcOrderMainDto eo);

    TcOrderMainVO orderPlace(TcOrderPlaceRequestDto dto);

    TcOrderPayVO orderPay(TcOrderPayDto dto);

    Boolean delete(String... pk);

    /**
     * 定时器调用取消(关闭)订单
     */
    void closeOrder();

    /**
     * 根据订单信息取消(关闭)订单
     * @param tcOrderMain
     * @return
     */
    Boolean closeOrderOperation(TcOrderMainVO tcOrderMain);


    /**
     * 更新我的奖品
     * @param oId
     * @param state
     */
     void updateMemberAwardItemRelation(TcOrderMainVO tcOrderMain,String oId, String orderAwardId,   Integer state);

     boolean expireAwardItem(List<String> itemIds);

     boolean orderSkuWriteoffUpdate(List<OrderSkuWriteoffDto> orderSkuWriteoffDtoss);

    Integer getOrderCount(TcOrderMainDto eo);

     TcOrderRefundDto getCanRefund(String oid);


    OrderCouponVO getOrderCoupon(com.deepexi.trade.service.third.domain.MemberCouponRelationDto eo);
}
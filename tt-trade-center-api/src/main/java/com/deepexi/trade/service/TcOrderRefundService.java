package com.deepexi.trade.service;

import com.deepexi.trade.domain.dto.TcCallBackDto;
import com.deepexi.trade.domain.dto.TcOrderRefundDto;
import com.deepexi.trade.domain.eo.TcOrderRefund;
import com.deepexi.trade.domain.vo.pay.TcCallBackResponse;
import com.deepexi.util.config.Payload;
import com.deepexi.util.pageHelper.PageBean;

import java.util.List;

public interface TcOrderRefundService {

    PageBean<TcOrderRefund> findPage(TcOrderRefundDto eo, Integer page, Integer size);

    List<TcOrderRefund> findAll(TcOrderRefundDto eo);

    TcOrderRefund detail(String pk);

    Boolean update(String pk, TcOrderRefundDto eo);

    Boolean create(TcOrderRefundDto eo);

    Boolean delete(String... pk);

    /**
     * 商品退款
     * @param dto 退款请求实体
     * @return
     */
    Boolean orderRefund(TcOrderRefundDto dto);

    /**
     * 退款回调
     * @param dto
     * @return
     */
    TcCallBackResponse refundCallBack(TcCallBackDto dto);

    /**
     * 获取退款信息
     * @param orderId
     * @return
     */
    Payload getRefundInfo(String orderId);
}
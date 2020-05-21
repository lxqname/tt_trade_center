package com.deepexi.trade.service;

import com.deepexi.trade.domain.dto.MakeSignDto;
import com.deepexi.trade.domain.dto.TcCallBackDto;
import com.deepexi.trade.domain.dto.TcOrderPayDto;
import com.deepexi.trade.domain.eo.TcOrderPay;
import com.deepexi.trade.domain.vo.SignVO;
import com.deepexi.trade.domain.vo.pay.TcCallBackResponse;
import com.deepexi.util.pageHelper.PageBean;

import java.util.Date;
import java.util.List;

public interface TcOrderPayService {

    PageBean<TcOrderPay> findPage(TcOrderPayDto eo, Integer page, Integer size);

    List<TcOrderPay> findAll(TcOrderPayDto eo);

    TcOrderPay detail(String pk);

    Boolean update(String pk, TcOrderPayDto eo);

    Boolean create(TcOrderPayDto eo);

    Boolean delete(String... pk);

    /**
     * 支付回调
     * @param dto
     * @return
     */
    TcCallBackResponse payCallback(TcCallBackDto dto);

    /**
     * 支付后的操作
     * @param transNo 支付订单号
     * @param payTime 支付时间
     * @param status  状态
     * @param tcOrderPay 支付订单表的信息(可以不传，不传的话，就用支付订单号进行查询)
     * @return
     */
    int orderPayOperation(String transNo, Date payTime, Integer status,TcOrderPay tcOrderPay);

    /**
     * 获取加签签名信息
     * @param makeSignDto
     * @return
     */
    SignVO makeSign(MakeSignDto makeSignDto);
}
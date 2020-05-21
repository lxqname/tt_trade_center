package com.deepexi.trade.domain.vo.orderdetail;

import com.deepexi.trade.domain.vo.TcOrderChildVO;
import com.deepexi.trade.domain.vo.TcOrderMainVO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/23 14:31
 */
public class TcOrderMainDetailVO implements Serializable {


    private Integer refundCount = 0;
    /**
     * 总订单的信息
     */
    private TcOrderMainVO tcOrderMainVO;

    /**
     * 会员相关的信息
     */
    private MemberInfo memberInfo;

    /**
     * 商户信息
     */
    private MerchantDetailInfo merchantDetailInfo;

    /**
     * 支付信息
     */
    private OrderPayInfo orderPayInfo;

    /**
     * 订单详情
     */
    private List<TcOrderChildVO> tcOrderSku;

    /**
     * 退款的详情
     */
    private OrderRefundInfo orderRefundInfo;

    public TcOrderMainVO getTcOrderMainVO() {
        return tcOrderMainVO;
    }

    public void setTcOrderMainVO(TcOrderMainVO tcOrderMainVO) {
        this.tcOrderMainVO = tcOrderMainVO;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public MerchantDetailInfo getMerchantDetailInfo() {
        return merchantDetailInfo;
    }

    public void setMerchantDetailInfo(MerchantDetailInfo merchantDetailInfo) {
        this.merchantDetailInfo = merchantDetailInfo;
    }

    public OrderPayInfo getOrderPayInfo() {
        return orderPayInfo;
    }

    public void setOrderPayInfo(OrderPayInfo orderPayInfo) {
        this.orderPayInfo = orderPayInfo;
    }

    public List<TcOrderChildVO> getTcOrderSku() {
        return tcOrderSku;
    }

    public void setTcOrderSku(List<TcOrderChildVO> tcOrderSku) {
        this.tcOrderSku = tcOrderSku;
    }

    public OrderRefundInfo getOrderRefundInfo() {
        return orderRefundInfo;
    }

    public void setOrderRefundInfo(OrderRefundInfo orderRefundInfo) {
        this.orderRefundInfo = orderRefundInfo;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        if (null != refundCount){
            this.refundCount = refundCount;
        }

    }
}

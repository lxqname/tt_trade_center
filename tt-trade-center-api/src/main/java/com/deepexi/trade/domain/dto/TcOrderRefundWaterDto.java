package com.deepexi.trade.domain.dto;

import java.io.Serializable;

/**
 * @desc tc_order_refund_water
 * @author admin
 */
public class TcOrderRefundWaterDto implements Serializable {

    private String id;

    /**
     * 退款表关联的id
     */
    private String refundOrderId;

    /**
     * 订单流水状态: 1、发起时间 2、平台审核时间 3、渠道受理时间 4、到账时间
     */
    private Integer processType;

    /**
     * 操作类型 1、create 2、delete
     */
    private String optType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRefundOrderId(String refundOrderId){
        this.refundOrderId = refundOrderId;
    }

    public String getRefundOrderId(){
        return this.refundOrderId;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }
}


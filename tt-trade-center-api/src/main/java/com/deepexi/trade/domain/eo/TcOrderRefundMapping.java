package com.deepexi.trade.domain.eo;


import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_refund_mapping
 * @author admin
 */
//@ApiModel(description = "退款映射表")
public class TcOrderRefundMapping extends SuperEntity implements Serializable{

    //@ApiModelProperty(value = "退款表关联的id")
    private String refundOrderId;
    //@ApiModelProperty(value = "订单状态: 1、待退款 4、退款成功 6、退款中")
    private Integer refundStatus;
    //@ApiModelProperty(value = "退款订单号")
    private String refundTransNo;

    public void setRefundOrderId(String refundOrderId){
        this.refundOrderId = refundOrderId;
    }

    public String getRefundOrderId(){
        return this.refundOrderId;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public void setRefundTransNo(String refundTransNo){
        this.refundTransNo = refundTransNo;
    }

    public String getRefundTransNo(){
        return this.refundTransNo;
    }

}


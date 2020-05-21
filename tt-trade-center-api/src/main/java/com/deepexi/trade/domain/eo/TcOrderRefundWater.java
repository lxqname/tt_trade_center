package com.deepexi.trade.domain.eo;


import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_refund_water
 * @author admin
 */
//@ApiModel(description = "退款进度流水表")
public class TcOrderRefundWater extends SuperEntity implements Serializable{

    //@ApiModelProperty(value = "退款表关联的id")
    private String refundOrderId;
    //@ApiModelProperty(value = "记录类型: 1、发起时间 2、平台审核时间 3、渠道受理时间 4、到账时间")
    private Integer processType;

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }
}


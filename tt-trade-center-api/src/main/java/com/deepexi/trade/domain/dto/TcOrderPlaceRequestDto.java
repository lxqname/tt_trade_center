package com.deepexi.trade.domain.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/24 16:32
 */
public class TcOrderPlaceRequestDto implements Serializable {

    @NotNull(message = "商品数据不能为空")
    private List<SkuInfo> skuInfos;

    //积分
    private Integer integral;

    //优惠券
    private String couponId;

    public List<SkuInfo> getSkuInfos() {
        return skuInfos;
    }

    public void setSkuInfos(List<SkuInfo> skuInfos) {
        this.skuInfos = skuInfos;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}


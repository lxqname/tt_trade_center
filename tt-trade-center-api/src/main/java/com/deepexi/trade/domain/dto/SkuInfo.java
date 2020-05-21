package com.deepexi.trade.domain.dto;

import java.io.Serializable;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/24 16:33
 */
public class SkuInfo implements Serializable {

    //活动ID
    private String activityId;

    //商品ID
    private String skuId;

    //商品件数
    private Integer skuCount;

    //商品类型 1：单商品、2：组合商品
    private Integer skuType;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    public Integer getSkuType() {
        return skuType;
    }

    public void setSkuType(Integer skuType) {
        this.skuType = skuType;
    }
}

package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;

/**
 * 奖品
 *
 * @author 蝈蝈
 */
@TableName("ac_award")
public class Award extends SuperEntity implements Serializable {

    /**
     * 奖品名称
     */
    private String name;
    /**
     * 奖品编码
     */
    private String code;
    /**
     * 奖品类型 1-优惠券 2-组合商品 3-实物 4-虚拟商品
     */
    private Integer type;
    /**
     * 商品类型 0-电子卡券
     */
    private Integer productType;
    /**
     * 优惠券主图图片url
     */
    private String imageUrl;
    /**
     * 优惠券副图图片url（逗号分隔）
     */
    private String subImageUrls;
    /**
     * 后端类目id
     */
    private String categoryId;
    /**
     * 奖品状态 0-过期 1-可用
     */
    private Integer status;

    /**
     * 使用说明
     */
    private String useDescription;
    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSubImageUrls() {
        return subImageUrls;
    }

    public void setSubImageUrls(String subImageUrls) {
        this.subImageUrls = subImageUrls;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


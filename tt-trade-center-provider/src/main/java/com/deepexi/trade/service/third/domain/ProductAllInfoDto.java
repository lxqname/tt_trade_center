package com.deepexi.trade.service.third.domain;


import java.util.List;

/**
 * 商品全部信息DTO
 *
 * @author 蝈蝈
 */
public class ProductAllInfoDto extends ProductSku {

    /**
     * 奖品信息
     */
    private AwardAllInfoDto awardAllInfoDto;

    /**
     * 后端类目列表
     */
    private List<Category> categoryList;

    public AwardAllInfoDto getAwardAllInfoDto() {
        return awardAllInfoDto;
    }

    public void setAwardAllInfoDto(AwardAllInfoDto awardAllInfoDto) {
        this.awardAllInfoDto = awardAllInfoDto;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}

package com.deepexi.trade.service.third.domain;


import java.util.List;

/**
 * 奖品全部信息DTO
 *
 * @author 蝈蝈
 */
public class AwardAllInfoDto extends Award {

    /**
     * 标签列表
     */
    private List<ItemTag> itemTagList;

    /**
     * 奖品项全部信息列表
     */
    private List<AwardItemAllInfoDto> awardItemAllInfoDtoList;

    public List<ItemTag> getItemTagList() {
        return itemTagList;
    }

    public void setItemTagList(List<ItemTag> itemTagList) {
        this.itemTagList = itemTagList;
    }

    public List<AwardItemAllInfoDto> getAwardItemAllInfoDtoList() {
        return awardItemAllInfoDtoList;
    }

    public void setAwardItemAllInfoDtoList(List<AwardItemAllInfoDto> awardItemAllInfoDtoList) {
        this.awardItemAllInfoDtoList = awardItemAllInfoDtoList;
    }
}

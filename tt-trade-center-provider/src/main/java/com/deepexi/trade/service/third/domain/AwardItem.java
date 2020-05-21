package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;

/**
 * 奖品项
 *
 * @author 蝈蝈
 */
@TableName("ac_award_item")
public class AwardItem extends SuperEntity implements Serializable {

    /**
     * 奖品类型（1-优惠券、2-实物）
     */
    private Integer type;

    /**
     * 奖品类型ID
     */
    private String typeId;

    /**
     * 奖品类型名称
     */
    private String typeName;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}


package com.deepexi.trade.domain.vo;

import com.deepexi.product.domain.eo.Product;
import com.deepexi.trade.service.third.domain.MemberCouponRelationDto;

import java.io.Serializable;
import java.util.List;

public class OrderCouponVO implements Serializable {
    private List<List<MemberCouponRelationDto>> memberCouponRelationDtos;

    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<List<MemberCouponRelationDto>> getMemberCouponRelationDtos() {
        return memberCouponRelationDtos;
    }

    public void setMemberCouponRelationDtos(List<List<MemberCouponRelationDto>> memberCouponRelationDtos) {
        this.memberCouponRelationDtos = memberCouponRelationDtos;
    }
}

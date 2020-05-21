package com.deepexi.trade.service.third.impl;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.equity.service.CouponPackageService;
import com.deepexi.product.domain.dto.CouponAndPackageDto;
import com.deepexi.product.domain.dto.CouponEquityEnterpriseDto;
import com.deepexi.product.domain.dto.ProductCouponDto;
import com.deepexi.product.domain.dto.ProductDto;
import com.deepexi.product.domain.eo.Product;
import com.deepexi.trade.adapter.Sku;
import com.deepexi.trade.domain.dto.SkuInfo;
import com.deepexi.trade.enums.ResultEnum;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.service.third.GenerateIdService;
import com.deepexi.trade.service.third.ProductService;
import com.deepexi.trade.service.third.domain.*;
import com.deepexi.util.IdGenerator;
import com.deepexi.util.extension.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author yunzi7758
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private GenerateIdService generateIdService;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Reference(version = "${demo.service.version}",check = false /*,url = "dubbo://129.204.78.116:28101"*//*,url = "dubbo://203.195.178.170:28103"*/)
    private com.deepexi.product.service.ProductService productService;
    @Override
    public Boolean delete(List<String> pkList) {
        return null;
    }

    @Override
    public ProductAllInfoDto getAllInfo(String pk) {
        return null;
    }

    @Override
    public List<Sku>  getSkus(List<SkuInfo> skuInfos) {
        List<Sku> skus = new ArrayList<>(1);
        for (SkuInfo skuInfo : skuInfos) {
            Sku sku = getSku(skuInfo);
            skus.add(sku);
        }

        return skus;
    }
    final String lockName = "table-order-lock-";
    public String generateId(IdRuleEnum mainRandom) {
        return generateIdService.getStandardOrderId(lockName + mainRandom.getCode(), 1000L, mainRandom);
//        return IdGenerator.getUuId();
    }
    private Sku getSku(SkuInfo skuInfo) {

        String skuId = skuInfo.getSkuId();

        ProductDto productDto = null;
        try {
            productDto = productService.detailForTrade(skuId);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        if (productDto == null){
            throw new ApplicationException("productService.detailForTrade(skuId) 找不到商品信息！"+skuId);
        }

        if (skuInfo.getSkuCount() > productDto.getRemainStock()){
            throw new ApplicationException(ResultEnum.UNDERSTOCK);
        }

        Sku sku= new Sku();


        ProductCouponDto coupon = productDto.getCoupon();

        CouponAndPackageDto couponTypeDetail = coupon.getTypeDetail();

        if (couponTypeDetail == null){
            throw new ApplicationException("productService.detailForTrade(skuId) 商品中没有优惠券信息！"+skuId);
        }

        List<MemberCouponRelationDto> memberCouponRelationDtos = new ArrayList<>(1);
        // 类型（1-优惠券、2-优惠券组合包）
        String coupon1 = "1",coupon2 = "2";
        if (coupon1.equals(coupon.getType()+"")){



            MemberCouponRelationDto memberCouponRelationDto = new MemberCouponRelationDto();

            memberCouponRelationDto.setCount(1);

            memberCouponRelationDto.setType(coupon.getType());
            memberCouponRelationDto.setTypeId(coupon.getTypeId());

            memberCouponRelationDto.setId(generateId(IdRuleEnum.MAIN_RANDOM));
            memberCouponRelationDto.setMemberId("");
            memberCouponRelationDto.setCouponId(coupon.getTypeId());
            memberCouponRelationDto.setCouponPackageId("");
            memberCouponRelationDto.setActivityCouponRelationId("");
            memberCouponRelationDto.setActivityId("");
            memberCouponRelationDto.setProductId(skuId);

            memberCouponRelationDto.setOrderId("");
            memberCouponRelationDto.setOrderAwardId("");
            memberCouponRelationDto.setVerificationStatus(UseStatusEnum.PENDING_RECEIVE.getState());
            memberCouponRelationDto.setReceiveType(2);
            memberCouponRelationDto.setReceiveTime(new Date());
            memberCouponRelationDto.setTenantCode(appRuntimeEnv.getTenantId());
            memberCouponRelationDto.setCreatedAt(new Date());
            memberCouponRelationDto.setCreatedBy("");
            memberCouponRelationDto.setUpdatedAt(new Date());
            memberCouponRelationDto.setUpdatedBy("");

            memberCouponRelationDto.setDr(0);

            memberCouponRelationDto.setEnterpriseId(couponTypeDetail.getEnterpriseId());
            memberCouponRelationDto.setEnterpriseName(couponTypeDetail.getEnterpriseName());
            memberCouponRelationDto.setOrganizationId(couponTypeDetail.getOrganizationId());


            memberCouponRelationDtos.add(memberCouponRelationDto);
        } else if (coupon2.equals(coupon.getType()+"")){

            List<CouponEquityEnterpriseDto> couponList = couponTypeDetail.getCouponList();

            if (couponList == null){
                throw new ApplicationException("productService.detailForTrade(skuId) 商品中没有优惠券信息！"+skuId);
            }


            for (CouponEquityEnterpriseDto couponEquityEnterpriseDto : couponList) {
                MemberCouponRelationDto memberCouponRelationDto = new MemberCouponRelationDto();

                memberCouponRelationDto.setCount(couponEquityEnterpriseDto.getUnitPackageNum());

                memberCouponRelationDto.setType(coupon.getType());
                memberCouponRelationDto.setTypeId(coupon.getTypeId());

                memberCouponRelationDto.setId(generateId(IdRuleEnum.MAIN_RANDOM));
                memberCouponRelationDto.setMemberId("");
                memberCouponRelationDto.setCouponId(couponEquityEnterpriseDto.getId());
                memberCouponRelationDto.setCouponPackageId(coupon.getId());
                memberCouponRelationDto.setActivityCouponRelationId("");
                memberCouponRelationDto.setActivityId("");
                memberCouponRelationDto.setProductId(skuId);

                memberCouponRelationDto.setOrderId("");
                memberCouponRelationDto.setOrderAwardId("");
                memberCouponRelationDto.setVerificationStatus(-1);
                memberCouponRelationDto.setReceiveType(2);
                memberCouponRelationDto.setReceiveTime(new Date());
                memberCouponRelationDto.setTenantCode(appRuntimeEnv.getTenantId());
                memberCouponRelationDto.setCreatedAt(new Date());
                memberCouponRelationDto.setCreatedBy("");
                memberCouponRelationDto.setUpdatedAt(new Date());
                memberCouponRelationDto.setUpdatedBy("");

                memberCouponRelationDto.setEnterpriseId(couponEquityEnterpriseDto.getEnterpriseId());
                memberCouponRelationDto.setEnterpriseName(couponEquityEnterpriseDto.getEnterpriseName());
                memberCouponRelationDto.setOrganizationId(couponEquityEnterpriseDto.getOrganizationId());

                memberCouponRelationDto.setDr(0);


                memberCouponRelationDtos.add(memberCouponRelationDto);
            }

        }

        sku.setMemberCouponRelationDtos(memberCouponRelationDtos);

        sku.setAwardId(productDto.getId());
        sku.setAwardName(productDto.getName());
        sku.setAwardType(coupon.getType());
//        sku.setAwardStatus(0);
        sku.setCount(skuInfo.getSkuCount());
        sku.setOriginalAmount(productDto.getTotalValue());
        sku.setDiscountsAmount(new BigDecimal("0"));
        sku.setSubtotal(productDto.getPrice().multiply(BigDecimal.valueOf(sku.getCount())));
        sku.setImageUrl(couponTypeDetail.getImageUrl());
        sku.setExchangeType(0);
        sku.setFaceValue(new BigDecimal("0"));
        sku.setUseDescription("");
        sku.setFullAmount(new BigDecimal("0"));
        sku.setSkuId(skuId);
        sku.setMerchantId(memberCouponRelationDtos.get(0).getEnterpriseId());
        sku.setMerchantName(memberCouponRelationDtos.get(0).getEnterpriseName());
        sku.setMemberAwardItemRelationId("");
        sku.setOrderSkuId("");


        return sku;
    }

    @Override
    public Integer onShelf() {
        return null;
    }

    @Override
    public Integer offShelf() {
        return null;
    }

    @Override
    public Boolean offShelf(String productId) {
        return null;
    }

    @Override
    public Boolean frozen(String pk, Integer num) {
        return null;
    }

    @Override
    public Boolean frozenBatch(List<IdNumDto> dtoList) {

        List<com.deepexi.product.domain.dto.IdNumDto> idNumDtos = new ArrayList<>(1);
        for (IdNumDto numDto : dtoList) {
            com.deepexi.product.domain.dto.IdNumDto idNumDto = new com.deepexi.product.domain.dto.IdNumDto();
            idNumDto.setId(numDto.getId());
            idNumDto.setNum(numDto.getNum());
            idNumDtos.add(idNumDto);
        }
        try {
            productService.frozenBatch(idNumDtos);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        return true;
    }

    @Override
    public Boolean releaseFrozen(String pk, Integer num) {
        List<com.deepexi.product.domain.dto.IdNumDto> idNumDtos = new ArrayList<>(1);

        com.deepexi.product.domain.dto.IdNumDto idNumDto = new com.deepexi.product.domain.dto.IdNumDto();
        idNumDto.setId(pk);
        idNumDto.setNum(num);

        idNumDtos.add(idNumDto);
        try {
            productService.releaseFrozenBatch(idNumDtos);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean releaseFrozenBatch(List<IdNumDto> dtoList) {
        return null;
    }

    @Override
    public Boolean occupyFromFrozen(String pk, Integer num) {
        List<com.deepexi.product.domain.dto.IdNumDto> idNumDtos = new ArrayList<>(1);

        com.deepexi.product.domain.dto.IdNumDto idNumDto = new com.deepexi.product.domain.dto.IdNumDto();
        idNumDto.setId(pk);
        idNumDto.setNum(num);

        idNumDtos.add(idNumDto);
        try {
            productService.occupyFromFrozenBatch(idNumDtos);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean occupyFromFrozenBatch(List<IdNumDto> dtoList) {
        return null;
    }

    @Override
    public Boolean addRemainStock(String pk, Integer num) {

        List<com.deepexi.product.domain.dto.IdNumDto> idNumDtos = new ArrayList<>(1);

        com.deepexi.product.domain.dto.IdNumDto idNumDto = new com.deepexi.product.domain.dto.IdNumDto();
        idNumDto.setId(pk);
        idNumDto.setNum(num);

        idNumDtos.add(idNumDto);
        try {
            productService.addRemainStockBatch(idNumDtos);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        return null;
    }

    @Override
    public Boolean addRemainStockBatch(List<IdNumDto> dtoList) {
        return null;
    }

    @Override
    public Product selectById(String pk, boolean throwFlag) {
        try {
            return productService.selectById(pk,throwFlag);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}

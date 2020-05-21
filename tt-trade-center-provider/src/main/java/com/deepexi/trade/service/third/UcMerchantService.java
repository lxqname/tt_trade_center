package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;

import java.util.List;

public interface UcMerchantService {


    /**
     * 商户详情
     * @param pk
     * @return
     */
    UcMerchantDetailVO detail(String pk);


    /**
     * 商户删除
     * @param pk
     * @return
     */
    Boolean delete(String pk);




    /**
     * 获得商户名称
     * @param memberId 会员ID
     * @return 商户名称列表
     */
    List<String> findNameByMemberId(String memberId);

    /**
     * 当前商户分类是否允许新建子渠道分类
     * @param merchantSortId
     * @return
     */
    Boolean allowCreateMerchantSort(String merchantSortId);


}
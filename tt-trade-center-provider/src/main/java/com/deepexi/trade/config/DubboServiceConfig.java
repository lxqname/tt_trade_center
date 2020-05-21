package com.deepexi.trade.config;


import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.trade.service.third.*;
import com.deepexi.wechat.service.WechatTemplateMessageService;
import core.MockStart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
* DubboServiceConfig
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class DubboServiceConfig {


//    @Bean
//    public AccountService accountService() {
//        return MockStart.getInterfaceImpl(AccountService.class);
//    }
//
//
//    @Bean
//    public WmMemberService wmMemberService() {
//        return MockStart.getInterfaceImpl(WmMemberService.class);
//    }


    @Bean
    public UcMerchantService ucMerchantService() {
        return MockStart.getInterfaceImpl(UcMerchantService.class);
    }
    @Bean
    public AcCouponService acCouponService() {
        return MockStart.getInterfaceImpl(AcCouponService.class);
    }
    @Bean
    public AcActivityCouponService acActivityCouponService() {
        return MockStart.getInterfaceImpl(AcActivityCouponService.class);
    }


//    @Bean
//    public ProductService productService() {
//        return MockStart.getInterfaceImpl(ProductService.class);
//    }
//    @Bean
//    public MemberAwardItemRelationService memberAwardItemRelationService() {
//        return MockStart.getInterfaceImpl(MemberAwardItemRelationService.class);
//    }
//
//    @Bean
//    public WmWechatMemberInfoService wmWechatMemberInfoService() {
//        return MockStart.getInterfaceImpl(WmWechatMemberInfoService.class);
//    }
    @Bean
    public WechatTemplateMessageService wechatTemplateMessageService() {
        return MockStart.getInterfaceImpl(WechatTemplateMessageService.class);
    }


}

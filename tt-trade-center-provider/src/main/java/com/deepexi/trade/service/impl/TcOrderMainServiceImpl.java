package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.deepexi.activity.domain.eo.MemberCouponRelation;
import com.deepexi.business.domain.vo.EnterprVo;
import com.deepexi.business.service.BusinessAccountService;
import com.deepexi.business.service.EnterprService;
import com.deepexi.equity.domain.dto.CouponAndPackageDto;
import com.deepexi.equity.service.CouponPackageService;
import com.deepexi.pay.constants.SignConstant;
import com.deepexi.trade.adapter.Sku;
import com.deepexi.trade.config.PayServiceConfig;
import com.deepexi.trade.domain.dto.*;
import com.deepexi.trade.domain.dto.pay.TranAppsRequest;
import com.deepexi.trade.domain.eo.*;
import com.deepexi.trade.domain.vo.OrderCouponVO;
import com.deepexi.trade.domain.vo.TcOrderMainVO;
import com.deepexi.trade.domain.vo.TcOrderPayVO;
import com.deepexi.trade.domain.vo.orderdetail.*;
import com.deepexi.trade.domain.vo.pay.TranAppsResponse;
import com.deepexi.trade.enums.PayTypeEnum;
import com.deepexi.trade.enums.PayURLEnum;
import com.deepexi.trade.enums.ResultEnum;
import com.deepexi.trade.enums.StatusEnum;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.*;
import com.deepexi.trade.service.TcOrderChildService;
import com.deepexi.trade.service.TcOrderMainService;
import com.deepexi.trade.service.TcOrderPayService;
import com.deepexi.trade.service.TcOrderRefundService;
import com.deepexi.trade.service.third.*;
import com.deepexi.trade.service.third.domain.*;
import com.deepexi.user.domain.eo.Account;
import com.deepexi.util.*;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Service(version = "${demo.service.version}")
public class TcOrderMainServiceImpl implements TcOrderMainService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderMainServiceImpl.class);

    @Autowired
    private TcOrderMainMapper tcOrderMainMapper;

    @Autowired
    private TcOrderChildMapper tcOrderChildMapper;

    @Autowired
    private TcOrderPayMapper tcOrderPayMapper;

    @Autowired
    private TcOrderSkuMapper tcOrderSkuMapper;


    @Autowired
    private TcOrderChildService tcOrderChildService;

    @Autowired
    private TcOrderRefundMapper tcOrderRefundMapper;

    @Autowired
    private OrderSkuWriteoffMapper orderSkuWriteoffMapper;

    @Autowired
    private TcOrderRefundWaterMapper tcOrderRefundWaterMapper;

    @Autowired
    private TcOrderRefundService tcOrderRefundService;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Autowired
    private TcOrderPayService tcOrderPayService;

    @Autowired
    private PayServiceImpI payServiceImpI;

    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private WmMemberService wmMemberService;


    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private UcMerchantService ucMerchantService;
    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private AcCouponService acCouponService;
    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private AcActivityCouponService acActivityCouponService;


    @Autowired
    private GenerateIdService generateIdService;
    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private ProductService productService;
    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private MemberAwardItemRelationService memberAwardItemRelationService;

    @Reference(version = "${demo.service.version}", check = false)
    private CouponPackageService couponPackageService;

    @Reference(version = "${demo.service.version}", check = false)
    private EnterprService enterprService;

    @Reference(version = "${demo.service.version}", check = false)
    private BusinessAccountService businessAccountService;

    final String lockName = "table-order-lock-";

    @Value("${elasticJob.orderCloseScheduled.closeTime}")
    private Integer closeTime;
    private Boolean freezeFlag;


    @Override
    public OrderCouponVO getOrderCoupon(MemberCouponRelationDto eo) {
//        TcOrderMainDetailVO detail = detail(eo.getOrderId());

        OrderCouponVO orderCouponVO = new OrderCouponVO();
        List<MemberCouponRelationDto> memberCouponRelationDtos = memberAwardItemRelationService.findAll(eo);


        List<List<MemberCouponRelationDto>> memberCouponRelationDtoss = new ArrayList<>(1);
        orderCouponVO.setMemberCouponRelationDtos(memberCouponRelationDtoss);


        Map<String , List<MemberCouponRelationDto>> idCouponMap = new HashMap<>(2);
        for (MemberCouponRelationDto memberCouponRelationDto : memberCouponRelationDtos) {
            try {
                if (StringUtil.isNotEmpty(memberCouponRelationDto.getCouponId())){
                    memberCouponRelationDto.setCouponAndPackageDto(couponPackageService.queryCouponAndPackage(1, memberCouponRelationDto.getCouponId()));
                }

            } catch (Exception e) {
                throw new ApplicationException(e.getMessage());
            }
            memberCouponRelationDto.setProduct(productService.selectById(memberCouponRelationDto.getProductId(),true));

            if (idCouponMap.get(memberCouponRelationDto.getOrderAwardId()) != null) {
                idCouponMap.get(memberCouponRelationDto.getOrderAwardId()).add(memberCouponRelationDto);
            } else {
                List<MemberCouponRelationDto> memberCouponRelationDtosForMap = new ArrayList<>(2);
                memberCouponRelationDtosForMap.add(memberCouponRelationDto);
                idCouponMap.put(memberCouponRelationDto.getOrderAwardId(),memberCouponRelationDtosForMap);
            }
        }

        Set<Map.Entry<String, List<MemberCouponRelationDto>>> entries = idCouponMap.entrySet();
        for (Map.Entry<String, List<MemberCouponRelationDto>> entry : entries) {
            memberCouponRelationDtoss.add(entry.getValue());
        }


        return orderCouponVO;
    }

    @Override
    public PageBean findPage(TcOrderMainDto eo, Integer page, Integer size) {
        checkPcwx(eo);
        PageHelper.startPage(page, size);
        List<TcOrderMainVO> list = findAll(eo);
        return new PageBean<>(list);
    }

    private void checkPcwx(TcOrderMainDto eo) {
        String wx = "wx";
        if (wx.equals(eo.getDeviceType()) && StringUtil.isEmpty(eo.getMemberId())) {
            eo.setMemberId(getWmMember().getId());
        }
    }

    @Override
    public List<TcOrderMainVO> findAll(TcOrderMainDto eo) {
        checkPcwx(eo);
        List<TcOrderMainVO> list = tcOrderMainMapper.findList(eo);
        if ( null != list){
            list.forEach(order ->{
                TcOrderChildDto tcOrderChildDto = new TcOrderChildDto();
                tcOrderChildDto.setOrderId(order.getId());
                order.setTcOrderChildVOS(tcOrderChildService.findAll(tcOrderChildDto));
            });
        }
        return list;
    }
    @Override
    public TcOrderMainDetailVO detail(String pk) {
        TcOrderMainDetailVO detailVO = new TcOrderMainDetailVO();


        TcOrderMainDto mainDto = new TcOrderMainDto();
        mainDto.setId(pk);
        List<TcOrderMainVO> mainVOS = findAll(mainDto);

        if(CollectionUtil.isEmpty(mainVOS)){
            logger.info("TcOrderMainServiceImpl.detail：查询不到订单数据数据，订单ID为：{}", pk);
            return null;
        }

        TcOrderMainVO mainVO = mainVOS.get(0);

        setMemberInfo(detailVO, mainVO);


        mainVO.setIsRefund(0);

        Integer awardType = 1;
        mainVO.setAwardType(awardType);

        detailVO.setMerchantDetailInfo(getMerchantDetailInfo(detailVO, mainVO, awardType));


        detailVO.setOrderPayInfo(getOrderPayInfo(mainVO));

        detailVO.setOrderRefundInfo(getOrderRefundInfo(mainVO));

        try {
            TcOrderRefundDto canRefund = getCanRefund(mainVO.getId());
            detailVO.setRefundCount(canRefund.getRefundCount());
        } catch (Exception e) {
            e.printStackTrace();
        }


        detailVO.setTcOrderMainVO(mainVO);
        return detailVO;
    }

    private OrderRefundInfo getOrderRefundInfo(TcOrderMainVO mainVO) {
        OrderRefundInfo refundInfo = new OrderRefundInfo();
        TcOrderRefundDto refundDto = new TcOrderRefundDto();
        refundDto.setOrderId(mainVO.getId());
        List<TcOrderRefund> refunds = tcOrderRefundMapper.findList(refundDto);
        if(CollectionUtil.isNotEmpty(refunds)){
            TcOrderRefund tcOrderRefund = refunds.get(0);

            BeanUtils.copyProperties(tcOrderRefund,refundInfo);
            refundInfo.setPayType(mainVO.getPayType());
            TcOrderRefundWaterDto waterDto = new TcOrderRefundWaterDto();
            waterDto.setRefundOrderId(tcOrderRefund.getId());
            List<TcOrderRefundWater> waterList = tcOrderRefundWaterMapper.findList(waterDto);
            if(CollectionUtil.isNotEmpty(waterList)){
                // TODO: 2019/5/31
                if (waterList.size() > 4){
                    Map<Integer,Integer> map = new HashMap(16);
                    List<TcOrderRefundWater> waterLists = new ArrayList<>();

                    waterList.forEach( water ->{

                        System.out.println(water.getProcessType());

                        System.out.println(map.get(water.getProcessType()));
                        if ( null == map.get(water.getProcessType())  ){
                            waterLists.add(water);
                            map.put(water.getProcessType(),water.getProcessType());
                        }

                    });
                    refundInfo.setRefundWaterList(waterLists);
                } else {
                    refundInfo.setRefundWaterList(waterList);
                }

            }


            mainVO.setIsRefund(1);
        }
        return refundInfo;
    }

    private OrderPayInfo getOrderPayInfo(TcOrderMainVO mainVO) {
        OrderPayInfo orderPayInfo = new OrderPayInfo();
        TcOrderPayDto payDto = new TcOrderPayDto();
        payDto.setOrderId(mainVO.getId());
        payDto.setOrderStatus(StatusEnum.SUCCESS.getCode());
        List<TcOrderPay> successOrderPay = tcOrderPayMapper.findList(payDto);
        if(CollectionUtil.isNotEmpty(successOrderPay)){
            TcOrderPay tcOrderPay = successOrderPay.get(0);

            BeanUtils.copyProperties(tcOrderPay,orderPayInfo);
            orderPayInfo.setPayTypeName(PayTypeEnum.getEnumByCode(tcOrderPay.getPayType()).getDesc());
            orderPayInfo.setPayTime(DateUtils.toDateText(tcOrderPay.getPayTime(),DateUtils.DEFAULT_DATE_TIME_FORMAT));
            if(StringUtil.isNotEmpty(mainVO.getExpendCouponId())){
                //todo 暂时这里没有，使用了优惠券要展示对应的优惠金额
            }else {
                orderPayInfo.setDiscountsAmount(BigDecimal.valueOf(0));
                orderPayInfo.setOrderAmount(mainVO.getAmount());
                orderPayInfo.setPayableAmount(mainVO.getAmount());
            }

        }
        return orderPayInfo;
    }

    private void setMemberInfo(TcOrderMainDetailVO detailVO, TcOrderMainVO mainVO) {
        WmMember member = null;
        try {
            member = wmMemberService.detailById(mainVO.getMemberId());
        } catch (Exception e) {
            logger.error("TcOrderMainServiceImpl.detail：查询会员信息异常,token为[{}]", appRuntimeEnv.getToken());
        }

        if(null != member){
            MemberInfo memberInfo = new MemberInfo();
            BeanUtils.copyProperties(member,memberInfo);
            detailVO.setMemberInfo(memberInfo);
        }
    }

    private MerchantDetailInfo getMerchantDetailInfo(TcOrderMainDetailVO detailVO, TcOrderMainVO mainVO, Integer awardType) {
        MerchantDetailInfo detailInfo = new MerchantDetailInfo();
        //单商品才需要查询商户信息
        if(Integer.valueOf(1).equals(awardType)){
            UcMerchantDetailVO merchantDetail = null;
            EnterprVo enterprVoById = null;
            try {
                enterprVoById = enterprService.getEnterprVoById(mainVO.getTcOrderChildVOS().get(0).getMerchantId());

                merchantDetail = ucMerchantService.detail(mainVO.getTcOrderChildVOS().get(0).getMerchantId());
            } catch (Exception e) {
                logger.error("TcOrderMainServiceImpl.detail：查询商户信息异常,token为[{}]", appRuntimeEnv.getToken());
                throw new ApplicationException(e.getMessage());
            }
            if(null != merchantDetail){
                BeanUtils.copyProperties(merchantDetail,detailInfo);
                detailVO.setMerchantDetailInfo(detailInfo);
            }

            if (null != enterprVoById){

                detailInfo.setAddress(/*enterprVoById.getProvinceName()+enterprVoById.getCityName()+*/enterprVoById.getAddress()/*+enterprVoById.getEnterprClassifyName()*/);
                detailInfo.setContactMobile(enterprVoById.getMobile());
                detailInfo.setContactPerson(enterprVoById.getLegalPersonName());
                detailInfo.setName(enterprVoById.getName());

            }

            Account accountByEnterprOrganizationId = null;
            try {
                accountByEnterprOrganizationId = businessAccountService.getAccountByEnterprOrganizationId(mainVO.getTcOrderChildVOS().get(0).getMerchantId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (accountByEnterprOrganizationId != null){
                detailInfo.setName(accountByEnterprOrganizationId.getName());
            }
        }
        return detailInfo;
    }

    @Override
    public Boolean create(TcOrderMainDto eo) {
        int result = tcOrderMainMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderMain.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderMainDto eo) {
        eo.setId(pk);
        int result = tcOrderMainMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderMain.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderMainMapper.deleteByIds(pk);
        return result > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TcOrderMainVO orderPlace(TcOrderPlaceRequestDto dto) {
        BigDecimal mainAmount = BigDecimal.valueOf(0);
        List<SkuInfo> skuInfos = dto.getSkuInfos();
        if(CollectionUtil.isEmpty(skuInfos)) {
            throw new ApplicationException(ResultEnum.EVENT_NOT_FOUND);
        }

        List<String> activityIds = skuInfos.stream().map(SkuInfo::getActivityId).collect(Collectors.toList());

        //查询会员信息
        WmMember member = getWmMember();

        TcOrderMain tcOrderMain = normalOrderPlace(dto, mainAmount, skuInfos, activityIds, member);

        TcOrderMainVO vo = new TcOrderMainVO();
        BeanUtils.copyProperties(tcOrderMain,vo);
        vo.setOrderId(tcOrderMain.getId());
        return vo;
    }

    private TcOrderMain normalOrderPlace(TcOrderPlaceRequestDto dto, BigDecimal mainAmount, List<SkuInfo> skuInfos, List<String> activityIds, WmMember member) {
        // 组建主订单
        TcOrderMain tcOrderMain = getTcOrderMain(dto, member);
        // 获取sku
        List<Sku> skus = getSkus(skuInfos);
        // 预定商品，待核销
        preWriteOff(member, tcOrderMain, skus);

        for (SkuInfo skuInfo : skuInfos){
            for (Sku sku : skus) {
                //相同活动才进行操作
                if (skuInfo.getSkuId().equals(sku.getSkuId())) {
                    // 组建子订单 入子表信息
                    TcOrderChild tcOrderChild = getTcOrderChild(dto,tcOrderMain, null, sku);
                    // 组建订单sku
                    TcOrderSku tcOrderSku = getTcOrderSku(dto,null, skuInfo, sku, tcOrderChild);
                    tcOrderSku.setOrderId(tcOrderMain.getId());
                    tcOrderSkuMapper.insert(tcOrderSku);
                    //金额重新更新
                    tcOrderChild.setChildAmount(tcOrderSku.getSubtotal());
                    tcOrderChildMapper.insert(tcOrderChild);

                    mainAmount = mainAmount.add(tcOrderSku.getSubtotal());
                }
            }
        }
//        mainAmount = new BigDecimal(0.01);

        tcOrderMain.setAmount(mainAmount);
        tcOrderMainMapper.insert(tcOrderMain);

        frozenBatch(skuInfos);
        return tcOrderMain;
    }


    private TcOrderSku getTcOrderSku(TcOrderPlaceRequestDto dto, Activity activity, SkuInfo skuInfo, Sku sku, TcOrderChild tcOrderChild) {
        TcOrderSku tcOrderSku = new TcOrderSku();
        BeanUtils.copyProperties(sku,tcOrderSku);
//        tcOrderSku.setId(generateIdService.getStandardOrderId(lockName + IdRuleEnum.COMMON_RANDOM.getCode(), 1000L, IdRuleEnum.COMMON_RANDOM));
        tcOrderSku.setId(sku.getOrderSkuId());
        tcOrderSku.setOrderChildId(tcOrderChild.getId());
        tcOrderSku.setProductId(sku.getSkuId());
        return tcOrderSku;
    }


    private TcOrderChild getTcOrderChild(TcOrderPlaceRequestDto dto, TcOrderMain tcOrderMain, Activity activity, Sku sku) {
        TcOrderChild tcOrderChild = new TcOrderChild();
        tcOrderChild.setOrderId(tcOrderMain.getId());
        tcOrderChild.setChildNo(generateId(IdRuleEnum.CHILD_RANDOM));
//        tcOrderChild.setChildNo(sku.getOrderChildId());
        tcOrderChild.setId(tcOrderChild.getChildNo());
        tcOrderChild.setMerchantId(sku.getMerchantId());
        tcOrderChild.setMerchantName(sku.getMerchantName());
        tcOrderChild.setEventId(sku.getMemberCouponRelationDtos().get(0).getTypeId());
        tcOrderChild.setEventName(sku.getMemberCouponRelationDtos().get(0).getType()+"");
        //todo 待获取活动编号
        tcOrderChild.setEventNo(activity == null ? "" : activity.getId());
        return tcOrderChild;
    }


    private TcOrderMain getTcOrderMain(TcOrderPlaceRequestDto dto, WmMember member) {
        TcOrderMain tcOrderMain = new TcOrderMain();
        //todo 根据积分或者使用优惠券抵扣一部分支付金额，并且锁定券或者锁定积分
        if(null != dto.getIntegral() && 0 != dto.getIntegral()){
            tcOrderMain.setExpendIntegral(String.valueOf(dto.getIntegral()));
        }

        //todo 根据积分或者使用优惠券抵扣一部分支付金额，并且锁定券或者锁定积分
        if(StringUtil.isNotEmpty(dto.getCouponId())){
            tcOrderMain.setExpendCouponId(dto.getCouponId());
        }

//        tcOrderMain.seta
        //入主表信息
        tcOrderMain.setMemberId(member.getId());
        tcOrderMain.setMemberName(member.getName());
        tcOrderMain.setOrderNo(generateId(IdRuleEnum.MAIN_RANDOM));
        tcOrderMain.setId(tcOrderMain.getOrderNo());
        //暂定只有现金兑换的方式
        tcOrderMain.setOrderType(1);
        tcOrderMain.setOrderStatus(StatusEnum.PAY_PENDING.getCode());
        return tcOrderMain;
    }




    /*
    //根据活动商品list去判断商品对应的库存是否有效
     */
    private List<Sku> getSkus(List<SkuInfo> skuInfos) {

        return productService.getSkus(skuInfos);
    }

    private void preWriteOff(WmMember member, TcOrderMain tcOrderMain, List<Sku> skus) {
        for (Sku sku : skus) {

            try {
                for (int i = 0; i < sku.getCount(); i++) {
                    preWriteOff(member, tcOrderMain, sku,i);
                }
            } catch (Exception e) {
                logger.error("TcOrderMainServiceImpl.orderPlace：发货异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "发货异常:"+e.getMessage()));

            }
        }
    }

    private void frozenBatch(List<SkuInfo> skuInfos) {
        List<IdNumDto> idNums = new ArrayList<>(2);
        for (SkuInfo sku : skuInfos) {
            IdNumDto idNumDto = new IdNumDto();
            idNumDto.setId(sku.getSkuId());
            idNumDto.setNum(sku.getSkuCount());
            idNums.add(idNumDto);
        }
        try {
            productService.frozenBatch(idNums);
        } catch (ApplicationException e) {
            logger.error("TcOrderMainServiceImpl.orderPlace：库存处理异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "库存处理异常:"+e.getMessage()));
        }
    }

    private void preWriteOff(WmMember member, TcOrderMain tcOrderMain, Sku sku,  int times) {

        MemberCouponRelationDto memberCouponRelationDto = sku.getMemberCouponRelationDtos().get(0);

        memberCouponRelationDto.setMemberId(member.getId());
        memberCouponRelationDto.setActivityCouponRelationId("");
        memberCouponRelationDto.setActivityId("");
        memberCouponRelationDto.setOrderId(tcOrderMain.getId());
        memberCouponRelationDto.setOrderAwardId(tcOrderMain.getId()+times);


        memberAwardItemRelationService.create(memberCouponRelationDto);

        //去活着中心核销，核销之后给个通知就行 // TODO: 2019/5/23
        sku.getMemberCouponRelationDtos().forEach(info->{
            for (int i = 0;i<info.getCount(); i++){
                MemberAwardItemRelation eo = new MemberAwardItemRelation();
                eo.setId(generateId(IdRuleEnum.MAIN_RANDOM));
                eo.setMemberId(member.getId());
//                eo.setMemberAccount(member.getAccountId());
                eo.setMemberAccount(member.getAccountName());
                eo.setMemberMobile(member.getMobile());
                eo.setReceiveType(3);
                eo.setReceiveTime(new Date());
                eo.setAwardItemId(info.getId());
                eo.setAwardId(sku.getAwardId());
//                eo.setActivityId(participantActivity.getActivityId());
                eo.setVerificationStatus(66/*UseStatusEnum.RESERVATION.getState()*/);
                //订单ID 奖品ID 组合=skuid // TODO: 2019/5/23 orderid
                eo.setOrderId(tcOrderMain.getId());
                eo.setOrderAwardId(tcOrderMain.getId()+times);
                eo.setProductId(sku.getSkuId());



                sku.appendMemberAwardItemRelationId(eo.getId());

                OrderSkuWriteoff orderSkuWriteoff = new OrderSkuWriteoff();

                orderSkuWriteoff.setOrderId(tcOrderMain.getId());
                orderSkuWriteoff.setOrderSkuId(sku.getOrderSkuId());
                orderSkuWriteoff.setAwardId(sku.getAwardId());
                orderSkuWriteoff.setAwardItemId(info.getCouponId());
                orderSkuWriteoff.setMemberAwardItemId(eo.getId());
                orderSkuWriteoff.setAwardNum(info.getCount());
                orderSkuWriteoff.setRemark1(sku.getCount()+"");
                orderSkuWriteoff.setRemark2(sku.getMemberCouponRelationDtos().size()+"");
                orderSkuWriteoff.setStatus(0);
                orderSkuWriteoff.setOrderAwardId(eo.getOrderAwardId());

                orderSkuWriteoffMapper.insert(orderSkuWriteoff);
            }

        });

    }

    /*
    //根据活动商品list去判断商品对应的库存是否有效
     */
    private List<Sku> getSkusFromProduct(TcOrderPlaceRequestDto dto, List<SkuInfo> skuInfos,WmMember member, TcOrderMain tcOrderMain) {
        List<Sku> acCouponDetailDtos = new ArrayList<>();

        Map<String,Integer> skuIdCountMap = new HashMap<>(16);
        for (SkuInfo skuInfo: skuInfos) {
            Sku sku = new Sku();

            try {
                ProductAllInfoDto allInfo = null;
                try {
                    allInfo = productService.getAllInfo(skuInfo.getSkuId());

    //                AcCouponDetailDto acCouponDetailDto = new AcCouponDetailDto();
    //                acCouponDetailDto.setId(skuInfos.get(0).getSkuId());
    //                acCouponDetailDto.setMerchantName("test3");
    //                acCouponDetailDto.setName("test");
    //                acCouponDetailDto.setExpectIssueNum(100);
    //                acCouponDetailDto.setFaceValue(new BigDecimal("0.01"));
    //                acCouponDetailDto.setFullAmount(new BigDecimal("10"));
    //                acCouponDetailDto.setUseDescription("满10减1");

                } catch (Exception e) {
                    logger.error("TcOrderMainServiceImpl.orderPlace：查询商品信息异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                    throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "查询商品信息异常:"+e.getMessage()));
                }


                try {
                    // TODO: 2019/10/12  test
//                    if(skuInfo.getSkuCount() > allInfo.getRemainStock()) {
//                        throw new ApplicationException(ResultEnum.UNDERSTOCK);
//                    }

                    skuIdCountMap.put(allInfo.getId(),skuInfo.getSkuCount());

                    /*//todo 冻结库存，取消时解冻库存
                    Boolean freezeFlag = false;
                    freezeFlag = productService.frozen(allInfo.getId(),skuInfo.getSkuCount());
                    if (freezeFlag){
                        skuIdCountMap.put(allInfo.getId(),skuInfo.getSkuCount());
                    }
                    //冻结失败或者调用失败，都抛异常
                    if(!freezeFlag) {
                        throw new ApplicationException(ResultEnum.UNDERSTOCK);
                    }*/
                } catch (ApplicationException e) {
                    logger.error("TcOrderMainServiceImpl.orderPlace：库存处理异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                    throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "库存处理异常:"+e.getMessage()));
                }


                try {
    //                sku.setId(generateIdService.getStandardOrderId(lockName + IdRuleEnum.COMMON_RANDOM.getCode(), 1000L, IdRuleEnum.COMMON_RANDOM));
                    sku.setOrderSkuId(generateId(IdRuleEnum.COMMON_RANDOM));

                    sku.setSkuId(allInfo.getId());
                    sku.setAwardId(allInfo.getAwardId());
                    sku.setAwardName(allInfo.getName());
                    sku.setCount(skuInfo.getSkuCount());
                    sku.setOriginalAmount(allInfo.getPrePrice());
                    //todo 待获取活动优惠金额
                    sku.setDiscountsAmount(BigDecimal.valueOf(0));

                    // TODO: 2019/10/12 test 
//                    sku.setSubtotal(sku.getOriginalAmount().subtract(sku.getDiscountsAmount()).multiply(BigDecimal.valueOf(sku.getCount())));
                    sku.setImageUrl(allInfo.getImageUrl());
                    //暂定只有现金兑换的方式
                    sku.setExchangeType(1);
                    sku.setAwardType(skuInfo.getSkuType());
                    sku.setFaceValue(allInfo.getPrePrice());
                    sku.setUseDescription(allInfo.getUseDescription());
                    sku.setFullAmount(allInfo.getPrePrice());
                    Equity equity = allInfo.getAwardAllInfoDto().getAwardItemAllInfoDtoList().get(0).getCouponAllInfoDto().getEquity();

                    //todo 待获取商户id
                    sku.setMerchantId(equity.getMerchantId());
                    sku.setMerchantName(allInfo.getAwardAllInfoDto().getAwardItemAllInfoDtoList().get(0).getCouponAllInfoDto().getMerchantName());

                } catch (Exception e) {
                    logger.error("TcOrderMainServiceImpl.orderPlace：查询商品信息异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                    throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "查询商品信息异常:"+e.getMessage()));
                }

                try {
                    for (int i = 0; i < skuInfo.getSkuCount(); i++) {
                        preWriteOff(member, tcOrderMain, sku, allInfo,skuInfo,i);
                    }
                } catch (Exception e) {
                    logger.error("TcOrderMainServiceImpl.orderPlace：发货异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                    throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "发货异常:"+e.getMessage()));

                }
            } catch (ApplicationException e) {
                /*Set<Map.Entry<String, Integer>> skuIdCountentries = skuIdCountMap.entrySet();
                for (Map.Entry<String, Integer> stringIntegerEntry :skuIdCountentries) {
                    productService.addRemainStock(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
                }*/
                throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "异常:"+e.getMessage()));
            }
            if(null != sku) {
                acCouponDetailDtos.add(sku);
            }
        }


        try {
            List<IdNumDto> idNums = new ArrayList<>(2);
            Set<Map.Entry<String, Integer>> skuIdCountentries = skuIdCountMap.entrySet();
            for (Map.Entry<String, Integer> stringIntegerEntry :skuIdCountentries) {
                IdNumDto idNumDto = new IdNumDto();
                idNumDto.setId(stringIntegerEntry.getKey());
                idNumDto.setNum(stringIntegerEntry.getValue());
                idNums.add(idNumDto);
            }
            productService.frozenBatch(idNums);
        } catch (ApplicationException e) {
            logger.error("TcOrderMainServiceImpl.orderPlace：库存处理异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "库存处理异常:"+e.getMessage()));
        }
        if(CollectionUtil.isEmpty(acCouponDetailDtos)) {
            throw new ApplicationException(ResultEnum.AWARD_NOT_FOUND);
        }


        return acCouponDetailDtos;
    }

    private void preWriteOff(WmMember member, TcOrderMain tcOrderMain, Sku sku, ProductAllInfoDto allInfo, SkuInfo skuInfo, int times) {
        //去活着中心核销，核销之后给个通知就行 // TODO: 2019/5/23
        allInfo.getAwardAllInfoDto().getAwardItemAllInfoDtoList().stream().forEach(info->{
            for (int i = 0;i<info.getAwardNum(); i++){
                MemberAwardItemRelation eo = new MemberAwardItemRelation();
                eo.setId(generateId(IdRuleEnum.MAIN_RANDOM));
                eo.setMemberId(member.getId());
//                eo.setMemberAccount(member.getAccountId());
                eo.setMemberAccount(member.getAccountName());
                eo.setMemberMobile(member.getMobile());
                eo.setReceiveType(3);
                eo.setReceiveTime(new Date());
                eo.setAwardItemId(info.getId());
                eo.setAwardId(sku.getAwardId());
//                eo.setActivityId(participantActivity.getActivityId());
                eo.setVerificationStatus(66/*UseStatusEnum.RESERVATION.getState()*/);
                //订单ID 奖品ID 组合=skuid // TODO: 2019/5/23 orderid
                eo.setOrderId(tcOrderMain.getId());
                eo.setOrderAwardId(tcOrderMain.getId()+times);
                eo.setProductId(skuInfo.getSkuId());


                memberAwardItemRelationService.create(eo);

                sku.appendMemberAwardItemRelationId(eo.getId());

                OrderSkuWriteoff orderSkuWriteoff = new OrderSkuWriteoff();

                orderSkuWriteoff.setOrderId(tcOrderMain.getId());
                orderSkuWriteoff.setOrderSkuId(sku.getOrderSkuId());
                orderSkuWriteoff.setAwardId(sku.getAwardId());
                orderSkuWriteoff.setAwardItemId(info.getId());
                orderSkuWriteoff.setMemberAwardItemId(eo.getId());
                orderSkuWriteoff.setAwardNum(info.getAwardNum());
                orderSkuWriteoff.setRemark1(skuInfo.getSkuCount()+"");
                orderSkuWriteoff.setRemark2(allInfo.getAwardAllInfoDto().getAwardItemAllInfoDtoList().size()+"");
                orderSkuWriteoff.setStatus(0);
                orderSkuWriteoff.setOrderAwardId(eo.getOrderAwardId());

                orderSkuWriteoffMapper.insert(orderSkuWriteoff);
            }

        });

    }

    public String generateId(IdRuleEnum mainRandom) {
        return generateIdService.getStandardOrderId(lockName + mainRandom.getCode(), 1000L, mainRandom);
//        return IdGenerator.getUuId();
    }


    @Override
    public void updateMemberAwardItemRelation(TcOrderMainVO tcOrderMainvo,String oId, String orderAwardId,  Integer state){

        if (StringUtil.isNotEmpty(orderAwardId)&&orderAwardId.contains(",")){
            List<String> orderAwardIds = Arrays.asList(orderAwardId.split(","));
            orderAwardIds.forEach(oaid -> {
                if (StringUtil.isNotEmpty(oaid)){
                    updateMemberAwardItemRelationSingle(oId, oaid, state);
                }

            });
        }else {
            updateMemberAwardItemRelationSingle(oId, orderAwardId, state);
        }




    }

    private void updateMemberAwardItemRelationSingle(String oId, String orderAwardId, Integer state) {
        List<MemberCouponRelationDto> all = getMemberCouponRelationDtos(oId, orderAwardId,null);
        all.forEach(memberAwardItemRelation -> {
            memberAwardItemRelation.setVerificationStatus(state);
//            eo.setReceiveTime(tcOrderMainvo.getp);
            memberAwardItemRelationService.update(memberAwardItemRelation.getId(),memberAwardItemRelation);
        });
    }

    private List<MemberCouponRelationDto> getMemberCouponRelationDtos(String oId, String orderAwardId, Integer state) {
        return getMemberCouponRelationDtos(oId, orderAwardId, state,null);
    }
    private List<MemberCouponRelationDto> getMemberCouponRelationDtos(String oId, String orderAwardId, Integer state,String couponID) {
        MemberCouponRelationDto eo = new MemberCouponRelationDto();
        eo.setOrderId(oId);
        eo.setOrderAwardId(orderAwardId);
        eo.setVerificationStatus(state);
        eo.setCouponId(couponID);
        return memberAwardItemRelationService.findAll(eo);
    }

    @Override
    public boolean expireAwardItem(List<String> itemIds) {
        boolean flag = false;

        if (CollectionUtil.isEmpty(itemIds)){
            return flag;
        }

        String itemIdsStr = "";
        for (int i = 0; i < itemIds.size(); i++) {
            itemIdsStr += itemIds.get(i);

            if (i < itemIds.size() - 1){
                itemIdsStr += ",";
            }
        }

        OrderSkuWriteoffDto orderSkuWriteoffDto = new OrderSkuWriteoffDto();
        orderSkuWriteoffDto.setAwardItemId(itemIdsStr);
        orderSkuWriteoffDto.setStatus(0);
        List<OrderSkuWriteoff> orderSkuWriteoffMapperList = orderSkuWriteoffMapper.findList(orderSkuWriteoffDto);

        if (CollectionUtil.isEmpty(orderSkuWriteoffMapperList)){
            return flag;
        }


//        orderSkuWriteoffMapperList.forEach(orderSkuWriteoff -> {
//            OrderSkuWriteoff writeoff = BeanPowerHelper.mapPartOverrider(orderSkuWriteoff, OrderSkuWriteoff.class);
//            writeoff.setStatus(2);
//            orderSkuWriteoffMapper.updateById(writeoff);
//        });

        Map<String, List<OrderSkuWriteoff>> oidMap = getOidListMap(orderSkuWriteoffMapperList);

        Set<Map.Entry<String, List<OrderSkuWriteoff>>> entries = oidMap.entrySet();
        for (Map.Entry<String, List<OrderSkuWriteoff>> entry: entries) {
            try {
//                expireAwardItemInTransac(entry);
                expireAwardItemByOrderAwardInTransac(entry);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        return true;
    }

    @Transactional
    public void expireAwardItemByOrderAwardInTransac(Map.Entry<String, List<OrderSkuWriteoff>> entry) {
        List<TcOrderRefundDto> tcOrderRefundDtos = getTcOrderRefundDtos(entry,2);
        if (CollectionUtil.isNotEmpty(tcOrderRefundDtos) ){
            tcOrderRefundDtos.forEach(refund->{
                if (refund.getRefundCount() != null){
                    tcOrderRefundService.orderRefund(refund);
                }
                });
        }

    }

    @Override
    public TcOrderRefundDto getCanRefund(String oid){
        OrderSkuWriteoffDto orderSkuWriteoffDto = new OrderSkuWriteoffDto();
        orderSkuWriteoffDto.setOrderId(oid);
        orderSkuWriteoffDto.setStatus(0);
        List<OrderSkuWriteoff> orderSkuWriteoffMapperList = orderSkuWriteoffMapper.findList(orderSkuWriteoffDto);

        if (CollectionUtil.isEmpty(orderSkuWriteoffMapperList)){
            TcOrderRefundDto tcOrderRefundDto = new TcOrderRefundDto();
            tcOrderRefundDto.setRefundCount(0);
            return tcOrderRefundDto;
        }

        Map<String, List<OrderSkuWriteoff>> oidMap = getOidListMap(orderSkuWriteoffMapperList);

        Set<Map.Entry<String, List<OrderSkuWriteoff>>> entries = oidMap.entrySet();
        for (Map.Entry<String, List<OrderSkuWriteoff>> entry: entries) {
            TcOrderRefundDto tcOrderRefundDto = getTcOrderRefundDtos(entry, 1).get(0);


            return tcOrderRefundDto;
        }
        return null;
    }



    private List<TcOrderRefundDto> getTcOrderRefundDtos(Map.Entry<String, List<OrderSkuWriteoff>> entry,Integer refundOperationType) {
        Map<String, List<OrderSkuWriteoff>> orderAwardIdListMap = getOrderAwardIdListMap(entry.getValue());

        List<TcOrderRefundDto> tcOrderRefundDtos = new ArrayList<>();
        Set<Map.Entry<String, List<OrderSkuWriteoff>>> entries = orderAwardIdListMap.entrySet();

        TcOrderRefundDto tcOrderRefundDto = new TcOrderRefundDto();
        tcOrderRefundDto.setOrderNo(entry.getKey());
        tcOrderRefundDto.setRefundOperationType(refundOperationType);

        tcOrderRefundDtos.add(tcOrderRefundDto);
        tcOrderRefundDto.setRefundCount(0);


        for (Map.Entry<String, List<OrderSkuWriteoff>> entry1: entries) {
            boolean canRefundFlag = true;
            List<MemberCouponRelationDto> memberCouponRelationDtos = getMemberCouponRelationDtos(entry.getKey(), entry1.getKey(),UseStatusEnum.USED.getState());
            if (CollectionUtil.isNotEmpty(memberCouponRelationDtos)) {
                canRefundFlag = false;
            }

            if (canRefundFlag){
                tcOrderRefundDto.addRefundCount(1);
                for (OrderSkuWriteoff writeoff : entry1.getValue()) {
                    OrderSkuWriteoff writeoffUpdate = BeanPowerHelper.mapPartOverrider(writeoff, OrderSkuWriteoff.class);
                    writeoffUpdate.setStatus(2);
                    orderSkuWriteoffMapper.updateById(writeoffUpdate);
                    if (StringUtil.isNotEmpty(tcOrderRefundDto.getAwardId())){
                        tcOrderRefundDto.setAwardId(tcOrderRefundDto.getAwardId() + ","+ entry1.getValue().get(0).getAwardId());
                    }else {
                        tcOrderRefundDto.setAwardId(entry1.getValue().get(0).getAwardId());
                    }

                    if (StringUtil.isNotEmpty(tcOrderRefundDto.getOrderAwardId() )){
                        tcOrderRefundDto.setOrderAwardId(tcOrderRefundDto.getOrderAwardId() + ","+entry1.getValue().get(0).getOrderAwardId());
                    }else {
                        tcOrderRefundDto.setOrderAwardId(entry1.getValue().get(0).getOrderAwardId());
                    }
                }

            }
        }


//        int count = 0;
//        for (Map.Entry<String, List<OrderSkuWriteoff>> entry1: entries) {
//
//            List<OrderSkuWriteoff> writeoffs = exitsUsedAwardByOrderId(entry.getKey(), entry1.getKey(),refundOperationType);
//
//            List<OrderSkuWriteoff> allWo = null;
//            if (2 == refundOperationType){
//                allWo = exitsUsedAwardByOrderId(entry.getKey(), entry1.getKey(), null);
//            }
//
//            if (("1".equals(refundOperationType+"") && CollectionUtil.isEmpty(writeoffs))
//            || ("2".equals(refundOperationType+"") && allWo.size()==writeoffs.size())
//            ){
//                tcOrderRefundDto.addRefundCount(1);
//                if (StringUtil.isNotEmpty(tcOrderRefundDto.getAwardId())){
//                    tcOrderRefundDto.setAwardId(tcOrderRefundDto.getAwardId() + ","+ entry1.getValue().get(0).getAwardId());
//                }else {
//                    tcOrderRefundDto.setAwardId(entry1.getValue().get(0).getAwardId());
//                }
//
//                if (StringUtil.isNotEmpty(tcOrderRefundDto.getOrderAwardId() )){
//                    tcOrderRefundDto.setOrderAwardId(tcOrderRefundDto.getOrderAwardId() + ","+entry1.getValue().get(0).getOrderAwardId());
//                }else {
//                    tcOrderRefundDto.setOrderAwardId(entry1.getValue().get(0).getOrderAwardId());
//                }
//            }
//
//
//
//        }





        return tcOrderRefundDtos;
    }

    
    @Transactional
    public void expireAwardItemInTransac(Map.Entry<String, List<OrderSkuWriteoff>> entry) {
        for (OrderSkuWriteoff writeoff1 :entry.getValue()){
            if (StringUtil.isNotEmpty(writeoff1.getRemark1())){
                expireAwardItemInTransac(writeoff1);
            }

        }
    }


    public void expireAwardItemInTransac(OrderSkuWriteoff writeoff1) {
        if ("1".equals(writeoff1.getAwardNum())
                && "1".equals(writeoff1.getRemark2())) {
            if(refund(writeoff1, writeoff1.getRemark1())){
                writeoff1.setStatus(2);
                orderSkuWriteoffMapper.updateById(writeoff1);
            }
        } else {

            List<OrderSkuWriteoff> writeoffs = exitsUsedAwardByOrderId(writeoff1.getOrderId());
            if ("1".equals(writeoff1.getRemark1())) {
                if (!CollectionUtil.isNotEmpty(writeoffs)) {
                    if(refund(writeoff1, writeoff1.getRemark1())){
                        writeoff1.setStatus(2);
                        orderSkuWriteoffMapper.updateById(writeoff1);
                    }
                }

            } else {

                if (!CollectionUtil.isNotEmpty(writeoffs)) {
                    if(refund(writeoff1, writeoff1.getRemark1())){
                        writeoff1.setStatus(2);
                        orderSkuWriteoffMapper.updateById(writeoff1);
                    }
                } else {
                    Map<String, List<OrderSkuWriteoff>> itemIdListMap = getItemIdListMap(writeoffs);
                    if(refund(writeoff1,getRefundCount(itemIdListMap))){
                        writeoff1.setStatus(2);
                        orderSkuWriteoffMapper.updateById(writeoff1);
                    }
                }
            }
        }
    }

    private String getRefundCount(Map<String, List<OrderSkuWriteoff>> itemIdListMap) {

        String ret = "0";
        Set<Map.Entry<String, List<OrderSkuWriteoff>>> entries = itemIdListMap.entrySet();
        for (Map.Entry<String, List<OrderSkuWriteoff>> entry: entries) {
            for (OrderSkuWriteoff writeoff1 : entry.getValue()) {
                String remark1 = writeoff1.getRemark1();
                String remark2 = writeoff1.getRemark2();
                Integer awardNum = writeoff1.getAwardNum();
                int usesize = entry.getValue().size();

                if (usesize >= awardNum*Integer.parseInt(remark1)){
                    return "0";
                } else {
                    int unUseCount = awardNum * Integer.parseInt(remark1) - usesize;
                    if (unUseCount < awardNum){
                        return "0";
                    } else {
                        int retInt = getFloatPreDot(unUseCount , awardNum);
                        if ("0".equals(ret)){
                            ret = retInt +"";
                        }else {
                            if (retInt < Integer.parseInt(ret)){
                                ret = retInt +"";
                            }
                        }

                    }
                }
            }
        }

        return ret;
    }

    private int getFloatPreDot(int unUseCount, Integer awardNum) {
        Float aFloat = new Float(unUseCount);
        Float bFloat = new Float(awardNum);

        float v = aFloat / bFloat;
        String vStr = v +"";
        String[] split = vStr.split(".");

        return Integer.parseInt(split[0]);
    }


    private Map<String, List<OrderSkuWriteoff>> getOrderAwardIdListMap(List<OrderSkuWriteoff> orderSkuWriteoffMapperList) {
        Map<String , List<OrderSkuWriteoff> > oidMap = new HashMap<>(4);

        for (OrderSkuWriteoff writeoff : orderSkuWriteoffMapperList) {
            if (oidMap.get(writeoff.getOrderAwardId())  == null){
                List<OrderSkuWriteoff> writeoffs = new ArrayList<>();
                writeoffs.add(writeoff);
                oidMap.put(writeoff.getOrderAwardId(),writeoffs);
            } else {
                oidMap.get(writeoff.getOrderAwardId()).add(writeoff);
            }
        }
        return oidMap;
    }


    private Map<String, List<OrderSkuWriteoff>> getItemIdListMap(List<OrderSkuWriteoff> orderSkuWriteoffMapperList) {
        Map<String , List<OrderSkuWriteoff> > oidMap = new HashMap<>(4);

        for (OrderSkuWriteoff writeoff : orderSkuWriteoffMapperList) {
            if (oidMap.get(writeoff.getAwardItemId())  == null){
                List<OrderSkuWriteoff> writeoffs = new ArrayList<>();
                writeoffs.add(writeoff);
                oidMap.put(writeoff.getAwardItemId(),writeoffs);
            } else {
                oidMap.get(writeoff.getAwardItemId()).add(writeoff);
            }
        }
        return oidMap;
    }

    private Map<String, List<OrderSkuWriteoff>> getOidListMap(List<OrderSkuWriteoff> orderSkuWriteoffMapperList) {
        Map<String , List<OrderSkuWriteoff> > oidMap = new HashMap<>(4);

        for (OrderSkuWriteoff writeoff : orderSkuWriteoffMapperList) {
            if (oidMap.get(writeoff.getOrderId())  == null){
                List<OrderSkuWriteoff> writeoffs = new ArrayList<>();
                writeoffs.add(writeoff);
                oidMap.put(writeoff.getOrderId(),writeoffs);
            } else {
                oidMap.get(writeoff.getOrderId()).add(writeoff);
            }
        }
        return oidMap;
    }

    private boolean refund(OrderSkuWriteoff writeoff1, String refundCount) {
        if (StringUtil.isEmpty(refundCount) || "0".equals(refundCount)){
            return false;
        }
        TcOrderRefundDto tcOrderRefundDto = new TcOrderRefundDto();
        tcOrderRefundDto.setOrderNo(writeoff1.getOrderId());
        tcOrderRefundDto.setAwardId(writeoff1.getAwardId());
        tcOrderRefundDto.setRefundCount(Integer.parseInt(refundCount));
        tcOrderRefundDto.setRefundOperationType(2);
        return tcOrderRefundService.orderRefund(tcOrderRefundDto);
    }

    private List<OrderSkuWriteoff> exitsUsedAwardByOrderId(String oid ) {
        return exitsUsedAwardByOrderId(oid,null);
    }

    private List<OrderSkuWriteoff> exitsUsedAwardByOrderId(String oid ,String orderAwardId) {
        return exitsUsedAwardByOrderId(oid,orderAwardId,1);
    }
    private List<OrderSkuWriteoff> exitsUsedAwardByOrderId(String oid ,String orderAwardId,Integer refundOperationType) {
        OrderSkuWriteoffDto orderSkuWriteoffDtoq = new OrderSkuWriteoffDto();
        orderSkuWriteoffDtoq.setStatus(refundOperationType);
        orderSkuWriteoffDtoq.setOrderId(oid);
        orderSkuWriteoffDtoq.setOrderAwardId(orderAwardId);
        List<OrderSkuWriteoff> orderSkuWriteoffMapperListq = orderSkuWriteoffMapper.findList(orderSkuWriteoffDtoq);


        return orderSkuWriteoffMapperListq;
    }

    @Override
    @Transactional
    public boolean orderSkuWriteoffUpdate(List<OrderSkuWriteoffDto> orderSkuWriteoffDtoss) {


        boolean flag = false;

        if (CollectionUtil.isEmpty(orderSkuWriteoffDtoss)){
            return flag;
        }

        for (OrderSkuWriteoffDto orderSkuWriteoffDtop : orderSkuWriteoffDtoss) {


            OrderSkuWriteoffDto orderSkuWriteoffDtoq1 = new OrderSkuWriteoffDto();
            orderSkuWriteoffDtoq1.setOrderId(orderSkuWriteoffDtop.getOrderId());
            orderSkuWriteoffDtoq1.setStatus(0);
            List<OrderSkuWriteoff> orderSkuWriteoffMapperList1 = orderSkuWriteoffMapper.findList(orderSkuWriteoffDtoq1);




            OrderSkuWriteoffDto orderSkuWriteoffDtoq = new OrderSkuWriteoffDto();
            orderSkuWriteoffDtoq.setOrderId(orderSkuWriteoffDtop.getOrderId());
            orderSkuWriteoffDtoq.setMemberAwardItemId(orderSkuWriteoffDtop.getMemberAwardItemId());
            orderSkuWriteoffDtoq.setStatus(0);
            List<OrderSkuWriteoff> orderSkuWriteoffMapperList = orderSkuWriteoffMapper.findList(orderSkuWriteoffDtoq);

            if (CollectionUtil.isEmpty(orderSkuWriteoffDtoss)){
                continue;
            }

            for (OrderSkuWriteoff writeoff :
                    orderSkuWriteoffMapperList) {
                writeoff.setStatus(1);

                if (orderSkuWriteoffDtop.getMemberAwardItemId().equals(writeoff.getMemberAwardItemId())
                        && orderSkuWriteoffDtop.getAwardId().equals(writeoff.getAwardId())
                && orderSkuWriteoffDtop.getAwardItemId().equals(writeoff.getAwardItemId())){
                    orderSkuWriteoffMapper.updateById(writeoff);

                    TcOrderMain tcOrderMain = tcOrderMainMapper.selectById(orderSkuWriteoffDtop.getOrderId());

                    try {
                        StatusEnum.canCharge(tcOrderMain);
                    } catch (Exception e) {
                        continue;
                    }



                    if (orderSkuWriteoffMapperList1.size() == 1) {

                        tcOrderMain.setOrderStatus(StatusEnum.CHARGE_ALL.getCode());

                    }else {
                        tcOrderMain.setOrderStatus(StatusEnum.CHARGE_PART.getCode());
                    }


                    tcOrderMainMapper.updateById(tcOrderMain);
                }



            }

        }




//        tcOrderSkuMapper.findList()

//        tcOrderRefundService.orderRefund()


        return flag;



    }

    @Override
    public Integer getOrderCount(TcOrderMainDto eo) {
        int ret = 0;
//        List<TcOrderMainVO> all = findAll(eo);

        checkPcwx(eo);
        List<TcOrderMainVO> all = tcOrderMainMapper.findList(eo);

        if ( null != all){
            ret = all.size();
        }
        return ret;
    }



    /*
    //根据活动商品list去判断商品对应的库存是否有效
     */
    private List<AcCouponDetailDto> getSkus(TcOrderPlaceRequestDto dto, List<SkuInfo> skuInfos) {
        List<AcCouponDetailDto> acCouponDetailDtos = new ArrayList<>();
        for (SkuInfo skuInfo: skuInfos) {
            AcCouponDetailDto detail = null;
            try {
                //todo 根据商品id和类型去查询商品信息
//                detail = acCouponService.detail(skuInfo.getSkuId());
                detail = new AcCouponDetailDto();
                detail.setId(skuInfos.get(0).getSkuId());
                detail.setMerchantName("test3");
                detail.setName("test");
                detail.setExpectIssueNum(100);
                detail.setFaceValue(new BigDecimal("0.01"));
                detail.setFullAmount(new BigDecimal("10"));
                detail.setUseDescription("满10减1");
            } catch (Exception e) {
                logger.error("TcOrderMainServiceImpl.orderPlace：查询商品信息异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "查询商品信息异常"));
            }
            if(null != detail) {
                acCouponDetailDtos.add(detail);
            }
        }

        if(CollectionUtil.isEmpty(acCouponDetailDtos)) {
            throw new ApplicationException(ResultEnum.AWARD_NOT_FOUND);
        }

        skuInfos.forEach(skuInfo -> {
            acCouponDetailDtos.forEach(acCouponDetailDto -> {
                if(acCouponDetailDto.getId().equals(skuInfo.getSkuId())){//相同的id进行库存判断
                    if(skuInfo.getSkuType().equals(1)){
                        if(skuInfo.getSkuCount() >= acCouponDetailDto.getExpectIssueNum()) {
                            throw new ApplicationException(ResultEnum.UNDERSTOCK);
                        }
                    }else {
                        //todo 根据组合商品里面的商品库存最少的来判断

                    }
                }
            });
        });
        return acCouponDetailDtos;
    }


    /*
//调用兑换活动接口进行校验是否有效
     */
    private List<Activity> getActivitiesAndcheckActivityEffectiveness(TcOrderPlaceRequestDto dto, List<String> activityIds) {
        List<Activity> activities = new ArrayList<>();
        activityIds.forEach(ac->{
            Activity activity = null;
            try {
//                activity = acActivityCouponService.checkActivityEffectiveness(ac);
                activity = new Activity();
                activity.setId(ac);
                activity.setName("test");
                activity.setImageUrl("//deepexi-moby.oss-cn-shenzhen.aliyuncs.com/10-1557197670213.jpg");
            } catch (Exception e) {
                logger.error("TcOrderMainServiceImpl.orderPlace：查询活动信息异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
                throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "查询活动信息异常"));
            }
            activities.add(activity);
        });

        if(CollectionUtil.isEmpty(activities)) {
            throw new ApplicationException(ResultEnum.AWARD_NOT_FOUND);
        }
        return activities;
    }


    /*
//查询会员信息
     */
    private WmMember getWmMember() {
        WmMember member = null;
        try {
            member = wmMemberService.getLoginInfo();
//            member = new WmMember();
//            member.setId("3f94c204dda30413c9bd55e07741317a");
//            member.setName("test-name");
            if (member == null) {
                logger.error("TcOrderMainServiceImpl.orderPlace：查询会员信息为null,token为[{}]", appRuntimeEnv.getToken());
                throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "获取会员信息失败"));
            }
        } catch (Exception e) {
            logger.error("TcOrderMainServiceImpl.orderPlace：查询会员信息异常,异常原因为：{}", ExceptionUtils.getStackTrace(e));
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "获取会员信息失败"));
        }
        return member;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TcOrderPayVO orderPay(TcOrderPayDto dto) {
        TcOrderMain tcOrderMain = tcOrderMainMapper.selectById(dto.getOrderId());
        orderPayCheck(dto, tcOrderMain);

        TcOrderPay tcOrderPay = orderPayReadyAndGet(dto);

        TcOrderPayVO vo = new TcOrderPayVO();
        vo.setTenantId(PayServiceConfig.getTenantId());

        //如果为0的话，直接数据更改为成功，并且返回给前端数据
        if(tcOrderMain.getAmount().compareTo(BigDecimal.ZERO)==0){
            tcOrderPayService.orderPayOperation(tcOrderPay.getTransNo(),new Date(),StatusEnum.SUCCESS.getCode(),null);
            vo.setApplyDeductionAmount(BigDecimal.ZERO);
            vo.setOrderNo(tcOrderPay.getTransNo());
            return vo;
        }

        TranAppsRequest tranAppsRequest = new TranAppsRequest();
        payServiceImpI.initPayInfo(tranAppsRequest,dto.getPayType());
        tranAppsRequest.setOrderId(tcOrderPay.getTransNo());
        tranAppsRequest.setApplyDeductionAmount(String.valueOf(tcOrderMain.getAmount()));
        tranAppsRequest.setTradingSummary("联通智能营销云调用支付中心");
        tranAppsRequest.setSignType(SignConstant.MD5);
//        tranAppsRequest.setTenantId(appRuntimeEnv.getTenantId());//// TODO: 2019/5/22  
        tranAppsRequest.setTenantId(PayServiceConfig.getTenantId());
        try {
            TranAppsResponse response = payServiceImpI.send(PayURLEnum.TRAN_APPS_PAY, tranAppsRequest, new TranAppsResponse());
            //存在订单号证明支付中心下单成功了
            if(StringUtil.isNotEmpty(response.getTranNo())){
                BeanUtils.copyProperties(response,vo);
                vo.setOrderNo(response.getOrderId());
                vo.setApplyDeductionAmount(tcOrderMain.getAmount());

                tcOrderPay.setPayCenterTransNo(response.getTranNo());
                tcOrderPayMapper.updateById(tcOrderPay);
            }
        } catch (Exception e) {
            logger.error("TcOrderMainServiceImpl.orderPay：调用支付中心异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "解析支付中心数据异常"));
        }

        return vo;
    }

    private TcOrderPay orderPayReadyAndGet(TcOrderPayDto dto) {
        TcOrderPay tcOrderPay = new TcOrderPay();
        tcOrderPay.setOrderId(dto.getOrderId());
        tcOrderPay.setTransNo(generateId(IdRuleEnum.PAY_RANDOM));
        tcOrderPay.setId(tcOrderPay.getTransNo());
        tcOrderPay.setPayType(dto.getPayType());
        tcOrderPayMapper.insert(tcOrderPay);
        return tcOrderPay;
    }


    private void orderPayCheck(TcOrderPayDto dto,TcOrderMain tcOrderMain) {
        // TODO: 2019/10/15 test
//        Date parse = DateUtils.parse(DateUtils.getTimeByInterval(DateUtils.toDateText(DateUtils.now(), DateUtils.DEFAULT_DATE_TIME_FORMAT), "-" + closeTime), DateUtils.DEFAULT_DATE_TIME_FORMAT);
//        if (tcOrderMain.getCreatedAt().before(parse)){
//            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "不能支付"));
//        }

//        if(tcOrderMain == null)throw new ApplicationException(ResultEnum.PARAMETER_ERROR);
//
//        if(StatusEnum.SUCCESS.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.PAY_SUCCESS);
//        if(!StatusEnum.PAY_PENDING.getCode().equals(tcOrderMain.getOrderStatus())) throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "订单状态非待付款不能支付！"));
        StatusEnum.canPay(tcOrderMain);
    }

    @Override
    public void closeOrder() {
        TcOrderMainDto dto = new TcOrderMainDto();
        dto.setCloseTime(closeTime);
        dto.setOrderStatus(StatusEnum.PAY_PENDING.getCode());
        dto.setOperatingStatus(StatusEnum.PAY_PENDING.getCode());
        dto.setOrderBy("tm.created_at ASC");
        PageHelper.startPage(1, 2000);
        List<TcOrderMainVO> orderMains = findAll(dto);
        logger.info("定时任务执行需要关闭取消的订单为：{}", JSON.toJSONString(orderMains));

        if(CollectionUtil.isNotEmpty(orderMains)) {
            //更为为处理中的状态，然后再进行处理
            TcOrderMainDto pendingDto = new TcOrderMainDto();
            pendingDto.setOperatingStatus(StatusEnum.CLOSE_PENDING.getCode());
            pendingDto.setIds(orderMains.stream().map(TcOrderMain::getId).collect(Collectors.toList()));
            tcOrderMainMapper.updateByOrderIds(pendingDto);

            orderMains.forEach(tcOrderMain -> {
                this.closeOrderOperation(tcOrderMain);
            });
        }
    }

    @Override
    public Boolean closeOrderOperation(TcOrderMainVO vo){
        logger.info("需要关闭取消的订单ID为：{}",vo.getId());
        TcOrderMain tcOrderMain = new TcOrderMain();
        tcOrderMain.setId(vo.getId());
        try {
            if(StringUtil.isEmpty(vo.getOrderNo())){
                TcOrderMainDto dto = new TcOrderMainDto();
                dto.setId(vo.getId());
                List<TcOrderMainVO> orderMains = findAll(dto);
                if(CollectionUtil.isEmpty(orderMains)) {
                    return false;
                }
                vo = orderMains.get(0);
                if(StatusEnum.SUCCESS.getCode().equals(vo.getOrderStatus())) {
                    throw new ApplicationException(ResultEnum.PAY_SUCCESS);
                }
                if(StatusEnum.FAIL.getCode().equals(vo.getOrderStatus())) {
                    return true;
                }
            }

            //进行判断是否有支付成功了的
//            TcOrderPayDto tcOrderPay = new TcOrderPayDto();
//            tcOrderPay.setOrderId(vo.getId());
//            List<TcOrderPay> tcOrderPays = tcOrderPayMapper.findList(tcOrderPay);
//
//            for (TcOrderPay pay : tcOrderPays) {
//                TranActionRequest tranActionRequest = new TranActionRequest();
//                tranActionRequest.setOrderId(pay.getOrderId());
//                if(StringUtil.isNotEmpty(pay.getPayCenterTransNo())) tranActionRequest.setTranNo(pay.getPayCenterTransNo());
//                tranActionRequest.setDoMain(PayServiceConfig.getDoMain());
//                tranActionRequest.setIp(PayServiceConfig.getIp());
//                tranActionRequest.setTenantId(pay.getTenantCode());
//
//                try {
//                    TranActionResponse response = payServiceImpI.send(PayURLEnum.TRAN_ACTION, tranActionRequest, new TranActionResponse());
//                    if(StringUtil.isNotEmpty(response.getStatus())){
//                        if(PayStatusEnum.SUCCESS.getCode().equals(response.getStatus())){
//                            int updatePayNum = tcOrderPayService.orderPayOperation(pay.getTransNo(), null, StatusEnum.SUCCESS.getCode(),pay);
//                            if(updatePayNum > 0) throw new ApplicationException(ResultEnum.PAY_SUCCESS);
//                        }
//                    }
//                } catch (Exception e) {
//                    logger.error("TcOrderMainServiceImpl.closeOrderOperation：调用支付中心异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
//                    //回滚操作状态，可以下次再操作
//                    tcOrderMain.setOperatingStatus(StatusEnum.PAY_PENDING.getCode());
//                    tcOrderMainMapper.updateById(tcOrderMain);
//                    return false;
//                }
//            }

            String memberId = vo.getMemberId();
            String expendIntegral = vo.getExpendIntegral();
            //todo 释放积分

            String expendCouponId = vo.getExpendCouponId();
            //todo 释放优惠券

//            Integer count = vo.getCount();
//            String awardId = vo.getAwardId();
            //todo 释放该商品的库存



            TcOrderSkuDto tcOrderSkuDto = new TcOrderSkuDto();
            tcOrderSkuDto.setOrderId(tcOrderMain.getId());
            List<TcOrderSku> list = tcOrderSkuMapper.findList(tcOrderSkuDto);
            if (null != list){
                for (TcOrderSku sku :
                        list) {
                    productService.releaseFrozen(sku.getProductId(),sku.getCount());
//                    updateMemberAwardItemRelation(null,tcOrderMain.getId(),"", 66/*UseStatusEnum.PENDING_USE.getState()*/);

                }
            }

            //关闭订单
            tcOrderMain.setOrderStatus(StatusEnum.FAIL.getCode());
            tcOrderMain.setOperatingStatus(StatusEnum.PAY_PENDING.getCode());
            tcOrderMainMapper.updateById(tcOrderMain);

            //关闭子订单
            TcOrderChild tcOrderChild = new TcOrderChild();
            tcOrderChild.setChildStatus(StatusEnum.FAIL.getCode());
            tcOrderChild.setOrderId(vo.getId());
            tcOrderChildMapper.updateByOrderId(tcOrderChild);
        } catch (Exception e) {
            logger.error("关闭订单出错，错误的异常为：{},订单ID为：{}",ExceptionUtils.getStackTrace(e),vo.getId());
            //回滚操作状态，可以下次再操作
            tcOrderMain.setOperatingStatus(StatusEnum.PAY_PENDING.getCode());
            tcOrderMainMapper.updateById(tcOrderMain);
            return false;
        }
        return true;
    }

}
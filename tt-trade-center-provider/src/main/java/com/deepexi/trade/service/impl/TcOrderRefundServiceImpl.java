package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.deepexi.mq.api.IMQService;
import com.deepexi.mq.domain.MessageResponse;
import com.deepexi.pay.constants.SignConstant;
import com.deepexi.trade.domain.dto.*;
import com.deepexi.trade.domain.dto.pay.RefunsRequest;
import com.deepexi.trade.domain.eo.*;
import com.deepexi.trade.domain.vo.TcOrderMainVO;
import com.deepexi.trade.domain.vo.TcOrderRefundVO;
import com.deepexi.trade.domain.vo.orderdetail.OrderRefundInfo;
import com.deepexi.trade.domain.vo.pay.RefunsResponse;
import com.deepexi.trade.domain.vo.pay.TcCallBackResponse;
import com.deepexi.trade.enums.*;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.*;
import com.deepexi.trade.service.TcOrderMainService;
import com.deepexi.trade.service.TcOrderRefundService;
import com.deepexi.trade.service.third.GenerateIdService;
import com.deepexi.trade.service.third.ProductService;
import com.deepexi.trade.service.third.WmWechatMemberInfoService;
import com.deepexi.trade.service.third.domain.IdRuleEnum;
import com.deepexi.trade.service.third.domain.UseStatusEnum;
import com.deepexi.trade.service.third.domain.WmWechatMemberInfoVO;
import com.deepexi.trade.utils.DingdingBot;
import com.deepexi.util.*;
import com.deepexi.util.config.Payload;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.wechat.domain.dto.TemplateMessageCommonDTO;
import com.deepexi.wechat.service.WechatTemplateMessageService;
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


@SuppressWarnings("AliControlFlowStatementWithoutBraces")
@Component
@Service(version = "${demo.service.version}")
public class TcOrderRefundServiceImpl implements TcOrderRefundService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderRefundServiceImpl.class);


    @Autowired
    private TcOrderMainService tcOrderMainService;

    @Autowired
    private TcOrderRefundMapper tcOrderRefundMapper;

    @Autowired
    private TcOrderMainMapper tcOrderMainMapper;

    @Autowired
    private TcOrderRefundMappingMapper tcOrderRefundMappingMapper;

    @Autowired
    private TcOrderRefundWaterMapper tcOrderRefundWaterMapper;

    @Autowired
    private TcOrderSkuMapper tcOrderSkuMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Autowired
    private TcOrderChildMapper tcOrderChildMapper;

    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private WmWechatMemberInfoService wmWechatMemberInfoService;
//    @Autowired
    @Reference(version = "${demo.service.version}", check = false)
    private WechatTemplateMessageService wechatTemplateMessageService;

    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private ProductService productService;

    @Autowired
    private IMQService mqService;

    @Value("${deepexi.mq.tcOrderRefundWater.topic}")
    private String tcOrderRefundWaterTopic;

    @Value("${deepexi.mq.tcOrderRefundWater.routingKey}")
    private String tcOrderRefundWaterRoutingKey;

    @Autowired
    private PayServiceImpI payServiceImpI;

    @Autowired
    private GenerateIdService generateIdService;

    final String lockName = "table-order-lock-";
    @Value("${spring.application.domainName}")
    private String domainName;

    @Override
    public PageBean findPage(TcOrderRefundDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderRefund> list = tcOrderRefundMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderRefund> findAll(TcOrderRefundDto eo) {
        List<TcOrderRefund> list = tcOrderRefundMapper.findList(eo);
        return list;
    }
    @Override
    public TcOrderRefund detail(String pk) {
        return tcOrderRefundMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderRefundDto eo) {
        int result = tcOrderRefundMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefund.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderRefundDto eo) {
        eo.setId(pk);
        int result = tcOrderRefundMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefund.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderRefundMapper.deleteByIds(pk);
        return result > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean orderRefund(TcOrderRefundDto dto) {
        List<TcOrderMainVO> mainVOS = getTcOrderMainVOS(dto);
        //noinspection AliControlFlowStatementWithoutBraces
        if(CollectionUtil.isEmpty(mainVOS)) return false;

        //主订单号只有一笔数据，并不是用子订单号来查询
        TcOrderMainVO vo = mainVOS.get(0);

        StatusEnum.canRefund(vo);

        if(vo.getAmount().compareTo(BigDecimal.ZERO)==0){
            //todo 如果是0元该怎么去处理用户的商品
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR,"0元无法进行退款！"));
        }

        //noinspection AliControlFlowStatementWithoutBraces
        if(dto.getRefundCount() > vo.getCount())return false;

        if (dto.getRefundOperationType() == null || dto.getRefundOperationType() != 2){
            TcOrderRefundDto canRefund = tcOrderMainService.getCanRefund(vo.getId());

            dto = canRefund;
        }

        if (dto == null || dto.getRefundCount() == null || dto.getRefundCount() == 0){
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR,"已使用无法进行退款！"));
        }

        //目前的每件的数据都是一样的，所以(总额/总件数)*可退件数 = 退款金额，这里的精度保留2位，并且四舍五入
        BigDecimal refundAmount = vo.getAmount().divide(BigDecimal.valueOf(vo.getCount()),2,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(dto.getRefundCount()));

        dto.setOrderId(vo.getId());
        List<TcOrderRefund> tcOrderRefunds = tcOrderRefundMapper.findList(dto);

        TcOrderRefund tcOrderRefund = new TcOrderRefund();
        if(CollectionUtil.isNotEmpty(tcOrderRefunds)){
            tcOrderRefund = tcOrderRefunds.get(0);
            //noinspection AliControlFlowStatementWithoutBraces
            if(StatusEnum.REFUND_SUCCESS.getCode().equals(tcOrderRefund.getRefundStatus()) || StatusEnum.REFUND_PENDING.getCode().equals(tcOrderRefund.getRefundStatus())) throw new ApplicationException(ResultEnum.REFUND_SUCCESS);
        }else {
            String refundId = generateId(IdRuleEnum.REUND_RANDOM);
            tcOrderRefund.setId(refundId);
            tcOrderRefund.setOrderId(vo.getId());
            tcOrderRefund.setRefundNo(refundId);
            tcOrderRefund.setRefundAmount(refundAmount);
            tcOrderRefund.setCount(dto.getRefundCount());
            tcOrderRefund.setAwardId(dto.getAwardId());
            tcOrderRefund.setOrderAwardId(dto.getOrderAwardId());
            tcOrderRefund.setRefundOperationType(dto.getRefundOperationType());
            tcOrderRefundMapper.insert(tcOrderRefund);

            //发起
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.REQUEST_OPERATION.getCode(),"1");

            //审核
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.PLATFORM_AUDIT_OPERATION.getCode(),"1");
        }
        //支付中心不需要退款流水号进行退款，所以注释掉
        /*TcOrderRefundMapping tcOrderRefundMapping = new TcOrderRefundMapping();
        tcOrderRefundMapping.setRefundOrderId(tcOrderRefund.getId());
        tcOrderRefundMapping.setRefundTransNo(generateIdService.getStandardOrderId(lockName+ IdRuleEnum.REUND_RANDOM.getCode(),1000L,IdRuleEnum.REUND_RANDOM));
        tcOrderRefundMappingMapper.insert(tcOrderRefundMapping);*/

        RefunsRequest refunsRequest = new RefunsRequest();
        payServiceImpI.initPayInfo(refunsRequest,vo.getPayType());
        //这里根据文档应该是传支付订单号，用于支付中心找回对应的支付订单信息
        refunsRequest.setOrderId(vo.getOrderPayNo());
        refunsRequest.setSignType(SignConstant.MD5);
        refunsRequest.setApplyDeductionAmount(refundAmount);
        try {

            RefunsResponse refunsResponse = payServiceImpI.send(PayURLEnum.REFUNS, refunsRequest, new RefunsResponse());
//            //todo 根据返回状态是否去 冻结组合商品包或者单商品
//
//
            if(PayStatusEnum.REFUND_APPLY_SUCCESS.getCode().equals(refunsResponse.getStatus())){
                tcOrderRefund.setRefundStatus(StatusEnum.REFUND_PENDING.getCode());
                //tcOrderRefund.setRefundTransNo(tcOrderRefundMapping.getRefundTransNo());
//                if(StringUtil.isNotEmpty(dto.getPayTime()))tcOrderRefund.setRefundTime(DateUtils.getDate(dto.getPayTime(),DateUtils.DEFAULT_DATE_TIME_FORMAT));
                int refundNum = tcOrderRefundMapper.updateById(tcOrderRefund);

            /*tcOrderRefundMapping.setRefundStatus(StatusEnum.REFUND_PENDING.getCode());
            int refundMappingNum = tcOrderRefundMappingMapper.updateById(tcOrderRefundMapping);*/

                //退款中
                this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.CHANNEL_ACCEPT.getCode(),null);

                updateOrderStatus(vo,vo.getId(),StatusEnum.REFUND_PENDING.getCode());
                if(refundNum > 0  ) {

                    TcOrderSkuDto tcOrderSkuDto = new TcOrderSkuDto();
                    tcOrderSkuDto.setOrderId(vo.getId());
                    List<TcOrderSku> list = tcOrderSkuMapper.findList(tcOrderSkuDto);
                    if (null != list){
                        for (TcOrderSku sku :list) {
                            try {
                                tcOrderMainService.updateMemberAwardItemRelation(null,vo.getId(),tcOrderRefund.getOrderAwardId(), UseStatusEnum.REFUNDDING.getState() /*UseStatusEnum.PENDING_USE.getState()*/);
                            } catch (Exception e) {
                                e.printStackTrace();
                                DingdingBot.sendMsg(e.getMessage());
                            }

                        }
                    }
                    return true;
                }

            }
        } catch (Exception e) {
            logger.error("TcOrderMainServiceImpl.orderPay：调用支付中心异常,异常的原因为：{}", ExceptionUtils.getStackTrace(e));

            //发起流水数据清除
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.REQUEST_OPERATION.getCode(),"2");

            //审核流水数据清除
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.PLATFORM_AUDIT_OPERATION.getCode(),"2");

            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "解析支付中心数据异常"));
        }
        return false;
    }

    private String generateId(IdRuleEnum mainRandom) {
        return generateIdService.getStandardOrderId(lockName + mainRandom.getCode(), 1000L, mainRandom);

//        return IdGenerator.getUuId();
    }
    private void updateOrderStatus(TcOrderMainVO vo,String orderId,Integer status) {
        TcOrderMain tcOrderMain = new TcOrderMain();
        tcOrderMain.setOrderStatus(status);
        tcOrderMain.setId(orderId);
        int rets = tcOrderMainMapper.updateById(tcOrderMain);
        if (rets < 1){
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "数据异常"));
        }


        TcOrderChild tcOrderChild = new TcOrderChild();
        tcOrderChild.setOrderId(orderId);
        tcOrderChild.setChildStatus(status);
        int retc = tcOrderChildMapper.updateByOrderId(tcOrderChild);
        if (retc < 1){
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "数据异常"));
        }


    }

    private List<TcOrderMainVO> getTcOrderMainVOS(TcOrderRefundDto dto) {
        TcOrderMainDto mainDto = new TcOrderMainDto();
        mainDto.setOrderNo(dto.getOrderNo());
        mainDto.setAwardId(dto.getAwardId());
        return tcOrderMainService.findAll(mainDto);
    }

    /**
     * 异步如流出表
     * @param refundOrderId 退款表关联的id
     * @param processType 订单流水状态: 1、发起时间 2、平台审核时间 3、渠道受理时间 4、到账时间
     * @param optType  操作类型 1、create 2、delete
     */
    private void sendTcOrderRefundWater(String refundOrderId,Integer processType,String optType ){
        TcOrderRefundWaterDto dto = new TcOrderRefundWaterDto();
        dto.setRefundOrderId(refundOrderId);
        dto.setProcessType(processType);
        dto.setOptType(StringUtil.isEmpty(optType)?"1":optType);
        MessageResponse sendResp = mqService.createProducer().sendMessage(tcOrderRefundWaterTopic, tcOrderRefundWaterRoutingKey, JSON.toJSONString(dto));
        logger.info("TcOrderRefundWaterDto====>>>sendReq:{},sendResp",JSON.toJSONString(dto), JSON.toJSONString(sendResp));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TcCallBackResponse refundCallBack(TcCallBackDto dto) {
        //支付中心不需要退款流水号进行退款，所以注释掉
        /*TcOrderRefundMappingDto mappingDto = new TcOrderRefundMappingDto();
        mappingDto.setRefundTransNo(dto.getOrderId());
        List<TcOrderRefundMapping> orderRefundMappings = tcOrderRefundMappingMapper.findList(mappingDto);*/
        TcOrderMainDto mainDto = new TcOrderMainDto();
        mainDto.setOrderPayNo(dto.getOrderId());
        List<TcOrderMainVO> mainVOS = tcOrderMainService.findAll(mainDto);
        //noinspection AliControlFlowStatementWithoutBraces
        if(CollectionUtil.isEmpty(mainVOS))return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE,ResultEnum.ORDER_NOT_FOUND.getMsg()));

        TcOrderMainVO mainVO = mainVOS.get(0);

        StatusEnum.canRefundCallBack(mainVO);

        TcOrderRefundDto refundDto = new TcOrderRefundDto();
        refundDto.setOrderId(mainVO.getId());
        List<TcOrderRefund> refundList = tcOrderRefundMapper.findList(refundDto);
        //noinspection AliControlFlowStatementWithoutBraces
        if(CollectionUtil.isEmpty(refundList))return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE,"不存在该笔退款订单"));

        //支付中心不需要退款流水号进行退款，所以注释掉
        /*mappingDto = new TcOrderRefundMappingDto();
        mappingDto.setRefundOrderId(tcOrderRefund.getId());
        List<TcOrderRefundMapping> mappings = tcOrderRefundMappingMapper.findList(mappingDto);
        List<TcOrderRefundMapping> successMappings = mappings.stream().filter(m -> StatusEnum.SUCCESS.getCode().equals(m.getRefundStatus()) && !m.getId().equals(tcOrderRefundMapping.getId())).collect(Collectors.toList());
        if(CollectionUtil.isNotEmpty(successMappings)) return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE,"已存在一笔退款成功的订单"));*/

        //只有一条数据
        TcOrderRefund tcOrderRefund = refundList.get(0);
        //noinspection AliControlFlowStatementWithoutBraces
        if(StatusEnum.REFUND_SUCCESS.getCode().equals(tcOrderRefund.getRefundStatus())) return new TcCallBackResponse(CallBackEnum.SUCCESS);

        if(PayStatusEnum.REFUND.getCode().equals(dto.getStatus())){
            tcOrderRefund.setRefundStatus(StatusEnum.REFUND_SUCCESS.getCode());
            //tcOrderRefund.setRefundTransNo(tcOrderRefundMapping.getRefundTransNo());
            //noinspection AliControlFlowStatementWithoutBraces
            if(StringUtil.isNotEmpty(dto.getPayTime()))tcOrderRefund.setRefundTime(DateUtils.getDate(dto.getPayTime(),DateUtils.DEFAULT_DATE_TIME_FORMAT));
            int refundNum = tcOrderRefundMapper.updateById(tcOrderRefund);

            /*tcOrderRefundMapping.setRefundStatus(StatusEnum.SUCCESS.getCode());
            int refundMappingNum = tcOrderRefundMappingMapper.updateById(tcOrderRefundMapping);*/

            //退款成功
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.INTO_ACCOUNT_OPERATION.getCode(),null);


            updateOrderStatus(mainVO,mainVO.getId(),StatusEnum.REFUND_SUCCESS.getCode());
            //todo 通知商品更改商品状态为退款作废


            TcOrderSkuDto tcOrderSkuDto = new TcOrderSkuDto();
            tcOrderSkuDto.setOrderId(mainVO.getId());
            List<TcOrderSku> list = tcOrderSkuMapper.findList(tcOrderSkuDto);
            if (null != list){
                for (TcOrderSku sku :list) {
                    try {
                        tcOrderMainService.updateMemberAwardItemRelation(null,mainVO.getId(),tcOrderRefund.getOrderAwardId(), UseStatusEnum.REFUND_FAIL.getState()/*UseStatusEnum.PENDING_USE.getState()*/);
                    } catch (Exception e) {
                        e.printStackTrace();
                        DingdingBot.sendMsg(e.getMessage());
                    }
                    try {
                        productService.addRemainStock(sku.getProductId(),tcOrderRefund.getCount());
                    } catch (Exception e) {
                        e.printStackTrace();
                        DingdingBot.sendMsg(e.getMessage());
                    }
                }
            }

            try {
                templateMessageCommonSend(mainVO, tcOrderRefund);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //noinspection AliControlFlowStatementWithoutBraces
            if(refundNum > 0) return new TcCallBackResponse(CallBackEnum.SUCCESS);

        }/*else if(PayStatusEnum.REFUND_APPLY_SUCCESS.getCode().equals(dto.getStatus())){
            tcOrderRefund.setRefundStatus(StatusEnum.REFUND_PENDING.getCode());
            //tcOrderRefund.setRefundTransNo(tcOrderRefundMapping.getRefundTransNo());
            if(StringUtil.isNotEmpty(dto.getPayTime()))tcOrderRefund.setRefundTime(DateUtils.getDate(dto.getPayTime(),DateUtils.DEFAULT_DATE_TIME_FORMAT));
            int refundNum = tcOrderRefundMapper.updateById(tcOrderRefund);

            *//*tcOrderRefundMapping.setRefundStatus(StatusEnum.REFUND_PENDING.getCode());
            int refundMappingNum = tcOrderRefundMappingMapper.updateById(tcOrderRefundMapping);*//*

            //退款中
            this.sendTcOrderRefundWater(tcOrderRefund.getId(), ProcessTypeEnum.CHANNEL_ACCEPT.getCode(),null);

            if(refundNum > 0  ) return new TcCallBackResponse(CallBackEnum.SUCCESS);

        }*/else if (PayStatusEnum.REFUND_FAILURE.getCode().equals(dto.getStatus())){
            tcOrderRefund.setRefundStatus(StatusEnum.REFUND_FAILURE.getCode());
            int refundNum = tcOrderRefundMapper.updateById(tcOrderRefund);

            //noinspection AliControlFlowStatementWithoutBraces
            if(refundNum > 0  ) return new TcCallBackResponse(CallBackEnum.SUCCESS);
        }
        return new TcCallBackResponse(CallBackEnum.FAILURE);
    }

    private void templateMessageCommonSend(TcOrderMainVO mainVO, TcOrderRefund tcOrderRefund) {
        try {

            TemplateMessageCommonDTO dto = new TemplateMessageCommonDTO();




            appRuntimeEnv.ensureTenantId(mainVO.getTenantCode());


            // 查询会员发送消息的公众号（按关注及分流设置的顺序）
            WmWechatMemberInfoVO wmWechatMemberInfo = wmWechatMemberInfoService.getInfoVOWechatNumberIdBypass(mainVO.getMemberId());
            if (null == wmWechatMemberInfo) {
                DingdingBot.sendMsg("MessageServiceImpl.couponExpired：会员[" + mainVO.getMemberId() + "]查询不到关注公众号，无法发送模板消息");
                return;
            }

//            TemplateMessageCommonDTO templateMessageCommonDTO = new TemplateMessageCommonDTO();
//            templateMessageCommonDTO.setTemplateId("OPENTM401747701");
//            templateMessageCommonDTO.setOpenId(wechatNumberIdBypass.getOpenId());
//            templateMessageCommonDTO.setWeChatAccount(wechatNumberIdBypass.getWechatNumberId());
//            templateMessageCommonDTO.setUrl("http://"+domainName+"/cdp-wy-trade-center/api/v1/tcOrderMains/" +mainVO.getId()+
//                    "?tenantId="+mainVO.getTenantCode());
            dto.setTemplateId("OPENTM401747701");
            dto.setOpenId(wmWechatMemberInfo.getOpenId());
            dto.setWeChatAccount(wmWechatMemberInfo.getWechatNumberId());
            dto.setUrl("/woyou-member-mobile/index.html#/order/detail?id=" +mainVO.getId()+ "&tenantId=" + appRuntimeEnv.getTenantId() + "&appId=" + wmWechatMemberInfo.getAppId());
            dto.setTemplateId("OPENTM401747701");

            Map<String, String> sendMap = new HashMap<>(8);

//            sendMap.put("first","亲，您有一笔退款成功，请留意。");
//            sendMap.put("keyword1",tcOrderRefund.getRefundAmount()+"元");
//            sendMap.put("keyword2",tcOrderRefund.getId());
//            sendMap.put("remark","查看退款详情");


            String awardName = "copoun";
            try {
                awardName = mainVO.getTcOrderChildVOS().get(0).getTcOrderSkus().get(0).getAwardName();
            } catch (Exception e) {
                e.printStackTrace();
            }
            sendMap.put("first","您有一笔退款，请留意。");
            sendMap.put("keyword1",tcOrderRefund.getRefundAmount()+"元");
            sendMap.put("keyword2",awardName);
            sendMap.put("keyword3",mainVO.getId());
            sendMap.put("remark","查看退款详情");



            dto.setSendMap(sendMap);



            wechatTemplateMessageService.templateMessageCommonSend(dto);



        } catch (Exception e) {
            e.printStackTrace();
            DingdingBot.sendMsg(e.getMessage());
        }
    }









    @Override
    @Transactional(rollbackFor = Exception.class)
    public Payload getRefundInfo(String orderId) {

        return new Payload(tcOrderMainService.detail(orderId));
    }





//    {"$schema":"http://json-schema.org/draft-04/schema#","type":"object","properties":{"payload":{"type":"object","properties":{"refundAmount":{"type":"number","description":"退款金额"},"orderNo":{"type":"string","description":"主订单号"},"awardId":{"type":"string","description":"商品id"},"awardType":{"type":"number","description":"商品类型 1、单商品  2、组合优惠商品"},"refundCount":{"type":"number","description":"退款件数"},"refundType":{"type":"number","description":"退款方式：1、微信 2、支付宝 3、云闪付"}},"required":[]},"code":{"type":"string"},"msg":{"type":"string"}}}
    /*@Override
    @Transactional(rollbackFor = Exception.class)
    public Payload getRefundInfo(String orderId) {
//        return null;
        TcOrderMainDto mainDto = new TcOrderMainDto();
        mainDto.setId(orderId);
        List<TcOrderMainVO> mainVOS = tcOrderMainService.findAll(mainDto);
        if(CollectionUtil.isEmpty(mainVOS)) return new Payload(null,ResultEnum.ORDER_NOT_FOUND.getCode(),ResultEnum.ORDER_NOT_FOUND.getMsg());
        TcOrderMainVO mainVO = mainVOS.get(0);
//        if(!StatusEnum.SUCCESS.getCode().equals(mainVO.getOrderStatus()))return new Payload(null,ResultEnum.PAY_NOT_SUCCESS.getCode(),ResultEnum.PAY_NOT_SUCCESS.getMsg());

//        if(Integer.valueOf(1).equals(mainVO.getAwardStatus()))return new Payload(null,ResultEnum.AWARD_OVERDUE.getCode(),ResultEnum.AWARD_OVERDUE.getMsg());
//        if(Integer.valueOf(2).equals(mainVO.getAwardStatus()))return new Payload(null,ResultEnum.AWARD_ALL_USE.getCode(),ResultEnum.AWARD_ALL_USE.getMsg());
        //todo 判断是否过期

        //已过期
//        Boolean lastFlag = false;
//        if(lastFlag){
//            TcOrderSku sku = new TcOrderSku();
//            sku.setId(mainVO.getSkuId());
//            sku.setAwardStatus(1);
//            tcOrderSkuMapper.updateById(sku);
//            return new Payload(null,ResultEnum.AWARD_OVERDUE.getCode(),ResultEnum.AWARD_OVERDUE.getMsg());
//        }

        Integer refundCount = mainVO.getCount();
        //todo 判断组合商品或者单商品里面是否有使用过了的，如果有的则减少退款件数
        //使用订单号和奖品id去查询，模拟返回组合List
        List<Map<String,String>> list = new ArrayList<>();
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("isUse","3");
        HashMap<String, String> resultMap1 = new HashMap<>();
        resultMap1.put("isUse","1");
        list.add(resultMap);
        list.add(resultMap1);
        Integer isUseNum = 0;
        for (Map<String,String> map: list) {
            String isUse = map.get("isUse");
            if("3".equals(isUse)){//已使用
                isUseNum ++;
            }
        }

        if(refundCount - isUseNum <=0 ) {
//            TcOrderSku sku = new TcOrderSku();
//            sku.setId(mainVO.getSkuId());
//            sku.setAwardStatus(2);
//            tcOrderSkuMapper.updateById(sku);
//            return new Payload(null,ResultEnum.AWARD_ALL_USE.getCode(),ResultEnum.AWARD_ALL_USE.getMsg());
        }

        refundCount = refundCount - isUseNum;
        TcOrderRefundVO tcOrderRefundVO = new TcOrderRefundVO();
//        tcOrderRefundVO.setAwardId(mainVO.getAwardId());
        tcOrderRefundVO.setAwardType(mainVO.getAwardType());
        tcOrderRefundVO.setOrderNo(mainVO.getOrderNo());
        tcOrderRefundVO.setRefundCount(refundCount);
        //目前的每件的数据都是一样的，所以(总额/总件数)*可退件数 = 退款金额，这里的精度保留2位，并且四舍五入
        tcOrderRefundVO.setRefundAmount(mainVO.getAmount().divide(BigDecimal.valueOf(mainVO.getCount()),2,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(refundCount)));
        tcOrderRefundVO.setRefundType(mainVO.getPayType());
        return new Payload(tcOrderRefundVO);
    }*/
}
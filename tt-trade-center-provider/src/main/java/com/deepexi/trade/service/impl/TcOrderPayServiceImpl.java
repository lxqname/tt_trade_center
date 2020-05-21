package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.deepexi.pay.util.AuthUtil;
import com.deepexi.trade.config.PayServiceConfig;
import com.deepexi.trade.domain.dto.MakeSignDto;
import com.deepexi.trade.domain.dto.TcCallBackDto;
import com.deepexi.trade.domain.dto.TcOrderPayDto;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.domain.eo.TcOrderChild;
import com.deepexi.trade.domain.eo.TcOrderMain;
import com.deepexi.trade.domain.eo.TcOrderPay;
import com.deepexi.trade.domain.eo.TcOrderSku;
import com.deepexi.trade.domain.vo.SignVO;
import com.deepexi.trade.domain.vo.pay.TcCallBackResponse;
import com.deepexi.trade.enums.CallBackEnum;
import com.deepexi.trade.enums.PayStatusEnum;
import com.deepexi.trade.enums.ResultEnum;
import com.deepexi.trade.enums.StatusEnum;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.TcOrderChildMapper;
import com.deepexi.trade.mapper.TcOrderMainMapper;
import com.deepexi.trade.mapper.TcOrderPayMapper;
import com.deepexi.trade.mapper.TcOrderSkuMapper;
import com.deepexi.trade.service.TcOrderMainService;
import com.deepexi.trade.service.TcOrderPayService;
import com.deepexi.trade.service.TcOrderRefundService;
import com.deepexi.trade.service.third.ProductService;
import com.deepexi.trade.service.third.domain.UseStatusEnum;
import com.deepexi.trade.utils.GenerateSignDataUtils;
import com.deepexi.util.BeanPowerHelper;
import com.deepexi.util.CollectionUtil;
import com.deepexi.util.StringUtil;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Component
@Service(version = "${demo.service.version}")
public class TcOrderPayServiceImpl implements TcOrderPayService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderPayServiceImpl.class);

    @Autowired
    private TcOrderPayMapper tcOrderPayMapper;

    @Autowired
    private TcOrderMainMapper tcOrderMainMapper;

    @Autowired
    private TcOrderChildMapper tcOrderChildMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Autowired
    private TcOrderRefundService tcOrderRefundService;


    @Autowired
    private TcOrderSkuMapper tcOrderSkuMapper;

    @Autowired
    private TcOrderMainService tcOrderMainService;

    @Autowired
//    @Reference(version = "${demo.service.version}", check = false)
    private ProductService productService;

    @Override
    public PageBean findPage(TcOrderPayDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderPay> list = tcOrderPayMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderPay> findAll(TcOrderPayDto eo) {
        List<TcOrderPay> list = tcOrderPayMapper.findList(eo);
        return list;
    }
    @Override
    public TcOrderPay detail(String pk) {
        return tcOrderPayMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderPayDto eo) {
        int result = tcOrderPayMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderPay.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderPayDto eo) {
        eo.setId(pk);
        int result = tcOrderPayMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderPay.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderPayMapper.deleteByIds(pk);
        return result > 0;
    }

    @Override
    public TcCallBackResponse payCallback(TcCallBackDto callBackDto) {
//        TcCallBackResponse x = payCallbackSignCheck(callBackDto);
//        if (x != null) {
//            return x;
//        }

        //属于退款的走退款的方法
        if (isSefundCallBack(callBackDto)) {
            return tcOrderRefundService.refundCallBack(callBackDto);
        }

        String transNo = callBackDto.getOrderId();
        if(StringUtil.isNotEmpty(transNo)){
            TcOrderPayDto dto = new TcOrderPayDto();
            dto.setTransNo(transNo);
            List<TcOrderPay> orderPays = tcOrderPayMapper.findList(dto);
            if(CollectionUtil.isEmpty(orderPays)) {
                return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE, ResultEnum.ORDER_NOT_FOUND.getMsg()));
            }

            //一个支付订单号对应一笔订单
            TcOrderPay tcOrderPay = orderPays.get(0);
            if(StatusEnum.SUCCESS.getCode().equals(tcOrderPay.getOrderStatus())) {
                return new TcCallBackResponse(CallBackEnum.SUCCESS);
            }

            if(PayStatusEnum.SUCCESS.getCode().equals(callBackDto.getStatus())){
                if(!this.checkOldSuccessPayOrder(tcOrderPay.getOrderId(),transNo)){
                    int updatePayNum = this.orderPayOperation(transNo, null, StatusEnum.SUCCESS.getCode(),tcOrderPay);
                    if(updatePayNum > 0) {
                        tcOrderPay.setPayTime(new Date());
                        tcOrderPayMapper.updateById(tcOrderPay);
                        return new TcCallBackResponse(CallBackEnum.SUCCESS);
                    }
                }else {
                    logger.info("该笔订单存在一笔主订单为支付成功的，回调的订单号为：{}，进行退款操作",callBackDto.getOrderId());
                    //todo 把该笔订单进行退款
                }
            }else {
                logger.info("支付回调的状态为：{}，回调的订单号为：{}，暂时不需做更新处理",callBackDto.getStatus(),callBackDto.getOrderId());
            }
        }
        return new TcCallBackResponse(CallBackEnum.SUCCESS);

    }

    private boolean isSefundCallBack(TcCallBackDto callBackDto) {
        if(PayStatusEnum.REFUND.getCode().equals(callBackDto.getStatus()) ||
                PayStatusEnum.REFUND_APPLY_SUCCESS.getCode().equals(callBackDto.getStatus())||
                    PayStatusEnum.REFUND_FAILURE.getCode().equals(callBackDto.getStatus())){
            return true;
        }
        return false;
    }

    private TcCallBackResponse payCallbackSignCheck(TcCallBackDto callBackDto) {
        String signSrc = null;
        try {
            //验签校验
            Map<String, String> requestMap = BeanUtils.describe(callBackDto);
            //去除多余字段
            requestMap.remove("class");
            requestMap.remove("signature");
            signSrc = GenerateSignDataUtils.buildData(new TreeMap<>(requestMap));
            logger.info("待签数据:{}", signSrc);
        } catch (Exception e) {
            logger.error("TcOrderPayServiceImpl.payCallback：回调验签失败,异常的原因为：{}", ExceptionUtils.getStackTrace(e));
            return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE,"参数格式校验错误"));
        }
        boolean flag = AuthUtil.makeMD5Sign(signSrc, PayServiceConfig.getAuthCode()).equals(callBackDto.getSignature());
        logger.info("参数验签结果:{}", flag);
        if(!flag) {
            return new TcCallBackResponse(CallBackEnum.setMsg(CallBackEnum.FAILURE,"参数验签失败"));
        }
        return null;
    }

    private Boolean checkOldSuccessPayOrder(String orderId,String nowTransNo){
        TcOrderPayDto dto = new TcOrderPayDto();
        dto.setOrderId(orderId);
        List<TcOrderPay> orderPays = tcOrderPayMapper.findList(dto);
        List<TcOrderPay> successPay = orderPays.stream().filter(tcOrderPay -> StatusEnum.SUCCESS.getCode().equals(tcOrderPay.getOrderStatus()) && !nowTransNo.equals(tcOrderPay.getTransNo())).collect(Collectors.toList());
        if(CollectionUtil.isNotEmpty(successPay)) {
            return true;
        }
        return false;
    }

    //支付成功后的操作
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int orderPayOperation(String transNo, Date payTime, Integer status,TcOrderPay tcOrderPay){
        if(null == tcOrderPay){
            TcOrderPayDto dto = new TcOrderPayDto();
            dto.setTransNo(transNo);
            List<TcOrderPay> orderPay = tcOrderPayMapper.findList(dto);
            if(CollectionUtil.isEmpty(orderPay)){
                logger.error("支付订单号有误，失败的订单为：{}",transNo);
                return 0;
            }
            //正常只有一条的
            tcOrderPay = orderPay.get(0);
        }

        //更新支付表
        tcOrderPay.setOrderStatus(status);
        if(null != payTime) {
            tcOrderPay.setPayTime(payTime);
        }
        int updatePayNum = tcOrderPayMapper.updateById(tcOrderPay);

        TcOrderMain tcOrderMain = new TcOrderMain();
        tcOrderMain.setOrderStatus(status);
        tcOrderMain.setPayType(tcOrderPay.getPayType());
        tcOrderMain.setOrderPayNo(tcOrderPay.getTransNo());
        tcOrderMain.setId(tcOrderPay.getOrderId());
        tcOrderMainMapper.updateById(tcOrderMain);

        TcOrderChild tcOrderChild = new TcOrderChild();
        tcOrderChild.setChildStatus(status);
        tcOrderChild.setChildPayType(tcOrderPay.getPayType());
        tcOrderChild.setOrderPayNo(tcOrderPay.getTransNo());
        tcOrderChild.setOrderId(tcOrderPay.getOrderId());
        tcOrderChildMapper.updateByOrderId(tcOrderChild);

        //todo 扣除优惠券或用户积分、真正把库存减掉、并且把商品发放到用户手上
        TcOrderMain tm = tcOrderMainMapper.selectById(tcOrderMain.getId());
        //把主订单号给到商品中心，用户后续用订单号和会员查询出对应的商品信息、或者进行退款，后续可以多个商品一个主订单号
        String orderNo = tm.getOrderNo();


        TcOrderSkuDto tcOrderSkuDto = new TcOrderSkuDto();
        tcOrderSkuDto.setOrderId(tcOrderMain.getId());
        List<TcOrderSku> list = tcOrderSkuMapper.findList(tcOrderSkuDto);
        if (null != list){
            for (TcOrderSku sku :
                    list) {
                try {
                    tcOrderMainService.updateMemberAwardItemRelation(null,tcOrderMain.getId(),"", UseStatusEnum.PENDING_USE.getState());// TODO: 2019/5/29
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    productService.occupyFromFrozen(sku.getProductId(),sku.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        

        return updatePayNum;
    }

    @Override
    public SignVO makeSign(MakeSignDto makeSignDto) {
        SignVO signVO = new SignVO();
        String signature = null;
        String objJsonStr = makeSignDto.getObjJsonStr();
        JSONObject parameter = JSONObject.parseObject(objJsonStr);
        if(StringUtil.isEmpty(makeSignDto.getSignType())) {
            makeSignDto.setSignType("MD5");
        }
        try {
            parameter.put("signType",makeSignDto.getSignType());
            signature = AuthUtil.makeSign(objJsonStr, PayServiceConfig.getAuthCode());
        } catch (Exception e) {
            logger.info("加签失败，失败原因为：{}",ExceptionUtils.getStackTrace(e));
            throw new ApplicationException(ResultEnum.PARAMETER_ERROR);
        }
        signVO.setSignature(signature);
        return signVO;
    }
}
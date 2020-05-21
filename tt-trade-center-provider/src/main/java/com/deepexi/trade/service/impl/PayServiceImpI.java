package com.deepexi.trade.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.deepexi.pay.util.AuthUtil;
import com.deepexi.trade.config.PayServiceConfig;
import com.deepexi.trade.domain.dto.pay.BasePayRequest;
import com.deepexi.trade.domain.vo.pay.BasePayResponse;
import com.deepexi.trade.enums.PayTypeEnum;
import com.deepexi.trade.enums.PayURLEnum;
import com.deepexi.trade.enums.ResultEnum;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.util.extension.ApplicationException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 10:31
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
@Component
public class PayServiceImpI {

    private static final Logger logger = LoggerFactory.getLogger(PayServiceImpI.class);

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    public <REQ extends BasePayRequest> void initPayInfo(REQ request, Integer payType){
        if(PayTypeEnum.WECHAT_PAY.getCode().equals(payType)){
            request.setPayApplicationCode(PayServiceConfig.getPayApplicationCode());
            request.setPaySysAccessAuthCode(PayServiceConfig.getPaySysAccessAuthCode());
            request.setPaySysBizTypeCode(PayServiceConfig.getPaySysBizTypeCode());
            request.setDoMain(PayServiceConfig.getDoMain());
            request.setIp(PayServiceConfig.getIp());
        }else if(PayTypeEnum.ALI_PAY.getCode().equals(payType)){

        }else if(PayTypeEnum.UNION_PAY.getCode().equals(payType)){

        }
    }

    /**
     * 发送请求
     *
     * @param payURLEnum 请求URL
     * @param request
     * @param <RES>
     * @param <REQ>
     * @return
     * @throws Exception
     */
    public  <RES extends BasePayResponse, REQ extends BasePayRequest> RES send(PayURLEnum payURLEnum, REQ request, RES response) throws Exception {
        Map<String, String> requestMap = BeanUtils.describe(request);
        // 自然排序
        TreeMap<String, String> requestTreeMap = new TreeMap<>(requestMap);
        //去除多余字段
        requestMap.remove("class");
        /*String signSrc = GenerateSignDataUtils.buildData(new TreeMap<>(requestMap));
        logger.info("待签数据:{}", signSrc);*/
        requestTreeMap.put("signature",AuthUtil.makeSign(JSONObject.toJSONString(request),PayServiceConfig.getAuthCode()));
        requestTreeMap.remove("class");
        //发送请求
        String url = PayServiceConfig.getBaseUrl() + payURLEnum.getUrl();
        logger.info("发送请求({}),url:{},requestData:{}", payURLEnum.getName(), url, JSON.toJSONString(requestTreeMap));

        Map<String, String> urlData = new HashMap<>();
//        urlData.put("tenantId",appRuntimeEnv.getTenantId());//// TODO: 2019/5/22
        urlData.put("tenantId",PayServiceConfig.getTenantId());
        

        DateTime startTime = new DateTime();
        DateTime endTime = null;
        Interval interval = null;
        String responseStr = this.sendPostBody(url, urlData, JSON.toJSONString(requestTreeMap), null, Integer.valueOf(PayServiceConfig.getTimeOut()));
        endTime = new DateTime();
        interval = new Interval(startTime, endTime);

        logger.info("响应请求({}),url:{},responseData:{},响应时间:{}毫秒", payURLEnum.getName(), url, responseStr,interval.toDurationMillis());
        if (null == responseStr) {
            logger.info("{},网络异常!!", payURLEnum.getName());
            throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "网络异常！"));
        }

        TreeMap<String, String> responseTreeMap = JSON.parseObject(responseStr, new TypeReference<TreeMap<String, String>>() {});
        String code = responseTreeMap.get("code");

        //noinspection AliControlFlowStatementWithoutBraces
        if(!"0".equals(code)) throw new ApplicationException(ResultEnum.setMsg(ResultEnum.PARAMETER_ERROR, "调用支付中心异常"));

        BeanUtils.copyProperties(response,JSON.parseObject(responseTreeMap.get("payload"),Map.class));
        return response;
    }

    public String sendPostBody(String url, Map<String, String> urlData, String jsonData, Map<String,String> headers, Integer timeOut) throws Exception {
        String str = "";
        String body = null;
        if (urlData != null && !urlData.isEmpty()) {
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlData.forEach((_key, _value) -> urlParameters.add(new BasicNameValuePair(_key, _value)));
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(urlParameters, Consts.UTF_8));
            url = url + "?" + str ;
        }

        HttpRequest request = HttpRequest.post(url).header("Content-Type", "application/json").charset("UTF-8").body(jsonData).timeout(timeOut);

        if(null != headers && ! headers.isEmpty()){
            headers.forEach((k,v)-> request.header(k,v));
        }
        HttpResponse response = request.execute();

        logger.info("{}:请求返回响应码:{}", url, response.getStatus());

        if (response.getStatus() == HttpStatus.SC_OK) {
            body = response.body();
        }

        return body;
    }
}

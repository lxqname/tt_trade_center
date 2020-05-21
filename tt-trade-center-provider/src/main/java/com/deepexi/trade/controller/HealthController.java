package com.deepexi.trade.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.service.TcOrderSkuService;
import com.deepexi.trade.service.third.domain.WmWechatMemberInfoVO;
import com.deepexi.trade.utils.DingdingBot;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import com.deepexi.wechat.domain.dto.TemplateMessageCommonDTO;
import com.deepexi.wechat.service.WechatTemplateMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Service
@Path("/api/v1/health")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class HealthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderSkuService tcOrderSkuService;

    @GET
    @Path("/")
    public Payload findPage() {
        return new Payload("success");
    }




    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

//    @Autowired
    @Reference(version = "${demo.service.version}", check = false,url = "dubbo://203.195.178.170:28114")
    private WechatTemplateMessageService wechatTemplateMessageService;
    @GET
    @Path("/templateMessageCommonSend")
    public Payload templateMessageCommonSend() {
        try {

            TemplateMessageCommonDTO dto = new TemplateMessageCommonDTO();




            appRuntimeEnv.ensureTenantId("tt");


            // 查询会员发送消息的公众号（按关注及分流设置的顺序）
//            WmWechatMemberInfoVO wmWechatMemberInfo = wmWechatMemberInfoService.getInfoVOWechatNumberIdBypass(mainVO.getMemberId());
//            if (null == wmWechatMemberInfo) {
//                DingdingBot.sendMsg("MessageServiceImpl.couponExpired：会员[" + mainVO.getMemberId() + "]查询不到关注公众号，无法发送模板消息");
//                return;
//            }

//            TemplateMessageCommonDTO templateMessageCommonDTO = new TemplateMessageCommonDTO();
//            templateMessageCommonDTO.setTemplateId("OPENTM401747701");
//            templateMessageCommonDTO.setOpenId(wechatNumberIdBypass.getOpenId());
//            templateMessageCommonDTO.setWeChatAccount(wechatNumberIdBypass.getWechatNumberId());
//            templateMessageCommonDTO.setUrl("http://"+domainName+"/cdp-wy-trade-center/api/v1/tcOrderMains/" +mainVO.getId()+
//                    "?tenantId="+mainVO.getTenantCode());

            dto.setTemplateId("OPENTM401747701");
            dto.setOpenId("o-RM11lPLyYIhINp7LfCpBqpai8Y");
            dto.setWeChatAccount("gh_c65a02d38b73");

            dto.setUrl("/woyou-member-mobile/index.html#/order/detail?id=" +"orderid:1"+ "&tenantId=" + appRuntimeEnv.getTenantId() + "&appId=" + "wx0c998f08bd3a3938");
            dto.setTemplateId("OPENTM401747701");

            Map<String, String> sendMap = new HashMap<>(8);

//            sendMap.put("first","亲，您有一笔退款成功，请留意。");
//            sendMap.put("keyword1",tcOrderRefund.getRefundAmount()+"元");
//            sendMap.put("keyword2",tcOrderRefund.getId());
//            sendMap.put("remark","查看退款详情");


            String awardName = "copoun";
            sendMap.put("first","您有一笔退款，请留意。");
            sendMap.put("keyword1","1"+"元");
            sendMap.put("keyword2",awardName);
            sendMap.put("keyword3","orderid:1");
            sendMap.put("remark","查看退款详情");



            dto.setSendMap(sendMap);



            wechatTemplateMessageService.templateMessageCommonSend(dto);



        } catch (Exception e) {
            e.printStackTrace();
            DingdingBot.sendMsg(e.getMessage());
        }
        return new Payload(true);
    }

}

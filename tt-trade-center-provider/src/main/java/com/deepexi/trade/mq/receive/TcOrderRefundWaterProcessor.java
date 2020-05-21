package com.deepexi.trade.mq.receive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepexi.mq.api.IMessageProcessor;
import com.deepexi.mq.domain.MessageResponse;
import com.deepexi.trade.domain.dto.TcOrderRefundWaterDto;
import com.deepexi.trade.domain.eo.TcOrderRefundWater;
import com.deepexi.trade.service.TcOrderRefundWaterService;
import com.deepexi.util.CollectionUtil;
import com.deepexi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/28 19:40
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
@Service
public class TcOrderRefundWaterProcessor implements IMessageProcessor<String> {

    private final Logger logger = LoggerFactory.getLogger(TcOrderRefundWaterProcessor.class);

    private TcOrderRefundWaterService tcOrderRefundWaterService;

    public TcOrderRefundWaterProcessor(TcOrderRefundWaterService tcOrderRefundWaterService) {
        this.tcOrderRefundWaterService = tcOrderRefundWaterService;
    }

    @Override
    public MessageResponse process(String message) {
        if (StringUtil.isBlank(message)) {
            logger.info("message body is null");
            return MessageResponse.ERROR;
        }

        logger.info("TcOrderRefundWaterProcessor====>>>接收的参数为：{}",message);

        TcOrderRefundWaterDto dto = JSON.toJavaObject(JSONObject.parseObject(message), TcOrderRefundWaterDto.class);

        List<TcOrderRefundWater> refundWaters = tcOrderRefundWaterService.findAll(dto);
        //已经存在一条流水，证明流水表入库成功，但是调用支付中心进行退款时，失败了，退款表事务回滚了，但是流水表并无回滚，用户二次退款可需清理流水表数据
        if (CollectionUtil.isNotEmpty(refundWaters)) {
            List<String> waterIds = refundWaters.stream().map(TcOrderRefundWater::getId).collect(Collectors.toList());
            tcOrderRefundWaterService.delete(waterIds.toArray(new String[waterIds.size()]));
        }

        if(!"2".equals(dto.getOptType())) {
            Boolean aBoolean = tcOrderRefundWaterService.create(dto);
            //noinspection AliControlFlowStatementWithoutBraces
            if (!aBoolean) return MessageResponse.ERROR;
        }

        return MessageResponse.SUCCESS;
    }
}

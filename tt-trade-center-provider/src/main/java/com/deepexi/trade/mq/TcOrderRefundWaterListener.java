package com.deepexi.trade.mq;

import com.deepexi.mq.api.IMQService;
import com.deepexi.trade.mq.receive.TcOrderRefundWaterProcessor;
import com.deepexi.trade.service.TcOrderRefundWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: lc_xin.
 * @Date: 2019/4/28 19:40
 */
@Component
public class TcOrderRefundWaterListener {

    @Autowired
    private TcOrderRefundWaterService tcOrderRefundWaterService;

    @Value("${deepexi.mq.tcOrderRefundWater.topic}")
    private String tcOrderRefundWaterTopic;

    @Value("${deepexi.mq.tcOrderRefundWater.routingKey}")
    private String tcOrderRefundWaterRoutingKey;

    @Autowired
    private IMQService mqService;

    @PostConstruct
    private void refundWaterReceiveMessage() {
        try {
            mqService.createConsumer().subscribe(tcOrderRefundWaterTopic, tcOrderRefundWaterRoutingKey, new TcOrderRefundWaterProcessor(tcOrderRefundWaterService));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

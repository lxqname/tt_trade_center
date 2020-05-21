package com.deepexi.trade.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.deepexi.trade.service.TcOrderMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时取消订单的定时器
 * @Author: lc_xin.
 * @Date: 2019/4/25 17:32
 */
@Component
public class OrderCloseScheduled implements SimpleJob {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderMainService tcOrderMainService;

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("OrderCloseScheduled=====>>>>> closeOrder-execute-start");
        tcOrderMainService.closeOrder();
        logger.info("OrderCloseScheduled=====>>>>> closeOrder-execute-end");
    }

}

package com.deepexi.trade.service.third.impl;

import com.deepexi.component.lock.facade.ILockService;
import com.deepexi.redis.service.RedisService;
import com.deepexi.trade.service.third.domain.IdRuleEnum;
import com.deepexi.trade.service.third.GenerateIdService;
import com.deepexi.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.locks.Lock;

@Component
public class GenerateIdServiceImpl implements GenerateIdService {
    @Autowired
    private ILockService lockService;
    @Resource
    private RedisService redisService;
    @Override
    public String getStandardOrderId(String key, Long timeout, IdRuleEnum idRuleEnum) {
        String idTag = ":id",idKey = key+idTag;

        if (!redisService.exists(idKey)){
            redisService.set(idKey,10000);
        }

        Lock lock = lockService.tryLock(key, timeout);
        try {
            String v = redisService.get(idKey);
            int id = Integer.parseInt(v)+1;
            redisService.set(idKey,id);
            String yyyMMddHHmmss = DateUtils.format(new Date(), "yyyMMddHHmmss");
            return yyyMMddHHmmss+id;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        return null;
    }

    public static void main(String[] args) {

        System.out.println(DateUtils.format(new Date(),"yyyMMddHHmmss"));
    }
}

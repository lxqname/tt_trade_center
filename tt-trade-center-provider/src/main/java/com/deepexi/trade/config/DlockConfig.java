package com.deepexi.trade.config;

import com.deepexi.component.lock.LockServiceImpl;
import com.deepexi.component.lock.facade.ILockService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version V1.0
 * @author: LuoGuang
 * @Package com.deepexi.wechat.config
 * @Description:
 * @date: 2019/4/22 15:01
 */
@Configuration
/**
* DlockConfig
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class DlockConfig {
    @Value("${dlock.url}")
    private String dlockUrl;
    @Bean
    public ILockService distributeLock() {
        return new LockServiceImpl(dlockUrl);
    }
}

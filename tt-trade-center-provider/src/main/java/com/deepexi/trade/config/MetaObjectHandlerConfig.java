package com.deepexi.trade.config;





import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.service.third.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
* @desc MetaObjectHandlerConfig
* @author yunzi7758
* @Date: Tue Sep 10 10:59:57 CST 2019
*/
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
//    @Reference(version = "$ {demo.service.version}", check = false)
    private AccountService accountService;

@Resource
private AppRuntimeEnv appRuntimeEnv;

// mybatis-plus公共字段自动填充，https://baomidou.oschina.io/mybatis-plus-doc/#/auto-fill
/**
 * 新增方法实体填充
 * @param metaObject 元数据对象
 */
@Override
public void insertFill(MetaObject metaObject) {
setFieldValByName("tenantCode", appRuntimeEnv.getTenantId(), metaObject);
setFieldValByName("createdAt", new Date(), metaObject);
String token = appRuntimeEnv.getToken();
if (!StringUtils.isBlank(token)) {
try {
                setFieldValByName("createdBy", accountService.getLoginAccountIdByToken(token), metaObject);
} catch (Exception e) {
e.printStackTrace();
logger.error("Token格式不正确" + e.getMessage());
}
}
}

/**
 * 更新方法实体填充
 * @param metaObject 元数据对象
 */
@Override
public void updateFill(MetaObject metaObject) {
setFieldValByName("updatedAt", new Date(), metaObject);
String token = appRuntimeEnv.getToken();
if (!StringUtils.isBlank(token)) {
try {
                setFieldValByName("updatedBy", accountService.getLoginAccountIdByToken(token), metaObject);
} catch (Exception e) {
e.printStackTrace();
logger.error("Token格式不正确" + e.getMessage());
}
}
}

}
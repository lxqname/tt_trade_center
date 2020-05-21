package com.deepexi.trade.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.rpc.*;
import com.deepexi.trade.extension.AppRuntimeEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * program: deepexi-user-center
 * <p>
 * description: rpc调用统一环境参数设置
 *
 * @author: shaowin
 * <p>
 * created on : 2018-12-12 17:47
 **/
/**
 * @desc DubboContextProviderFilter
 * @author yunzi7758
 * @Date: Tue Sep 10 10:59:57 CST 2019
 */
@Activate(group = Constants.PROVIDER)
public class DubboContextProviderFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(DubboContextProviderFilter.class);

    private final static String TOKEN_KEY = "userToken";
    private final static String TENANT_ID_KEY = "tenantId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            AppRuntimeEnv appRuntimeEnv = (AppRuntimeEnv) ServiceBean.getSpringContext().getBean("appRuntimeEnv");
            String token = RpcContext.getContext().getAttachment(TOKEN_KEY);
            String tenantId = RpcContext.getContext().getAttachment(TENANT_ID_KEY);
            appRuntimeEnv.setToken(token);
            appRuntimeEnv.setTenantId(tenantId);
        } catch (Exception e) {
            logger.error("提供端filter统一处理参数到appRuntimeEnv异常:", e);
        }
            return invoker.invoke(invocation);

    }
}
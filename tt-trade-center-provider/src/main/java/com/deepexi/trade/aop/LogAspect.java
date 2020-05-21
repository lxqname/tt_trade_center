package com.deepexi.trade.aop;

import com.alibaba.fastjson.JSON;
import com.deepexi.trade.utils.DingdingBot;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.annotation.TenantId;
import com.deepexi.trade.annotation.Token;
import com.deepexi.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志统一打印切面
 */
/**
 * @desc LogAspect
 * @author yunzi7758
 * @Date: Tue Sep 10 10:59:57 CST 2019
 */
@Component
@Aspect
public class LogAspect {


        private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

        private final static String TENANT_KEY = "tenantId";
        private final static String TOKEN_KEY = "Authorization";//放在header里面的验证信息



        @Autowired
        private AppRuntimeEnv appRuntimeEnv;

        @Pointcut("execution (* com.deepexi.trade.controller..*.*(..))")
        public void controllerLogAop() {
        }

        @Pointcut("execution (* com.deepexi.trade.service..*.*(..))")
        public void apiLogAop() {
        }

        @Before("controllerLogAop()")
        public void setAppRuntimeEnv(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //noinspection AliControlFlowStatementWithoutBraces
        if (method == null || RequestContextHolder.getRequestAttributes() == null) appRuntimeEnv.ensureTenantId(null);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TenantId tenantAnno = method.getAnnotation(TenantId.class);

        //默认全局拦截，不包含注解，或者require=true，则拦截
        if (tenantAnno == null || tenantAnno.require()) {
        appRuntimeEnv.ensureTenantId(getParam(request, TENANT_KEY));
        } else {
        appRuntimeEnv.setTenantId(getParam(request, TENANT_KEY));
        }

        //token统一获取,eg:Authorization：Bearer xxxx
        Token tokeAnno = method.getAnnotation(Token.class);
        String auth = request.getHeader(TOKEN_KEY);
        if (tokeAnno == null || tokeAnno.require()) {
        appRuntimeEnv.ensureToken(StringUtil.isEmpty(auth) ? null : auth.split(" ")[1].trim());
        } else {
        appRuntimeEnv.setToken(StringUtil.isEmpty(auth) ? null : auth.split(" ")[1].trim());
        }
        }

        @Around("controllerLogAop()")
        public Object aroundController(ProceedingJoinPoint point) throws Throwable {

        // controller传入记录token和tenantId这些通用参数
        if (RequestContextHolder.getRequestAttributes() != null) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        appRuntimeEnv.setTenantId(getParam(request, TENANT_KEY));
        appRuntimeEnv.setToken(getParam(request, TOKEN_KEY));
        }

        Object response = null;
        try {
        //执行该方法
        response = point.proceed();
        } catch (Exception e) {
        throw e;
        }
        return response;
        }

        @Around("apiLogAop()")
        public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        logger.info("日志统一打印 ===== {}.{}() start =====,参数:\n{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), argsToString(point.getArgs()));
        DateTime startTime = new DateTime();
        DateTime endTime = null;
        Interval interval = null;
        Object response = null;

        try {
        //执行该方法
        response = point.proceed();
        } catch (Exception e) {
        endTime = new DateTime();
        interval = new Interval(startTime, endTime);
        logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:\n{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), interval.toDurationMillis());



        DingdingBot.sendMsg("类："+point.getSignature().getDeclaringTypeName()+" 方法："+point.getSignature().getName()+"  参数信息："+argsToString(point.getArgs())+"  响应时间："+interval.toDurationMillis()+"  异常信息"+e.getMessage());

        throw e;
        }
        endTime = new DateTime();
        interval = new Interval(startTime, endTime);
        logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:\n{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), interval.toDurationMillis(), argsToString(response));
        return response;
        }

        private String argsToString(Object object) {
        try {
        return JSON.toJSONString(object);
        } catch (Exception e) {
        logger.error("", e);
        }
        return String.valueOf(object);
        }

        /**
         * 获取业务参数
         *
         * @param request
         * @param param
         * @throws Exception
         */
        private String getParam(HttpServletRequest request, String param) throws Exception {
        String[] reqParam = request.getParameterValues(param);
        return (reqParam == null || reqParam.length < 1 ? null : reqParam[0]);
        }


}

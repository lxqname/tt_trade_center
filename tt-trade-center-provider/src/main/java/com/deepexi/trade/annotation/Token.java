package com.deepexi.trade.annotation;/**
 * Created by chenshaowen on 2018/12/6.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * program: deepexi-tenant-center
 * <p>
 * description: 自定义注解
 *
 * @author: shaowin
 * <p>
 * created on : 2018-12-06 22:23
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    public boolean require() default true;
}

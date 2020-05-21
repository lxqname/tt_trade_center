package com.deepexi.trade.util;

import com.deepexi.util.IdGenerator;





/**
 * @desc IdUtils
 * @author yunzi7758
 * @Date: Tue Sep 10 10:59:57 CST 2019
 */
public class IdUtils {


    public static String getId() {
//        String uuid = CommonUtils.uuid();
//        String randomString = StringUtil.getRandomString(32 - uuid.length());
//        return uuid+randomString;
        return IdGenerator.getNumberId();
    }
}

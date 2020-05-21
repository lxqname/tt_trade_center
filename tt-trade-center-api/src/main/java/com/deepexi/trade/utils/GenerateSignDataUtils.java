package com.deepexi.trade.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Author: lc_xin.
 * @Date: 2019/5/5 11:02
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
public class GenerateSignDataUtils {
    /**
     * 去除空值
     *
     * @param treeMap
     */
    @SuppressWarnings("AliControlFlowStatementWithoutBraces")
    public static void removeEmptyTreeMap(TreeMap<String, String> treeMap) {
        List<String> emptyList = new ArrayList<>();
        treeMap.forEach((key, value) -> {
            //noinspection AliControlFlowStatementWithoutBraces
            if ("".equals(value) || "[]".equals(value)) emptyList.add(key);
        });

        emptyList.forEach(treeMap::remove);
    }

    /**
     * 构建数据
     * aaa=bbb&ccc=ddd
     *
     * @param requestTreeMap
     * @return
     */
    public static String buildData(TreeMap<String, String> requestTreeMap) throws Exception {
        StringBuilder sb = new StringBuilder();
        requestTreeMap.forEach((_key, _value) -> {
            //字段空不参与
            //noinspection AliControlFlowStatementWithoutBraces
            if (Objects.equals("", _value) || _value == null) return;
            sb.append(_key).append("=").append(_value).append("&");
        });
        //去除最后一个&
        sb.setLength(sb.length() - 1);
        //签名
        return sb.toString();
    }
}

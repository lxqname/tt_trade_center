package com.deepexi.trade.domain.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BaseDto implements Serializable {

    public static List<String> toListSplit(String str){
        return Arrays.asList(str.split(","));
    }
}

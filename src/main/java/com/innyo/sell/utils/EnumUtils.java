package com.innyo.sell.utils;

import com.innyo.sell.enums.CodeEnum;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-19 13:11
 * @Modified by:
 */
public class EnumUtils {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
            for(T each:enumClass.getEnumConstants()){
                if(code.equals(each.getCode())){
                    return each;
                }
            }
        return null;
    }
}

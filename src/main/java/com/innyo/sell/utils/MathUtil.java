package com.innyo.sell.utils;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-18 13:55
 * @Modified by:
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1,Double d2){
           Double result =  Math.abs(d1-d2);
           if(result< MONEY_RANGE){
                return true;
           }else{
               return false;
           }
    }
}

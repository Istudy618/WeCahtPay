package com.innyo.sell.utils;

import java.util.Random;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 11:22
 * @Modified by:
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        return System.currentTimeMillis() +  String.valueOf (random.nextInt(900000)+100000);
    }


}

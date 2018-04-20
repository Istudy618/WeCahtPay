package com.innyo.sell.enums;


import lombok.Getter;

/**
 * @Author: XM
 * @Description: 商品状态
 * @Data: Create in 2018-04-13 11:54
 * @Modified by:
 */
@Getter
public enum ProductStatusEnum  implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private  String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

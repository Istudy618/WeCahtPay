package com.innyo.sell.enums;

import lombok.Getter;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-13 17:41
 * @Modified by:
 */
@Getter
public enum OrderStatusEnum  implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;
    private  String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.innyo.sell.enums;

import lombok.Getter;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-13 17:50
 * @Modified by:
 */
@Getter
public enum PayStatusEnum  implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;

    private  String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

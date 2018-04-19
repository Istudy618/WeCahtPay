package com.innyo.sell.exception;

import com.innyo.sell.enums.ResultEnum;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 11:00
 * @Modified by:
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}

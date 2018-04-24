package com.innyo.sell.handler;

import com.innyo.sell.config.ProjectUrlConfig;
import com.innyo.sell.exception.SellerAuthorizeExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-23 14:34
 * @Modified by:
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig urlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeExeption.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(urlConfig.getWechatOpenAuthorize())
                .concat("/seller/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(urlConfig.getSell())
                .concat("/sell/seller/login"));
    }
}

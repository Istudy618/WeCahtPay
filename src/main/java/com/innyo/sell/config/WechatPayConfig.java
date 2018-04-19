package com.innyo.sell.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-18 9:23
 * @Modified by:
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccoubtConfig accoubtConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config( wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config(){
        WxPayH5Config wxPayH5Config  = new WxPayH5Config();
        wxPayH5Config.setAppId(accoubtConfig.getMpAppId());
        wxPayH5Config.setAppSecret(accoubtConfig.getMpAppSecret());
        wxPayH5Config.setMchId(accoubtConfig.getMchId());
        wxPayH5Config.setMchKey(accoubtConfig.getMchKey());
        wxPayH5Config.setKeyPath(accoubtConfig.getKeyPath());
        wxPayH5Config.setNotifyUrl(accoubtConfig.getNotifyUrl());
        return wxPayH5Config;
    }
}

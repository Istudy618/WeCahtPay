package com.innyo.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-17 15:36
 * @Modified by:
 */
@Component
public class WechatMpConfig {

    @Autowired
    private WechatAccoubtConfig wechatAccoubtConfig;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(wechatAccoubtConfig.getMpAppId());
        wxMpConfigStorage.setSecret(wechatAccoubtConfig.getMpAppSecret());
        return wxMpConfigStorage;
    }
}

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
 * @Data: Create in 2018-04-20 15:24
 * @Modified by:
 */
@Component
public class WechatOpenConfig {
    @Autowired
    private WechatAccoubtConfig accoubtConfig;

    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(getWxOpenConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage getWxOpenConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(accoubtConfig.getOpenAppId());
        wxMpInMemoryConfigStorage.setSecret(accoubtConfig.getOpenAppSecret());
        return wxMpInMemoryConfigStorage;
    }

}

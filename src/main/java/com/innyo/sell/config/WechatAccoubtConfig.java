package com.innyo.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-17 15:51
 * @Modified by:
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccoubtConfig {
    /**
     * 公众号appid
     */
    private String mpAppId;
    /**
     * 公众号secret
     */
    private String mpAppSecret;
    /**
     * 商户号
     */
    private String mchId;
    /**
     *商户密钥
     */
    private String mchKey;
    /**
     *商户证书路径
     */
    private String keyPath;
    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;
}

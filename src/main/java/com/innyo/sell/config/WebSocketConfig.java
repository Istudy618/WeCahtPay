package com.innyo.sell.config;

import com.mysql.fabric.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-23 16:56
 * @Modified by:
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}

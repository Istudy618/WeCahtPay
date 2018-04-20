package com.innyo.sell.controller;

import com.innyo.sell.config.ProjectUrlConfig;
import com.innyo.sell.constant.CookieConstant;
import com.innyo.sell.constant.RedisConstant;
import com.innyo.sell.dataobject.SellerInfo;
import com.innyo.sell.enums.ResultEnum;
import com.innyo.sell.service.SellerService;
import com.innyo.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 16:04
 * @Modified by:
 */
@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid, HttpServletResponse response, Map<String , Object> map){

        //1.openid去和数据库里的数据匹配
        SellerInfo sellerInfo =  sellerService.findBySellerInfoOpenid(openid);
        if(sellerInfo == null){
                map.put("msg",ResultEnum.LOGIN_FAIL);
                map.put("url","/sell/seller/order/list");
                return  new ModelAndView("common/error",map);
        }
        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire  = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire,TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response,CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");

    }

    @GetMapping("/logout")
    public void logout(){

    }
}

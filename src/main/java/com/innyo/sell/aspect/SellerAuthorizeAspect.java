package com.innyo.sell.aspect;

import com.innyo.sell.constant.CookieConstant;
import com.innyo.sell.constant.RedisConstant;
import com.innyo.sell.exception.SellerAuthorizeExeption;
import com.innyo.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: XM
 * @Description: AOP实现身份验证
 * @Data: Create in 2018-04-23 13:53
 * @Modified by:
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.innyo.sell.controller.Seller*.*(..))" +"&& !execution(public * com.innyo.sell.controller.SellerUserController.*(..))")
    public void verify(){ }

    @Before("verify()")
    public void doverify(){
        ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie  =CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie == null){
            log.warn("【登录校验】 Cookie中查不到token");
            throw new SellerAuthorizeExeption();
        }

        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】 Redis中查不到token");
            throw new SellerAuthorizeExeption();
        }
    }
}

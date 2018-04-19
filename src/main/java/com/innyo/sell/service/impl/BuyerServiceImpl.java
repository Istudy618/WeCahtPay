package com.innyo.sell.service.impl;

import com.innyo.sell.dto.OrderDTO;
import com.innyo.sell.enums.ResultEnum;
import com.innyo.sell.exception.SellException;
import com.innyo.sell.service.BuyerService;
import com.innyo.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-17 11:32
 * @Modified by:
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOwnerOrder(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOwnerOrder(openid, orderId);
        if(orderDTO ==null){
            log.error("【取消订单】 查询不到该订单,orderId={},orderDTO={}",orderId,orderDTO);
            throw new SellException(ResultEnum.ORDERMASTER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOwnerOrder(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO ==null){
            return  null;
        }
        //判断是否是自己的订单
        if(orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询单个订单】 订单的openid不一致.openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}

package com.innyo.sell.service;

import com.innyo.sell.dto.OrderDTO;

/**
 * @Author: XM
 * @Description: 买家
 * @Data: Create in 2018-04-17 11:29
 * @Modified by:
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}

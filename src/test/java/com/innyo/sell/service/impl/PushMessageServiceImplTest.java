package com.innyo.sell.service.impl;

import com.innyo.sell.dto.OrderDTO;
import com.innyo.sell.service.OrderService;
import com.innyo.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-23 16:18
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1523931762348484173");
        pushMessageService.orderStatus(orderDTO);
    }
}
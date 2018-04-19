package com.innyo.sell.respository;

import com.innyo.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 10:13
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("56789");
        orderDetail.setProductName("阿迪鞋");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductPrice(new BigDecimal(6.5));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result  = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,result);
    }
}
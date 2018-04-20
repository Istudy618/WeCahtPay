package com.innyo.sell.service.impl;

import com.innyo.sell.dataobject.SellerInfo;
import com.innyo.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:57
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static  final String openid = "ocjqYw-MiIe9yb4xmQwV8fWEpVns";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findBySellerInfoOpenid() {
        SellerInfo result = sellerService.findBySellerInfoOpenid(openid);
        Assert.assertEquals(openid,result.getOpenid());
    }
}
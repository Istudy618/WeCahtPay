package com.innyo.sell.respository;

import com.innyo.sell.dataobject.SellerInfo;
import com.innyo.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:40
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerIndoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("ocjqYw-MiIe9yb4xmQwV8fWEpVns");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("ocjqYw-MiIe9yb4xmQwV8fWEpVns");
        Assert.assertEquals("ocjqYw-MiIe9yb4xmQwV8fWEpVns",sellerInfo.getOpenid());
    }
}
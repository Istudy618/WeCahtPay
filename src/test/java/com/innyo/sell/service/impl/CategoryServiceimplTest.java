package com.innyo.sell.service.impl;

import com.innyo.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-13 10:28
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceimplTest {
    @Autowired
    private CategoryServiceimpl categoryServiceimpl;

    @Test
    public void findOne() throws Exception{
       ProductCategory productCategory =  categoryServiceimpl.findOne(2);
       Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList =  categoryServiceimpl.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result =  categoryServiceimpl.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享",6);
        ProductCategory reult= categoryServiceimpl.save(productCategory);
        Assert.assertNotNull(reult);

    }
}
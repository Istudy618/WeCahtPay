package com.innyo.sell;

import com.innyo.sell.dataobject.ProductCategory;
import com.innyo.sell.respository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveOne() {
        ProductCategory productCategory = new ProductCategory("热门商品", 4);
        ProductCategory result = repository.save(productCategory);
        org.junit.Assert.assertNotNull(result);
        //org.junit.Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        org.junit.Assert.assertNotEquals(0,result.size());
    }
}

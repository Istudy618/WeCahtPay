package com.innyo.sell.service.impl;

import com.innyo.sell.dataobject.ProductCategory;
import com.innyo.sell.respository.ProductCategoryRepository;
import com.innyo.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XM
 * @Description: 类目
 * @Data: Create in 2018-04-13 10:19
 * @Modified by:
 */
@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}

package com.innyo.sell.service;

import com.innyo.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author: XM
 * @Description: 类目
 * @Data: Create in 2018-04-13 10:14
 * @Modified by:
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

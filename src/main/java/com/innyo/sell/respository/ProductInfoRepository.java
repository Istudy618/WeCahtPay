package com.innyo.sell.respository;

import com.innyo.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: XM
 * @Description: 商品
 * @Data: Create in 2018-04-13 11:12
 * @Modified by:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}

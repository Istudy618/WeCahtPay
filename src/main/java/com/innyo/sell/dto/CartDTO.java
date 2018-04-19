package com.innyo.sell.dto;

import lombok.Data;

/**
 * @Author: XM
 * @Description: 购物车
 * @Data: Create in 2018-04-16 11:42
 * @Modified by:
 */
@Data
public class CartDTO {
    /** 商品id.*/
    private String productId;

    /** 商品数量.*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

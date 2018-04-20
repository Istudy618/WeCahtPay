package com.innyo.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 11:32
 * @Modified by:
 */
@Data
public class ProductForm {

    private  String productId;
    /** 商品名称 */
    private  String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存.*/
    private  Integer productStock;
    /** 描述.*/
    private  String productDescription;
    /** 小图.*/
    private  String productIcon;
    /** 类目编号.*/
    private  Integer categoryType;
}

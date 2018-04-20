package com.innyo.sell.form;

import lombok.Data;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 13:51
 * @Modified by:
 */
@Data
public class CategoryForm {

    /** 类目id.*/
    private Integer categoryId;

    /**类目名字.*/
    private  String categoryName;

    /**类目编号.*/
    private Integer categoryType;
}

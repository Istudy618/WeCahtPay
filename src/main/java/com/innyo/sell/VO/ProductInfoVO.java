package com.innyo.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-13 14:29
 * @Modified by:
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  String productId;

    @JsonProperty("name")
    private  String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private  String productDescription;

    @JsonProperty("icon")
    private  String productIcon;
}

package com.innyo.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.innyo.sell.enums.ProductStatusEnum;
import com.innyo.sell.utils.EnumUtils;
import com.innyo.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: XM
 * @Description: 商品
 * @Data: Create in 2018-04-13 10:56
 * @Modified by:
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
     @Id
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
     /** 状态,0正常 1下架.*/
     private Integer productStatus;
     /** 类目编号.*/
     private  Integer categoryType;
     /** 创建时间.*/
     private Date createTime;

     /** 修改时间.*/
     private Date updateTime;

}

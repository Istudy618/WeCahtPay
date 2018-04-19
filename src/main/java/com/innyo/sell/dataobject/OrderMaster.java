package com.innyo.sell.dataobject;

import com.innyo.sell.enums.OrderStatusEnum;
import com.innyo.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: XM
 * @Description: 订单
 * @Data: Create in 2018-04-13 17:33
 * @Modified by:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单id.*/
    @Id
    private String orderId;

    /** 买家名字.*/
    private String buyerName;

    /** 买家电话.*/
    private String buyerPhone;

    /** 买家地址.*/
    private String buyerAddress;

    /** 买家微信id.*/
    private String buyerOpenid;

    /** 订单总金额.*/
    private BigDecimal orderAmount;

    /** 订单状态,默认为新下单.*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态,默认为0 未支付.*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间.*/
    private Date createTime;

    /** 修改时间.*/
    private Date updateTime;
}

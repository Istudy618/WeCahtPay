package com.innyo.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.innyo.sell.dataobject.OrderDetail;
import com.innyo.sell.enums.OrderStatusEnum;
import com.innyo.sell.enums.PayStatusEnum;
import com.innyo.sell.utils.EnumUtils;
import com.innyo.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 10:37
 * @Modified by:
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id.*/
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
    private Integer orderStatus ;

    /** 支付状态,默认为0 未支付.*/
    private Integer payStatus ;

    /** 创建时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 修改时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtils.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtils.getByCode(payStatus,PayStatusEnum.class);
    }
}

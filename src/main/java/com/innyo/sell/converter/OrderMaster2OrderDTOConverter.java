package com.innyo.sell.converter;

import com.innyo.sell.dataobject.OrderMaster;
import com.innyo.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 14:44
 * @Modified by:
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO  = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e -> converter(e)).collect(Collectors.toList());
    }
}

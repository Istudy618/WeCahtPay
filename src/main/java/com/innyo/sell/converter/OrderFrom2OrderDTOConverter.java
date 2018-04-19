package com.innyo.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.innyo.sell.dataobject.OrderDetail;
import com.innyo.sell.dto.OrderDTO;
import com.innyo.sell.enums.ResultEnum;
import com.innyo.sell.exception.SellException;
import com.innyo.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 17:46
 * @Modified by:
 */
@Slf4j
public class OrderFrom2OrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误 ,string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}

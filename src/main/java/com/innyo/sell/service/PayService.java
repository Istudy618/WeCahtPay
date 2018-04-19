package com.innyo.sell.service;

import com.innyo.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-17 17:39
 * @Modified by:
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refound(OrderDTO orderDTO);
}

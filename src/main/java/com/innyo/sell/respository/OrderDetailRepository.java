package com.innyo.sell.respository;

import com.innyo.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-16 9:46
 * @Modified by:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}

package com.innyo.sell.respository;


import com.innyo.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:36
 * @Modified by:
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}

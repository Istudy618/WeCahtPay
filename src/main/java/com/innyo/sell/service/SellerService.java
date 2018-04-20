package com.innyo.sell.service;

import com.innyo.sell.dataobject.SellerInfo;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:52
 * @Modified by:
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findBySellerInfoOpenid(String openid);
}

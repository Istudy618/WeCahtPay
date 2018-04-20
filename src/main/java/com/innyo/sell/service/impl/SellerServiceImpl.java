package com.innyo.sell.service.impl;

import com.innyo.sell.dataobject.SellerInfo;
import com.innyo.sell.respository.SellerInfoRepository;
import com.innyo.sell.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:53
 * @Modified by:
 */
@Service
@Slf4j
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findBySellerInfoOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}

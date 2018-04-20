package com.innyo.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: XM
 * @Description:
 * @Data: Create in 2018-04-20 14:33
 * @Modified by:
 */
@Entity
@Data
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

//    private Date createTime;
//
//    private Date updateTime;
}

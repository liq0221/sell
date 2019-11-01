package com.lee.sell.service;

import com.lee.sell.dataobject.SellInfo;

public interface SellInfoService {

    SellInfo findSellInfoByOpenid(String openid);
}

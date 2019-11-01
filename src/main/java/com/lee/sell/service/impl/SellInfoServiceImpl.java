package com.lee.sell.service.impl;

import com.lee.sell.dataobject.SellInfo;
import com.lee.sell.repository.SellInfoRepository;
import com.lee.sell.service.SellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellInfoServiceImpl implements SellInfoService {

    @Autowired
    private SellInfoRepository sellInfoRepository;
    @Override
    public SellInfo findSellInfoByOpenid(String openid) {
        return sellInfoRepository.findByOpenid(openid);
    }
}

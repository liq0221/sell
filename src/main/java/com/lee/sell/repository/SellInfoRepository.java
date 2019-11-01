package com.lee.sell.repository;

import com.lee.sell.dataobject.SellInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellInfoRepository extends JpaRepository<SellInfo,String> {

    SellInfo findByOpenid(String openid);
}

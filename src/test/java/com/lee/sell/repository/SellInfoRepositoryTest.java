package com.lee.sell.repository;

import com.lee.sell.dataobject.SellInfo;
import com.lee.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellInfoRepositoryTest {

    @Autowired
    private SellInfoRepository sellInfoRepository;
    @Test
    public void findByOpenid() {
        SellInfo sellInfo = sellInfoRepository.findByOpenid("1cscsa");
        System.out.println(sellInfo.toString());
    }

    @Test
    public void save(){
        SellInfo sellInfo = new SellInfo();
        sellInfo.setSellId(KeyUtil.genKey());
        sellInfo.setUsername("12aa");
        sellInfo.setPassword("1246");
        sellInfo.setOpenid("1cscsa");
        SellInfo save = sellInfoRepository.save(sellInfo);
        Assert.assertNotNull(save);

    }
}
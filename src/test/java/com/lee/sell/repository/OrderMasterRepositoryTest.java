package com.lee.sell.repository;

import com.lee.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerName("大亨");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setOrderId("123467");
        orderMaster.setBuyerPhone("1333333333");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findPage(){
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid("110110", new PageRequest(0, 1));
        System.out.println(page.getTotalElements());
    }
}

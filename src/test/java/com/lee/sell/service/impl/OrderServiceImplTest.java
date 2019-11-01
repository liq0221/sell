package com.lee.sell.service.impl;

import com.lee.sell.dataobject.OrderDetail;
import com.lee.sell.vo.OrderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("世华泊郡");
        orderDTO.setBuyerName("lee");
        orderDTO.setBuyerPhone("18435353355");
        orderDTO.setBuyerOpenid("110110");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderServiceImpl.create(orderDTO);
    }

    @Test
    public void cancel(){
        OrderDTO orderDTO = orderServiceImpl.findOne("1558435009306454952");
        OrderDTO cancel = orderServiceImpl.cancel(orderDTO);
        Assert.assertNotNull(cancel);
    }
}
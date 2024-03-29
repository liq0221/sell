package com.lee.sell.service;

import com.lee.sell.vo.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);
    //查询订单
    OrderDTO findOne(String orderId);
    //查询列表
    Page<OrderDTO> findList(String openId, Pageable pageable);
    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderDTO paid(OrderDTO orderDTO);
    //查询列表
    Page<OrderDTO> findList(Pageable pageable);

}

package com.lee.sell.service;

import com.lee.sell.vo.OrderDTO;

public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}

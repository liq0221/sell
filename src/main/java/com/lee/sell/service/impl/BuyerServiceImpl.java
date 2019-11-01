package com.lee.sell.service.impl;

import com.lee.sell.enums.OrderStatusEnum;
import com.lee.sell.enums.ResultEnum;
import com.lee.sell.exception.SellException;
import com.lee.sell.service.BuyerService;
import com.lee.sell.service.OrderService;
import com.lee.sell.vo.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrder(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrder(openid, orderId);
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUR_ERROR);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrder(String openid, String orderId){

        OrderDTO orderDTO = orderService.findOne(orderId);
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        if(orderDTO ==null){
            return null;
        }
        return orderDTO;
    }
}

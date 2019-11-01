package com.lee.sell.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lee.sell.dataobject.OrderDetail;
import com.lee.sell.form.OrderForm;
import com.lee.sell.vo.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList=new ArrayList<>();
       try{
           orderDetailList = gson.fromJson(orderForm.getItem(), new TypeToken<List<OrderDetail>>() {
           }.getType());
       }catch (Exception e){
           e.printStackTrace();
       }
       orderDTO.setOrderDetailList(orderDetailList);
       return orderDTO;
    }
}

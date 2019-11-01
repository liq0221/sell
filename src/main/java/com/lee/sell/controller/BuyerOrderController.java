package com.lee.sell.controller;

import com.lee.sell.convert.OrderForm2OrderDTO;
import com.lee.sell.enums.ResultEnum;
import com.lee.sell.exception.SellException;
import com.lee.sell.form.OrderForm;
import com.lee.sell.service.BuyerService;
import com.lee.sell.service.OrderService;
import com.lee.sell.utils.ResultVOUtil;
import com.lee.sell.vo.OrderDTO;
import com.lee.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PRARM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO order = OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(order.getOrderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTO = orderService.create(order);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());
        return ResultVOUtil.success(map);
    }
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> findList(@RequestParam("openid")String openid,
                                             @RequestParam(value = "page",defaultValue = "0")int page,
                                             @RequestParam(value = "size",defaultValue = "10") int size){
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PRARM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> list = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(list.getContent());
    }
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid")String openid,@RequestParam("orderId")String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid")String openid,@RequestParam("orderId")String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }
}

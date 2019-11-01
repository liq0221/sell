package com.lee.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRARM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUR_ERROR(14,"订单状态错误"),
    ORDER_UPDATE_FAIL(15,"订单状态更新失败"),
    ORDER_PAYSTATUS_ERROR(16,"订单支付状态不正确"),
    ORDER_OWNER_ERROR(17,"当前订单不属于此用户"),
    ORDER_CANCEL_SUCCESS(18,"订单取消成功"),
    ORDER_FINISH_SUCCESS(19,"订单完结成功"),
    ORDER_FINISH_FAIL(20,"订单完结失败"),
    PRODUCT_STATUS_ERROR(21,"商品状态错误");

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}

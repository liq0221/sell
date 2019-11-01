package com.lee.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0,"在架"),DOWN(1,"下架");

    private Integer code;

    private String statusName;

    ProductStatusEnum(Integer code, String statusName) {
        this.code = code;
        this.statusName = statusName;
    }
}

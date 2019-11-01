package com.lee.sell.exception;

import com.lee.sell.enums.ResultEnum;
import lombok.Data;

@Data
public class SellException extends RuntimeException {

    private String msg;

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String msg) {
       super(msg);
        this.code = code;
    }
}

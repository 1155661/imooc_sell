package com.example.sell.enums;

import lombok.Getter;

/**
 * 买家订单状态
 */
@Getter
public enum  OrderStatusEnums {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}

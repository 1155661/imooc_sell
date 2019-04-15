package com.example.sell.enums;

import lombok.Getter;

/**商品状态 */
@Getter
public enum ProductEnums {
    UP(0,"已上架"),
    DOWN(1,"已下架")
    ;

    private Integer code;
    private String message;

    ProductEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}

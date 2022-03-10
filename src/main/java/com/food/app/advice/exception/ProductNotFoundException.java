package com.food.app.advice.exception;

import com.food.app.advice.ErrorCodes;
import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException{

    private final int  code;

    public ProductNotFoundException(){
        super("Product Not found");
        this.code = ErrorCodes.PRODUCT_NOT_FOUND;
    }
}

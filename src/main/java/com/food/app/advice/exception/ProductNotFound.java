package com.food.app.advice.exception;

import com.food.app.advice.ErrorCodes;

public class ProductNotFound extends RuntimeException{

    private final int  code;

    public ProductNotFound(){
        super("Product Not found");
        this.code = ErrorCodes.PRODUCT_NOT_FOUND;
    }
}

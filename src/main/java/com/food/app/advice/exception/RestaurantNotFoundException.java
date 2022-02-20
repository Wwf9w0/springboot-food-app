package com.food.app.advice.exception;

import com.food.app.advice.ErrorCodes;

public class RestaurantNotFoundException extends RuntimeException{

    private final int  code;

    public RestaurantNotFoundException(){
        super("Restaurant Not found");
        this.code = ErrorCodes.RESTAURANT_NOT_FOUND;
    }
}

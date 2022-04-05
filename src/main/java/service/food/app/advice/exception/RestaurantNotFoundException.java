package service.food.app.advice.exception;

import service.food.app.advice.ErrorCodes;
import lombok.Getter;

@Getter
public class RestaurantNotFoundException extends RuntimeException{

    private final int  code;

    public RestaurantNotFoundException(){
        super("Restaurant Not found");
        this.code = ErrorCodes.RESTAURANT_NOT_FOUND;
    }
}

package com.food.app.advice;

import com.food.app.advice.exception.ProductNotFoundException;
import com.food.app.advice.exception.RestaurantNotFoundException;
import com.food.app.error.Error;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Error> handleException(ProductNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(consturctError(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Error> handleException (RestaurantNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(consturctError(e.getCode(), e.getMessage()));
    }

    private Error consturctError(final int code, final String message) {
        return Error.builder()
                .code(code)
                .message(message)
                .timestamp(new DateTime().getMillis())
                .build();
    }
}

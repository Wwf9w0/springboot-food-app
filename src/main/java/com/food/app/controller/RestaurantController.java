package com.food.app.controller;

import com.food.app.Service.RestaurantService;
import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    @ApiOperation(value = "List Restaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
        List<Restaurant> restaurantList = restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurantList);
    }

    @PostMapping(value = "/create/restaurant")
    @ApiOperation(value = "Create Restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
      Restaurant res = restaurantService.save(restaurant);
      return ResponseEntity.ok(res);
    }

}

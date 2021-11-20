package com.food.app.controller;

import com.food.app.Service.RestaurantService;
import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public ResponseEntity<Object> getAllRestaurant(){
        List<Restaurant> restaurantList = restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurantList);
    }

    @PostMapping(value = "/restaurant")
    public ResponseEntity<Object> createRestaurant(@RequestBody Restaurant restaurant){
      Restaurant res = restaurantService.save(restaurant);
      return ResponseEntity.ok(res);
    }

}

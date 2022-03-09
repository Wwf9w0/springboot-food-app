package com.food.app.controller;

import com.food.app.Service.RestaurantService;
import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.RestaurantEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    @ApiOperation(value = "List Restaurant")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurant(){
        List<RestaurantDto> restaurantList = restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurantList);
    }

    @PostMapping(value = "/create/restaurant")
    @ApiOperation(value = "Create Restaurant")
    public ResponseEntity<RestaurantEntity> createRestaurant(@RequestBody RestaurantRequest restaurant){
      RestaurantEntity res = restaurantService.save(restaurant);
      return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Issue By Id")
    public ResponseEntity<RestaurantEntity> getByRestaurant(@PathVariable String name){
        Optional<RestaurantEntity> restaurant = restaurantService.getByRestaurantName(name);
        return ResponseEntity.ok(restaurant.get());
    }

}

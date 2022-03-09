package com.food.app.controller;

import com.food.app.Service.RestaurantService;
import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.RestaurantEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(restaurantService.getAllRestaurant());
    }

    @PostMapping(value = "/create/restaurant")
    @ApiOperation(value = "Create Restaurant")
    public ResponseEntity<RestaurantEntity> createRestaurant(@RequestBody RestaurantEntity restaurant){
      RestaurantEntity res = restaurantService.save(restaurant);
      return ResponseEntity.ok(res);
    }

    @GetMapping("/{name}")
    @ApiOperation("Get Restaurant By Name")
    public ResponseEntity<RestaurantDto> getByRestaurant(@PathVariable String name){
        return ResponseEntity.ok(restaurantService.getRestaurantByName(name));
    }
}

package com.food.app.Service;

import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.RestaurantEntity;
import com.food.app.persistence.jpa.repository.RestaurantRespository;
import com.food.app.persistence.jpa.service.RestaurantPersistanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantPersistanceService restaurantPersistanceService;
    private final RestaurantRespository restaurantRespository;

    public RestaurantEntity save(RestaurantEntity restaurant){
        return restaurantPersistanceService.save(restaurant);
    }

    public List<RestaurantDto> getAllRestaurant(){
        return restaurantPersistanceService.getAllRestaurants();
    }

    public RestaurantDto getRestaurantByName(String name){
        return restaurantPersistanceService.getRestaurantByName(name);
    }

}

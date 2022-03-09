package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.converter.RestaurantConverter;
import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.RestaurantEntity;
import com.food.app.persistence.jpa.repository.RestaurantRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantPersistanceService {

    private final RestaurantRespository restaurantRespository;
    private final RestaurantConverter restaurantConverter;

    public Optional<RestaurantEntity> getByRestaurantName(String name) {
        return restaurantRespository.findByName(name);
    }

    public RestaurantEntity saveRestaurant(RestaurantRequest request){
        log.info("Created Restaurant : {}" , request.toString());
        RestaurantEntity restaurant = restaurantConverter.toRestaurantEntity(request);
        return restaurantRespository.save(restaurant);
    }

    public void deleteRestaurant(Long id){
        log.info("Deleted Resturant id : {}", id);
        restaurantRespository.deleteById(id);
    }

    public List<RestaurantDto> getAllRestaurant(){
        List<RestaurantEntity> restaurant = restaurantRespository.findAll();
        List<RestaurantDto> restaurantDtoList = restaurantConverter.toRestaurantDtoList(restaurant);
        return restaurantDtoList;
    }
}

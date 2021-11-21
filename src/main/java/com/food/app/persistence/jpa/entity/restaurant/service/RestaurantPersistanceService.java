package com.food.app.persistence.jpa.entity.restaurant.service;

import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import com.food.app.persistence.jpa.entity.restaurant.repository.RestaurantRespository;
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

    public Optional<Restaurant> getByRestaurantName(String name) {
        return restaurantRespository.findByName(name);
    }

    public Restaurant saveRestaurant(Restaurant restaurant){
        log.info("Created Restaurant : {}" , restaurant.toString());
        return restaurantRespository.save(restaurant);
    }

    public void deleteRestaurant(Long id){
        log.info("Deleted Resturant id : {}", id);
        restaurantRespository.deleteById(id);
    }

    public List<Restaurant> getAllRestaurant(){
        return (List<Restaurant>) restaurantRespository.findAll();
    }


}

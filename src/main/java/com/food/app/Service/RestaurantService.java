package com.food.app.Service;

import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import com.food.app.persistence.jpa.entity.restaurant.repository.RestaurantRespository;
import com.food.app.persistence.jpa.entity.restaurant.service.RestaurantPersistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantPersistanceService restaurantPersistanceService;
    private final RestaurantRespository restaurantRespository;

    public List<Restaurant> getAllRestaurant() {
        return restaurantPersistanceService.getAllRestaurant();
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantPersistanceService.createRestaurant(restaurant);
    }

    public Optional<Restaurant> getByRestaurantName(String name) {
        Optional<Restaurant> restaurant = restaurantRespository.findByName(name);
        if (!Objects.nonNull(restaurant)) {
            return null;
        }

        return restaurantPersistanceService.getByRestaurantName(name);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {

        Optional<Restaurant> res = restaurantRespository.findById(restaurant.getId());

        if (!Objects.nonNull(res)) {
            return null;
        }

        return restaurantPersistanceService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantPersistanceService.deleteRestaurant(id);
    }


}

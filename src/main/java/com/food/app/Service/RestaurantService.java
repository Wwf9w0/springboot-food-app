package com.food.app.Service;

import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import com.food.app.persistence.jpa.entity.restaurant.repository.RestaurantRespository;
import com.food.app.persistence.jpa.entity.restaurant.service.RestaurantPersistanceService;
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

    public List<Restaurant> getAllRestaurant() {
        return restaurantPersistanceService.getAllRestaurant();
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantPersistanceService.saveRestaurant(restaurant);
    }

    public Optional<Restaurant> getByRestaurantName(String name) {
        Optional<Restaurant> restaurant = restaurantRespository.findByName(name);
        if (!Objects.nonNull(restaurant)) {
            return null;
        }

        return restaurantPersistanceService.getByRestaurantName(name);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {

        Optional<Restaurant> optRes = restaurantRespository.findById(restaurant.getId());
        Restaurant res = optRes.get();

        if (optRes.isPresent()) {
            res.setAddress(optRes.get().getAddress());
            res.setCity(optRes.get().getCity());
            res.setName(optRes.get().getName());
            restaurantPersistanceService.saveRestaurant(res);
            log.info("Restaurant Updated id : {}", res.getId());

        }

        return restaurantPersistanceService.saveRestaurant(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantPersistanceService.deleteRestaurant(id);
    }


}

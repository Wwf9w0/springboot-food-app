package com.food.app.Service;

import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import com.food.app.persistence.jpa.entity.restaurant.entity.RestaurantRequest;
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

    public List<RestaurantDto> getAllRestaurant() {
        return restaurantPersistanceService.getAllRestaurant();
    }

    public Restaurant save(RestaurantRequest request) {
        return restaurantPersistanceService.saveRestaurant(request);
    }

    public Optional<Restaurant> getByRestaurantName(String name) {
        Optional<Restaurant> restaurant = restaurantRespository.findByName(name);
        if (!Objects.nonNull(restaurant)) {
            return null;
        }

        return restaurantPersistanceService.getByRestaurantName(name);
    }

    public Restaurant updateRestaurant(RestaurantRequest resquest) {

        Optional<Restaurant> optRes = restaurantRespository.findById(resquest.getId());

        if (optRes.isPresent()) {
            restaurantPersistanceService.saveRestaurant(resquest);
            log.info("Restaurant Updated id : {}", resquest.getId());

        }

        return restaurantPersistanceService.saveRestaurant(resquest);
    }

    public void deleteRestaurant(Long id) {
        restaurantPersistanceService.deleteRestaurant(id);
    }


}

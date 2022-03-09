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

    public List<RestaurantDto> getAllRestaurant() {
        return restaurantPersistanceService.getAllRestaurant();
    }

    public RestaurantEntity save(RestaurantRequest request) {
        return restaurantPersistanceService.saveRestaurant(request);
    }

    public Optional<RestaurantEntity> getByRestaurantName(String name) {
        Optional<RestaurantEntity> restaurant = restaurantRespository.findByName(name);
        if (!Objects.nonNull(restaurant)) {
            return null;
        }

        return restaurantPersistanceService.getByRestaurantName(name);
    }

    public RestaurantEntity updateRestaurant(RestaurantRequest resquest) {

        Optional<RestaurantEntity> optRes = restaurantRespository.findById(resquest.getId());

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

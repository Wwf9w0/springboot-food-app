package service.food.app.persistence.jpa.service;

import service.food.app.persistence.jpa.converter.RestaurantConverter;
import service.food.app.persistence.jpa.dto.RestaurantDto;
import service.food.app.persistence.jpa.entity.RestaurantEntity;
import service.food.app.persistence.jpa.repository.RestaurantRespository;
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

    public RestaurantEntity save(RestaurantEntity restaurantEntity) {
        return restaurantRespository.save(restaurantEntity);
    }

    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantEntity> restaurantEntities = restaurantRespository.findAll();
        return restaurantConverter.toRestaurantDtoList(restaurantEntities);
    }

    public RestaurantDto getRestaurantByName(String name) {
        Optional<RestaurantEntity> restaurant = restaurantRespository.findByName(name);
        return restaurantConverter.toRestaurantDto(restaurant.get());
    }
}

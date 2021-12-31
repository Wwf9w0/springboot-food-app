package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantConverter {

    public RestaurantDto toDto(Restaurant restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .city(restaurant.getCity())
                .build();
    }
}

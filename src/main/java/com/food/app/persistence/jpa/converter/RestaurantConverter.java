package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.RestaurantDto;
import com.food.app.persistence.jpa.entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RestaurantConverter {

    public  RestaurantDto toRestaurantDto(RestaurantEntity restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .city(restaurant.getCity())
                .build();
    }

    public List<RestaurantDto> toRestaurantDtoList(List<RestaurantEntity> restaurants){
        return restaurants.stream().map(restaurantEntity -> RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .city(restaurantEntity.getCity())
                .address(restaurantEntity.getAddress())
                .build()).collect(Collectors.toList());
    }
}

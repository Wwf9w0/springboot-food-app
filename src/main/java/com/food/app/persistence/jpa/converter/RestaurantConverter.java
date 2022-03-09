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

    public static RestaurantDto toRestaurantDto(RestaurantEntity restaurant){
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .city(restaurant.getCity())
                .build();
    }

    public List<RestaurantDto> toRestaurantDtoList(List<RestaurantEntity> restaurants){
        return restaurants.stream().map(RestaurantConverter::toRestaurantDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public RestaurantEntity toRestaurantEntity(RestaurantRequest request){
        return RestaurantEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .build();
    }

    public RestaurantDto toRestaurantName(String name){
        return RestaurantDto.builder()
                .name(name)
                .build();
    }
}

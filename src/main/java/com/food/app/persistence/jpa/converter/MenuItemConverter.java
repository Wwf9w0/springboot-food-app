package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.MenuItemDto;
import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemConverter {

    public MenuItemDto toMenuItemDto(MenuItem menuItem){
        return MenuItemDto.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .restaurantId(menuItem.getRestaurantId())
                .build();
    }
}

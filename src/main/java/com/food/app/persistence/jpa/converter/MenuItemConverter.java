package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.MenuItemDto;
import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuItemConverter {

    public List<MenuItemDto> toMenuItemDtoList(List<MenuItem> menuItem){
        return menuItem.stream().map(MenuItemConverter::toMenuItemDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static MenuItemDto toMenuItemDto(MenuItem menuItem){
        return MenuItemDto.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .restaurantId(menuItem.getRestaurantId())
                .build();
    }

    public MenuItemDto toDto(Optional<MenuItem> menuItem){
        return MenuItemDto.builder()
                .id(menuItem.get().getId())
                .name(menuItem.get().getName())
                .description(menuItem.get().getDescription())
                .restaurantId(menuItem.get().getRestaurantId())
                .build();
    }
}

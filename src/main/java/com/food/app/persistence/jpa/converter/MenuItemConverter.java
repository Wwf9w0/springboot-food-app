package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.MenuItemDto;
import com.food.app.persistence.jpa.entity.MenuItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuItemConverter {

    public List<MenuItemDto> toMenuItemDtoList(List<MenuItemEntity> menuItem){
        return menuItem.stream().map(menuItemEntity -> MenuItemDto.builder()
                .id(menuItemEntity.getId())
                .name(menuItemEntity.getName())
                .restaurantId(menuItemEntity.getRestaurantId())
                .description(menuItemEntity.getDescription())
                .price(menuItemEntity.getPrice())
                .build()).collect(Collectors.toList());
    }

    public  MenuItemDto toMenuItemDto(MenuItemEntity menuItem){
        return MenuItemDto.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .description(menuItem.getDescription())
                .price(menuItem.getPrice())
                .restaurantId(menuItem.getRestaurantId())
                .build();
    }

    public MenuItemDto toMenuItemDto(Optional<MenuItemEntity> menuItem){
        return MenuItemDto.builder()
                .id(menuItem.get().getId())
                .name(menuItem.get().getName())
                .description(menuItem.get().getDescription())
                .restaurantId(menuItem.get().getRestaurantId())
                .build();
    }
}

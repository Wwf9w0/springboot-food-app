package com.food.app.Service;

import com.food.app.persistence.jpa.converter.MenuItemConverter;
import com.food.app.persistence.jpa.dto.MenuItemDto;
import com.food.app.persistence.jpa.entity.MenuItemEntity;
import com.food.app.persistence.jpa.repository.MenuItemrepository;
import com.food.app.persistence.jpa.service.MenuItemPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemService {

    private final MenuItemPersistenceService menuItemPersistenceService;
    private final MenuItemrepository menuItemrepository;
    private final MenuItemConverter converter;

    public List<MenuItemDto> getAllMenuItem() {
        List<MenuItemEntity> menuItem = menuItemPersistenceService.getAllMenuItem();
        return converter.toMenuItemDtoList(menuItem);
    }

    public Optional<MenuItemDto> getByIdMenuItem(Long id) {

        Optional<MenuItemEntity> menuItem = menuItemrepository.findById(id);
        if (!Objects.nonNull(menuItem)) {
            return null;
        }
        return Optional.ofNullable(converter.toDto(menuItem));
    }


    public MenuItemEntity createMenuItem(MenuItemEntity menuItem) {
        Optional<MenuItemEntity> m = menuItemrepository.findById(menuItem.getId());

        if (m.isPresent()) {
            updateMenuItem(menuItem);
        }
        return menuItemPersistenceService.save(menuItem);
    }

    public MenuItemEntity updateMenuItem(MenuItemEntity menuItem) {

        Optional<MenuItemEntity> menuItemOptional = menuItemrepository.findById(menuItem.getId());
        MenuItemEntity item = menuItemOptional.get();
        if (menuItemOptional.isPresent()) {
            item.setId(menuItemOptional.get().getId());
            item.setDescription(menuItemOptional.get().getDescription());
            item.setName(menuItemOptional.get().getName());
            item.setRestaurantId(menuItemOptional.get().getRestaurantId());
            menuItemrepository.save(item);
            log.info("Menu Item Updated id : {}", item.getId());

        }

        return menuItemPersistenceService.save(menuItem);
    }
}

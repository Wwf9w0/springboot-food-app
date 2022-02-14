package com.food.app.Service;

import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import com.food.app.persistence.jpa.entity.restaurant.repository.MenuItemrepository;
import com.food.app.persistence.jpa.entity.restaurant.service.MenuItemPersistenceService;
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

    public List<MenuItem> getAllMenuItem() {
        return menuItemPersistenceService.getAllMenuItem();
    }

    public Optional<MenuItem> getByIdMenuItem(Long id) {

        Optional<MenuItem> menuItem = menuItemrepository.findById(id);
        if (!Objects.nonNull(menuItem)) {
            return null;
        }
        return menuItem;
    }


    public MenuItem createMenuItem(MenuItem menuItem) {
        Optional<MenuItem> m = menuItemrepository.findById(menuItem.getId());

        if (m.isPresent()) {
            updateMenuItem(menuItem);
        }
        return menuItemPersistenceService.save(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {

        Optional<MenuItem> menuItemOptional = menuItemrepository.findById(menuItem.getId());
        MenuItem item = menuItemOptional.get();
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

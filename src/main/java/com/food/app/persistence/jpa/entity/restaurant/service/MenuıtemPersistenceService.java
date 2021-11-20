package com.food.app.persistence.jpa.entity.restaurant.service;

import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import com.food.app.persistence.jpa.entity.restaurant.repository.MenuItemrepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuıtemPersistenceService  {

    private final MenuItemrepository menuItemrepository;

    public Optional<MenuItem> findByRestaurantId(Long id) {
        return menuItemrepository.findByRestaurantId(id);
    }

    public Optional<MenuItem> findByName(String name) {
        return menuItemrepository.findByName(name);
    }
    
    public MenuItem createMenuItem(MenuItem menuItem){
        return menuItemrepository.save(menuItem);
    }
    
    public MenuItem updateMenuItem(MenuItem menuItem){
        return menuItemrepository.save(menuItem);
    }
}

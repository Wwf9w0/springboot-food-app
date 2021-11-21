package com.food.app.persistence.jpa.entity.restaurant.service;

import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import com.food.app.persistence.jpa.entity.restaurant.repository.MenuItemrepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemPersistenceService {

    private final MenuItemrepository menuItemrepository;

    public Optional<MenuItem> getByName(String name) {
        log.info("Find MenuItem Name: {}", name);
        return menuItemrepository.findByName(name);
    }

    public List<MenuItem> getAllMenuItem() {
        return (List<MenuItem>) menuItemrepository.findAll();
    }

    public MenuItem save(MenuItem menuItem) {
        log.info("Created MenuItem : {}", menuItem);
        return menuItemrepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        log.info("Delete MenuItem id : {}", id);
        menuItemrepository.deleteById(id);
    }
}

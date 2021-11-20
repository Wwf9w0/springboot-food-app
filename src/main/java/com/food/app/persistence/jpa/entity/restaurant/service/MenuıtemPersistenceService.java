package com.food.app.persistence.jpa.entity.restaurant.service;

import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import com.food.app.persistence.jpa.entity.restaurant.repository.MenuItemrepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

 import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuıtemPersistenceService  {

    private final MenuItemrepository menuItemrepository;

    public Optional<MenuItem> getByName(String name) {
        log.info("Find MenuItem Name: {}" , name);
        return menuItemrepository.findByName(name);
    }
    
    public MenuItem createMenuItem(MenuItem menuItem){
        log.info("Created MenuItem : {}" , menuItem);
        return menuItemrepository.save(menuItem);
    }
    
    public MenuItem updateMenuItem(MenuItem menuItem){
        log.info("MenuItem Updated id : {}", menuItem.getId());
        return menuItemrepository.save(menuItem);
    }

    public void deleteMenuItem(Long id){
        log.info("Delete MenuItem id : {}", id);
        menuItemrepository.deleteById(id);
    }
}

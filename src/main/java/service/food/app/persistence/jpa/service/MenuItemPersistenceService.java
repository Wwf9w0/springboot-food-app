package service.food.app.persistence.jpa.service;

import service.food.app.persistence.jpa.entity.MenuItemEntity;
import service.food.app.persistence.jpa.repository.MenuItemrepository;
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

    public Optional<MenuItemEntity> getByName(String name) {
        log.info("Find MenuItem Name: {}", name);
        return menuItemrepository.findByName(name);
    }

    public List<MenuItemEntity> getAllMenuItem() {
        return (List<MenuItemEntity>) menuItemrepository.findAll();
    }

    public MenuItemEntity save(MenuItemEntity menuItem) {
        log.info("Created MenuItem : {}", menuItem);
        return menuItemrepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        log.info("Delete MenuItem id : {}", id);
        menuItemrepository.deleteById(id);
    }
}

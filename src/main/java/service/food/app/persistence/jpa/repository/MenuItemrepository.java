package service.food.app.persistence.jpa.repository;

import service.food.app.persistence.jpa.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemrepository extends JpaRepository<MenuItemEntity, Long> {

    Optional<MenuItemEntity> findByName(String name);
}

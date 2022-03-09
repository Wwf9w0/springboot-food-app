package com.food.app.persistence.jpa.repository;

import com.food.app.persistence.jpa.entity.MenuItemEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface MenuItemrepository extends CrudRepository<MenuItemEntity, Long> {

    Optional<MenuItemEntity> findByName(String name);
}

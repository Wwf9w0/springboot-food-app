package com.food.app.persistence.jpa.entity.restaurant.repository;

import com.food.app.persistence.jpa.entity.restaurant.entity.MenuItem;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface MenuItemrepository extends CrudRepository<MenuItem, Long> {

    Optional<MenuItem> findByName(String name);
}

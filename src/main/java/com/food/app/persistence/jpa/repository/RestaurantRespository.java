package com.food.app.persistence.jpa.repository;

import com.food.app.persistence.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRespository extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByName(String name);
}

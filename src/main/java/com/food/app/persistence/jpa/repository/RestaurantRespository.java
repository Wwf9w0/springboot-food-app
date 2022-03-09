package com.food.app.persistence.jpa.repository;

import com.food.app.persistence.jpa.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRespository extends CrudRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByName(String name);
    List<RestaurantEntity> findAll();

}

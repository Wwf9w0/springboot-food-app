package com.food.app.persistence.jpa.entity.restaurant.repository;

import com.food.app.persistence.jpa.entity.restaurant.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRespository extends CrudRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String name);
    List<Restaurant> findAll();

}

package com.food.app.persistence.jpa.entity.product.repository;

import com.food.app.persistence.jpa.entity.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}

package com.food.app.persistence.jpa.entity.category.repository;

import com.food.app.persistence.jpa.entity.category.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

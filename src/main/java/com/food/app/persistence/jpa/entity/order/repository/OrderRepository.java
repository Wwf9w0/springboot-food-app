package com.food.app.persistence.jpa.entity.order.repository;

import com.food.app.persistence.jpa.entity.order.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}

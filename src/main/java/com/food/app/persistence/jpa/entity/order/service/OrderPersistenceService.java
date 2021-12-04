package com.food.app.persistence.jpa.entity.order.service;

import com.food.app.persistence.jpa.entity.order.entity.Order;
import com.food.app.persistence.jpa.entity.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderPersistenceService {

    private final OrderRepository orderRepository;

    public Order save(Order order){
       log.info("Order saved : {}" , order);
       return orderRepository.save(order);
    }

    public List<Order> getOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    public void deleteOrderById(Long id){
        log.info("Delete order id: {}", id);
        orderRepository.deleteById(id);
    }
}

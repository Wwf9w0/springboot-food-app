package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.entity.OrderEntity;
import com.food.app.persistence.jpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderPersistenceService {

    private final OrderRepository orderRepository;

    public OrderEntity save(OrderEntity order){
       log.info("Order saved : {}" , order);
       return orderRepository.save(order);
    }

    public List<OrderEntity> getOrders(){
        return (List<OrderEntity>) orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    public void deleteOrderById(Long id){
        log.info("Delete order id: {}", id);
        orderRepository.deleteById(id);
    }

    public String name(String name){
        return name;
    }
}

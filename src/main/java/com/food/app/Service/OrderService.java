package com.food.app.Service;

import com.food.app.persistence.jpa.entity.OrderEntity;
import com.food.app.persistence.jpa.service.OrderPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderPersistenceService orderPersistenceService;


    public OrderEntity save(OrderEntity order) {
        if (Objects.nonNull(order.getTotalPrice())) {
            orderPersistenceService.save(order);
        }
        return order;
    }

    public List<OrderEntity> getOrders() {
        return orderPersistenceService.getOrders();
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        Optional<OrderEntity> optionalOrder = orderPersistenceService.getOrderById(id);

        if (!Objects.nonNull(optionalOrder)) {
            return null;
        }

        return optionalOrder;
    }

    public OrderEntity updateOrder(OrderEntity order) {

        Optional<OrderEntity> optionalOrder = orderPersistenceService.getOrderById(order.getId());
        OrderEntity o = optionalOrder.get();

        if (optionalOrder.isPresent()) {
            o.setId(optionalOrder.get().getId());
            o.setNote(optionalOrder.get().getNote());
            o.setProducts(optionalOrder.get().getProducts());
            o.setTotalPrice(optionalOrder.get().getTotalPrice());
            orderPersistenceService.save(o);
        }
        return orderPersistenceService.save(order);

    }

    public void deleteOrderById(Long id) {
        orderPersistenceService.deleteOrderById(id);

    }
}

package com.food.app.Service;

import com.food.app.persistence.jpa.entity.order.entity.Order;
import com.food.app.persistence.jpa.entity.order.service.OrderPersistenceService;
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


    public Order save(Order order) {
        if (Objects.nonNull(order.getTotalPrice())) {
            orderPersistenceService.save(order);
        }
        return order;
    }

    public List<Order> getOrders() {
        return orderPersistenceService.getOrders();
    }

    public Optional<Order> getOrderById(Long id) {
        Optional<Order> optionalOrder = orderPersistenceService.getOrderById(id);

        if (!Objects.nonNull(optionalOrder)) {
            return null;
        }

        return optionalOrder;
    }

    public Order updateOrder(Order order) {

        Optional<Order> optionalOrder = orderPersistenceService.getOrderById(order.getId());
        Order o = optionalOrder.get();

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

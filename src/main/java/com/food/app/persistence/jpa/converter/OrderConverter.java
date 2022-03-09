package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.OrderDto;
import com.food.app.persistence.jpa.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderDto toOrderDto (OrderEntity order){
        return OrderDto.builder()
                .id(order.getId())
                .note(order.getNote())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}

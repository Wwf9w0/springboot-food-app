package service.food.app.persistence.jpa.converter;

import service.food.app.persistence.jpa.dto.OrderDto;
import service.food.app.persistence.jpa.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    public  OrderDto toOrderDto (OrderEntity order){
        return OrderDto.builder()
                .id(order.getId())
                .note(order.getNote())
                .totalPrice(order.getTotalPrice())
                .build();
    }

    public List<OrderDto> toOrderDtoList (List<OrderEntity> orderDtos){
        return orderDtos.stream().map(orderEntity -> OrderDto.builder()
                .id(orderEntity.getId())
                .note(orderEntity.getNote())
                .totalPrice(orderEntity.getTotalPrice())
                .build()).collect(Collectors.toList());
    }
}

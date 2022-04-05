package service.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDto {

    private Long id;
    private BigDecimal totalPrice;
    private String note;
}

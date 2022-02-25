package com.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MenuItemDto {

    private Long id;
    private String name;
    private String restaurantId;
    private String description;
    private BigDecimal price;
}

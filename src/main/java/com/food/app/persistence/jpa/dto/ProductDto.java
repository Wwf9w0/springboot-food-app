package com.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private BigDecimal price;
    private String description;
}

package com.food.app.persistence.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Long id;
    private String categoryName;
}

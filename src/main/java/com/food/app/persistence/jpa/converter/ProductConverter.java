package com.food.app.persistence.jpa.converter;

import com.food.app.persistence.jpa.dto.ProductDto;
import com.food.app.persistence.jpa.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    public ProductDto toProductDto (ProductEntity product){
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

package service.food.app.persistence.jpa.converter;

import service.food.app.persistence.jpa.dto.ProductDto;
import service.food.app.persistence.jpa.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductDto> toProductDtoList(List<ProductEntity> productEntities){
        return productEntities.stream().map(product-> ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build()).collect(Collectors.toList());
    }


}

package com.food.app.persistence.jpa.service;

import com.food.app.advice.exception.ProductNotFoundException;
import com.food.app.persistence.jpa.converter.ProductConverter;
import com.food.app.persistence.jpa.dto.ProductDto;
import com.food.app.persistence.jpa.entity.ProductEntity;
import com.food.app.persistence.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPersistenceService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public List<ProductDto> getAllProduct() {
        List<ProductEntity> productEntities =  productRepository.findAll();
        if (Objects.isNull(productEntities)){
            return (List<ProductDto>) new  ProductNotFoundException();
        }
        return productConverter.toProductDtoList(productEntities);
    }

    public ProductDto getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        return productConverter.toProductDto(product.get());
    }

    public ProductEntity save(ProductEntity product) {
        log.info("Product Added");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        log.info("Product deleted id: {}", id);
    }

    public Long totalProduct() {
        List<ProductEntity> productList = productRepository.findAll();
        return productList.stream().count();
    }


}

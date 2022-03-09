package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.entity.ProductEntity;
import com.food.app.persistence.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPersistenceService {

    private final ProductRepository productRepository;

    public List<ProductEntity> getAllProduct(){
        return (List<ProductEntity>) productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id){
        return productRepository.findById(id);
    }

    public ProductEntity save(ProductEntity product){
        log.info("Product Added");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
        log.info("Product deleted id: {}" , id);
    }

    public Long totalProduct(){
        List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
        return productList.stream().count();
    }


}

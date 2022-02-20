package com.food.app.persistence.jpa.entity.product.service;

import com.food.app.persistence.jpa.entity.product.entity.Product;
import com.food.app.persistence.jpa.entity.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPersistenceService {

    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        log.info("Product Added");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
        log.info("Product deleted id: {}" , id);
    }

    public Long totalProduct(){
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList.stream().count();
    }


}

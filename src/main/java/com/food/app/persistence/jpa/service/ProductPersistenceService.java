package com.food.app.persistence.jpa.service;

import com.food.app.persistence.jpa.entity.Product;
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

    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
        log.info("Product deleted : {}" , id);
    }

    public Product updateProduct(Product product){
       Optional<Product> p = productRepository.findById(product.getId());

       if (!Objects.nonNull(p)){
           return null;
       }
       return productRepository.save(product);
    }


}

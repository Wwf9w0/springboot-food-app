package com.food.app.Service;

import com.food.app.persistence.jpa.entity.Product;
import com.food.app.persistence.jpa.repository.ProductRepository;
import com.food.app.persistence.jpa.service.ProductPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductPersistenceService productPersistenceService;
    private final ProductRepository productRepository;

    public void save(Product product){
        if(Objects.nonNull(product.getId())){
            productPersistenceService.addProduct(product);
        }
    }


    public void deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (Objects.nonNull(product.get().getId())){
            productPersistenceService.deleteProduct(product.get().getId());
        }
    }

    public void updateProduct(Product product){
        Optional<Product> p = productRepository.findById(product.getId());
        if (Objects.nonNull(p)){
            productPersistenceService.updateProduct(product);
        }

    }

}

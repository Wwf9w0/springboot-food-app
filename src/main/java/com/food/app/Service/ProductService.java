package com.food.app.Service;

import com.food.app.persistence.jpa.entity.product.entity.Product;
import com.food.app.persistence.jpa.entity.product.repository.ProductRepository;
import com.food.app.persistence.jpa.entity.product.service.ProductPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductPersistenceService productPersistenceService;
    private final ProductRepository productRepository;


    public Product save(Product product) {
        if (Objects.nonNull(product.getProductName())) {
            productPersistenceService.save(product);
        }
        return product;
    }


    public void deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (Objects.nonNull(product.get().getId())) {
            productPersistenceService.deleteProduct(product.get().getId());
        }
    }

    public Product updateProduct(Product product){
        Optional<Product> optionalProduct = productPersistenceService.getProductById(product.getId());
        Product p = optionalProduct.get();

        if (optionalProduct.isPresent()){
            p.setId(optionalProduct.get().getId());
            p.setProductName(optionalProduct.get().getProductName());
            p.setDescription(optionalProduct.get().getDescription());
            p.setPrice(optionalProduct.get().getPrice());
            p.setOrder(optionalProduct.get().getOrder());
            productPersistenceService.save(p);
        }
        return productPersistenceService.save(product);
    }

    public List<Product> getAllProduct() {
        return productPersistenceService.getAllProduct();

    }

    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productPersistenceService.getProductById(id);

        if (!Objects.nonNull(product)) {
            return null;
        }
        return product;
    }

}

package com.food.app.Service;

import com.food.app.persistence.jpa.entity.ProductEntity;
import com.food.app.persistence.jpa.repository.ProductRepository;
import com.food.app.persistence.jpa.service.ProductPersistenceService;
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


    public ProductEntity save(ProductEntity product) {
        if (Objects.nonNull(product.getProductName())) {
            productPersistenceService.save(product);
        }
        return product;
    }


    public void deleteProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (Objects.nonNull(product.get().getId())) {
            productPersistenceService.deleteProduct(product.get().getId());
        }
    }

    public ProductEntity updateProduct(ProductEntity product) {
        Optional<ProductEntity> optionalProduct = productPersistenceService.getProductById(product.getId());
        ProductEntity p = optionalProduct.get();

        if (optionalProduct.isPresent()) {
            p.setId(optionalProduct.get().getId());
            p.setProductName(optionalProduct.get().getProductName());
            p.setDescription(optionalProduct.get().getDescription());
            p.setPrice(optionalProduct.get().getPrice());
            p.setOrder(optionalProduct.get().getOrder());
            productPersistenceService.save(p);
        }
        return productPersistenceService.save(product);
    }

    public List<ProductEntity> getAllProduct() {
        return productPersistenceService.getAllProduct();

    }

    public Optional<ProductEntity> getProductById(Long id) {
        Optional<ProductEntity> product = productPersistenceService.getProductById(id);

        if (!Objects.nonNull(product)) {
            return null;
        }
        return product;
    }

    public Long toProductCount(){
        return productPersistenceService.totalProduct();
    }
}

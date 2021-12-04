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

    public Product updateProduct(Product product) {
        Optional<Product> productOptional = productPersistenceService.getProductById(product.getId());
        Product pr = productOptional.get();
        if (productOptional.isPresent()) {
            pr.setProductName(productOptional.get().getProductName());
            pr.setDescription(productOptional.get().getDescription());
            pr.setPrice(productOptional.get().getPrice());
            pr.setId(productOptional.get().getId());
            productPersistenceService.save(pr);
            log.info("Product Updated id  {}", pr.getId());

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

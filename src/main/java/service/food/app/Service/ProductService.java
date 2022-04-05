package service.food.app.Service;

import service.food.app.persistence.jpa.dto.ProductDto;
import service.food.app.persistence.jpa.entity.ProductEntity;
import service.food.app.persistence.jpa.repository.ProductRepository;
import service.food.app.persistence.jpa.service.ProductPersistenceService;
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

    public List<ProductDto> getAllProducts(){
        return productPersistenceService.getAllProduct();
    }


    public Long toProductCount(){
        return productPersistenceService.totalProduct();
    }
}

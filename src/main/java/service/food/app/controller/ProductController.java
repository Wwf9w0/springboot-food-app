package service.food.app.controller;

import service.food.app.Service.ProductService;
import service.food.app.persistence.jpa.dto.ProductDto;
import service.food.app.persistence.jpa.entity.ProductEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    @ApiOperation(value = "List Products")
    public ResponseEntity<List<ProductDto>> allProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/create/product")
    @ApiOperation(value = "Create Product")
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
        ProductEntity pr = productService.save(product);
        return ResponseEntity.ok(pr);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Delete Product")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total/product")
    public ResponseEntity<Long> totalProductCount() {
        return ResponseEntity.ok(productService.toProductCount());
    }
}

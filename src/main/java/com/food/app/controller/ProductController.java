package com.food.app.controller;

import com.food.app.Service.ProductService;
import com.food.app.persistence.jpa.entity.ProductEntity;
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
    public ResponseEntity<List<ProductEntity>> allProducts() {
        List<ProductEntity> p = productService.getAllProduct();
        return ResponseEntity.ok(p);
    }

    @PostMapping("/create/product")
    @ApiOperation(value = "Create Product")
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
        ProductEntity pr = productService.save(product);
        return ResponseEntity.ok(pr);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Delete Product")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total/product")
    public ResponseEntity<Long> totalProductCount(){
        return ResponseEntity.ok(productService.toProductCount());
    }
}

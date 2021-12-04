package com.food.app.controller;

import com.food.app.Service.ProductService;
import com.food.app.persistence.jpa.entity.product.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Api(value = "Food Management")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    @ApiOperation(value = "List Products")
    public ResponseEntity<Object> allProducts() {
        List<Product> p = productService.getAllProduct();
        return ResponseEntity.ok(p);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Create Product")
    public ResponseEntity<Object> save(@RequestBody Product product) {
        Product pr = productService.save(product);
        return ResponseEntity.ok(pr);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Delete Product")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}

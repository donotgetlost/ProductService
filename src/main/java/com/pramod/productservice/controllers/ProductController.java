package com.pramod.productservice.controllers;

import com.pramod.productservice.models.Product;
import com.pramod.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        return productService.getAllProducts();
    }
}

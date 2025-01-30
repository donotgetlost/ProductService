package com.pramod.productservice.controllers;

import com.pramod.productservice.exceptions.ProductNotFoundException;
import com.pramod.productservice.models.Product;
import com.pramod.productservice.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
      //  ResponseEntity<Product> response = null;
//        try {
//            Product product = productService.getProductById(id);
//            response = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e) {
//          response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return response;
       // return ResponseEntity.ok(productService.getProductById(id));
       // throw new RuntimeException();
        Product product = productService.getProductById(id);
//        if(product == null) {
//            throw new ProductNotFoundException()
//        }
            return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product) {
     return productService.replaceProductById(id, product);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
      return productService.createProduct(product);
    }
}

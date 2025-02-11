package com.pramod.productservice.controllers;

import com.pramod.productservice.commons.AuthCommon;
import com.pramod.productservice.dtos.UserDto;
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
    private AuthCommon authCommon;

    ProductController(ProductService productService, AuthCommon authCommon) {

        this.productService = productService;
        this.authCommon = authCommon;
    }

    @GetMapping("/{id}")
    //removed this from param after oauth impl , @RequestHeader("authToken") String token
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
        ResponseEntity<Product> response;
       // UserDto userDto = authCommon.validateToken(token);
//        if(userDto == null) {
//            response = new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
//            return response;
//        }

        //Role Based Access.
//        for (Role role : userDto.getRoles()) {
//            if (role.getValue().equals("ADMIN")) {
//                //provide access.
//            }
//        }


        Product product = productService.getProductById(id);
//        if(product == null) {
//            throw new ProductNotFoundException()
//        }
        response = new ResponseEntity<>(product, HttpStatus.OK);
            return response;

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

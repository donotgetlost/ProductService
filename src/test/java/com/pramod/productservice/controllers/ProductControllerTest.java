package com.pramod.productservice.controllers;

import com.pramod.productservice.exceptions.ProductNotFoundException;
import com.pramod.productservice.models.Product;
import com.pramod.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;


//    @Test
//    void testValidGetProductById() throws ProductNotFoundException {
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("Macbook pro");
//        product.setPrice(150000.0);
//
//        when(productService.getProductById(1L))
//                .thenReturn(product);
//
//        ResponseEntity<Product> responseEntity = productController.getProductById(1L, null);
//        Product actualProduct = responseEntity.getBody();
//
//        assertEquals(product, actualProduct);
//
//      //  assertSame();
//    }
}
package com.pramod.productservice.services;

import com.pramod.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();
}

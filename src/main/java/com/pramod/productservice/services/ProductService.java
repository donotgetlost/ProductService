package com.pramod.productservice.services;

import com.pramod.productservice.exceptions.ProductNotFoundException;
import com.pramod.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product replaceProductById(Long id, Product product);
}

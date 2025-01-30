package com.pramod.productservice.services.impl;

import com.pramod.productservice.exceptions.ProductNotFoundException;
import com.pramod.productservice.models.Category;
import com.pramod.productservice.models.Product;
import com.pramod.productservice.repositories.CategoryRepository;
import com.pramod.productservice.repositories.ProductRepository;
import com.pramod.productservice.services.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProductById(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        //Before saving product either have category or create
//        Category category = product.getCategory();
//        if (category.getId() == null) {
//          Category savedCategory = categoryRepository.save(category);
//          product.setCategory(savedCategory);
//        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct() {

    }
}

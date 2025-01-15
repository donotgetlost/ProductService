package com.pramod.productservice.services.impl;

import com.pramod.productservice.dtos.FakeStoreProductDto;
import com.pramod.productservice.models.Category;
import com.pramod.productservice.models.Product;
import com.pramod.productservice.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplate restTemplate;

    FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) {
    FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
     if(fakeStoreProductDto != null) {
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
     }

     return new Product();
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}

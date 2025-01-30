package com.pramod.productservice;

import com.pramod.productservice.models.Category;
import com.pramod.productservice.projections.ProductWithTitleAndDescription;
import com.pramod.productservice.repositories.CategoryRepository;
import com.pramod.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    @Transactional
//    public void testTC() {
//        Optional<Category> optionalCategory = categoryRepository.findById(1L);
//
//        Category category = optionalCategory.get();
//
//        System.out.println("Fetching products related to the above category");
//      //  List<Product> products = category.getProducts();
////        System.out.println(products.get(0).getTitle());
//
//        ProductWithTitleAndDescription productWithTitleAndDescription
//                = productRepository.someRandomQuery(3L);
//
//        System.out.println(productWithTitleAndDescription.getTitle());
//        System.out.println(productWithTitleAndDescription.getDescription());
//
//        ProductWithTitleAndDescription product =
//                productRepository.someOtherRandomQuery(3L);
//
//        System.out.println(product.getTitle());
//        System.out.println(product.getDescription());
//        System.out.println("DEBUG");
//    }

}

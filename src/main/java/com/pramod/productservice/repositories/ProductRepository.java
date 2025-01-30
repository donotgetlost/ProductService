package com.pramod.productservice.repositories;

import com.pramod.productservice.models.Product;
import com.pramod.productservice.projections.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);
    
    List<Product> findByTitle(String title);
    
    List<Product> findByTitleContaining(String title);

    @Override
    void delete(Product product);

    @Override
    Product save(Product entity);

    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);
}

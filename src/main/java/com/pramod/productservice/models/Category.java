package com.pramod.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String description;

//    @OneToMany(mappedBy = "category") //without mappedby it will create an another table category_products //(fetch = FetchType.EAGER)
//    private List<Product> products;
}

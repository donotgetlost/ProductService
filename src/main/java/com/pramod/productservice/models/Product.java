package com.pramod.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 @Entity
public class Product extends BaseModel {


    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn //naming foreign key if required
    private Category category;
    private int quantity;
    private String specialComments;
}
/*

 */
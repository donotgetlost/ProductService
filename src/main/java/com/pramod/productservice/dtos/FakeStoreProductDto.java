package com.pramod.productservice.dtos;



public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

package com.pramod.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    private long id;
    public ProductNotFoundException(long id, String message) {
        super(message);
        this.id = id;

    }
    public long getId() {
        return id;
    }
}

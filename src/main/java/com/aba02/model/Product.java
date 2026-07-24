package com.aba02.model;

public class Product {
    
    private Long id;
    private String name;
    private boolean active;
    private Double price;

    public Product() {
    }

    public Product(Long id, String name, boolean active, Double price) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

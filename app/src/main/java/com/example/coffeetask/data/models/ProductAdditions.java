package com.example.coffeetask.data.models;

public class ProductAdditions {
    private ProductAdditionsSubAdd[] subAdd;
    private int id;
    private String title;

    public ProductAdditionsSubAdd[] getSubAdd() {
        return this.subAdd;
    }

    public void setSubAdd(ProductAdditionsSubAdd[] subAdd) {
        this.subAdd = subAdd;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.example.coffeetask.data.models;

import java.util.List;

public class ProductAdditions {
    private List<ProductAdditionsSubAdd> subAdd;
    private int id;
    private String title;

    public List<ProductAdditionsSubAdd> getSubAdd() {
        return this.subAdd;
    }

    public void setSubAdd(List<ProductAdditionsSubAdd> subAdd) {
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

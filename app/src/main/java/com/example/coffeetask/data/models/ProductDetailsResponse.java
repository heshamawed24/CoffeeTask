package com.example.coffeetask.data.models;

public class ProductDetailsResponse {
    private String Status;
    private int code;
    private ProductModel productModel;

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProductModel getProductModel() {
        return this.productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }
}

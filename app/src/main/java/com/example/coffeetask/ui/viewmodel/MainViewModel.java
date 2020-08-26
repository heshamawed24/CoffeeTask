package com.example.coffeetask.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeetask.data.models.ProductDetailsResponse;
import com.example.coffeetask.data.repo.ProductRepo;

public class MainViewModel extends ViewModel {
    private   ProductRepo productRepo;
    public MainViewModel(){
        productRepo = new ProductRepo();
    }

    public MutableLiveData<ProductDetailsResponse> getProductDetails(int id, String type){
        return productRepo.getProductDetails(id,type);
    }
}
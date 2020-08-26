package com.example.coffeetask.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.coffeetask.data.api.ProductApi;
import com.example.coffeetask.data.models.ProductDetailsResponse;
import com.example.coffeetask.network.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepo {
    ProductApi productApi;
    private final MutableLiveData<ProductDetailsResponse> productDetails =
            new MutableLiveData<>();

    public ProductRepo(){
       productApi =  WebService.getInstance().getApi();
    }

    public MutableLiveData<ProductDetailsResponse> getProductDetails(int id, String type){
        productApi.getProductDetails(id,type).enqueue(new Callback<ProductDetailsResponse>() {
            @Override
            public void onResponse(Call<ProductDetailsResponse> call, Response<ProductDetailsResponse> response) {
              productDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ProductDetailsResponse> call, Throwable t) {
                Log.e("test",t.getMessage());
                productDetails.postValue(null);
            }
        });

        return productDetails;
    }
}

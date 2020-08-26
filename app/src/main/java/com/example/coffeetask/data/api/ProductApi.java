package com.example.coffeetask.data.api;

import com.example.coffeetask.data.models.ProductDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductApi {
    @FormUrlEncoded
    @POST("api/Product")
    Call<ProductDetailsResponse> getProductDetails(@Field("id") int id
            , @Field("type") String type);

}

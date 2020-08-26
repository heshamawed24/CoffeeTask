package com.example.coffeetask.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.coffeetask.R;
import com.example.coffeetask.data.models.ProductDetailsResponse;
import com.example.coffeetask.databinding.ActivityMainBinding;
import com.example.coffeetask.ui.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getProductDetails(1,"text").observe(this, new Observer<ProductDetailsResponse>() {
            @Override
            public void onChanged(ProductDetailsResponse productDetailsResponse) {
                Log.e("test",productDetailsResponse.getStatus());
            }
        });
    }
}
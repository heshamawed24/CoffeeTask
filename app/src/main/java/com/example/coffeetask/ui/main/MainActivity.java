package com.example.coffeetask.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.coffeetask.R;
import com.example.coffeetask.data.models.ProductModel;
import com.example.coffeetask.databinding.ActivityMainBinding;
import com.example.coffeetask.ui.adapter.AdditionAdapter;
import com.example.coffeetask.ui.viewmodel.MainViewModel;
import com.example.coffeetask.utilites.Urls;
import com.example.coffeetask.utilites.Utilities;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MainViewModel mViewModel;
    private int quantity = 1;
    private double total = 0;
    private double totalToPay = 0;
    private double price = 0;
    private double tax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getProductDetails(1, "text").observe(this, productDetailsResponse -> {
            if (productDetailsResponse != null)

                updateUi(productDetailsResponse.getProductModel());
        });

        binding.btnMinus.setOnClickListener(view -> {
            if (quantity > 1)
                quantity--;
            calculateTotalToPay();

        });
        binding.btnPlus.setOnClickListener(view -> {
            quantity++;
            calculateTotalToPay();

        });
    }

    private void updateUi(ProductModel product) {
        setTitle(product.getTitle());
        binding.tvProductTitle.setText(product.getTitle());
        binding.tvProductPrice.setText(product.getPrice());
        binding.tvTaxPrice.setText(product.getTax());
        price = Double.parseDouble(product.getPrice());
        tax = Double.parseDouble(product.getTax());
        calculateTotalToPay();
        Utilities.loadImage(binding.imageView, Urls.productImageUrl + product.getImg());
        binding.rvAdditions.setAdapter(new AdditionAdapter(product.getAdditions(), this));

    }

    private void calculateTotalToPay() {
        binding.tvProductQuantity.setText(String.valueOf(quantity));
        binding.tvTotalPrice.setText(String.valueOf(price * quantity));
        total = (price * quantity) + tax;
        binding.tvPayPrice.setText(String.valueOf(total));
    }
}
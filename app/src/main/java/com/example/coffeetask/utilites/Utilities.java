package com.example.coffeetask.utilites;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Utilities {
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load("http://goo.gl/gEgYUd")
                .into(imageView);
    }
}

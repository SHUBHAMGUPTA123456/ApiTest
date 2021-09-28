package com.example.apitest.Image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.apitest.databinding.ActivityImageWithRetrofitBinding;

public class ImageWithRetrofit extends AppCompatActivity {
    ActivityImageWithRetrofitBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageWithRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
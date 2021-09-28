package com.example.apitest.ShareOption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.apitest.R;
import com.example.apitest.databinding.ActivityShareIntentBinding;

public class ShareIntent extends AppCompatActivity {
ActivityShareIntentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShareIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myToolBar();
    }

    private void myToolBar() {
        binding.toolBar.setTitle("Share Option");
        binding.toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        binding.toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }
}
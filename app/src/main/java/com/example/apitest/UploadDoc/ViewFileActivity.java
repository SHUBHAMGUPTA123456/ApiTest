package com.example.apitest.UploadDoc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.apitest.databinding.ActivityViewFileBinding;

public class ViewFileActivity extends AppCompatActivity {
    ActivityViewFileBinding binding;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.webView.getSettings().setJavaScriptEnabled(true);
        String filename = getIntent().getStringExtra("myFile");
        Log.d("FileName", "View File: "+filename);
        //http://www3.nd.edu/~cpoellab/teaching/cse40816/android_tutorial.pdf
        //http://docs.google.com/gview?embedded=true&url=           https://docs.google.com/gview?embedded=true&url=

        binding.webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+filename);
    }
}
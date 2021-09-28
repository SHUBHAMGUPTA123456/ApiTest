package com.example.apitest.Qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.apitest.R;

public class QrCodeScanner extends AppCompatActivity {
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scanner);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
       startActivity(new Intent(QrCodeScanner.this, ScannedBarcodeActivity.class));
       finish();
        });
    }
}
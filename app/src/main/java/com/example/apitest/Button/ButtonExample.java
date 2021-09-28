package com.example.apitest.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apitest.R;

public class ButtonExample extends AppCompatActivity {
Button proceed,btnOne,btnTwo,btnThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_example);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        proceed = findViewById(R.id.proceed);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOne.setBackgroundColor(Color.YELLOW);
                btnTwo.setBackgroundColor(Color.GRAY);
                btnThree.setBackgroundColor(Color.GRAY);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTwo.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.GRAY);
                btnThree.setBackgroundColor(Color.GRAY);

            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnThree.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.GRAY);
                btnTwo.setBackgroundColor(Color.GRAY);
            }

        });
    }
}
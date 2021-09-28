package com.example.apitest.Login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.apitest.R;

public class RegisterPage extends AppCompatActivity {
    ImageView top_curve;
    EditText name,email,newPassword,mobileNo,cnfrmPass;
    TextView txtName,email_text, password_text, login_title,txtMobile,txtCPass;
    ImageView logo;
    LinearLayout new_user_layout;
    Button registerBtn;
    CardView login_card;
    String Name,Email,MobileN,CPass,NPass;
    Dialog dialog;
    TextView msgRegister;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mobileNo = findViewById(R.id.mobileNo);
        top_curve = findViewById(R.id.top_curve);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        email_text = findViewById(R.id.email_text);
        txtCPass = findViewById(R.id.txtCPass);
        newPassword = findViewById(R.id.newPassword);
        cnfrmPass = findViewById(R.id.cnfrmPass);
        password_text = findViewById(R.id.password_text);
        logo = findViewById(R.id.logo);
        login_title = findViewById(R.id.login_text);
        new_user_layout = findViewById(R.id.new_user_text);
        login_card = findViewById(R.id.login_card);
        txtName = findViewById(R.id.txtName);
        txtMobile = findViewById(R.id.txtMobile);
        registerBtn = findViewById(R.id.registerBtn);

        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        name.startAnimation(editText_anim);
        email.startAnimation(editText_anim);
        newPassword.startAnimation(editText_anim);
        mobileNo.startAnimation(editText_anim);
        cnfrmPass.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        txtName.startAnimation(field_name_anim);
        email_text.startAnimation(field_name_anim);
        txtMobile.startAnimation(field_name_anim);
        password_text.startAnimation(field_name_anim);
        txtCPass.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
        login_title.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);
        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_top);
        new_user_layout.startAnimation(new_user_anim);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = name.getText().toString().trim();
                Email = email.getText().toString().trim();
                MobileN = mobileNo.getText().toString().trim();
                NPass = newPassword.getText().toString().trim();
                CPass = cnfrmPass.getText().toString().trim();
            }
        });
    }
    public void login(View view) {
        startActivity(new Intent(this,Login.class));
    }
}
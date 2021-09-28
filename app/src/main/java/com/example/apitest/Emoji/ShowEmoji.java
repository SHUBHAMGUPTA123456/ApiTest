package com.example.apitest.Emoji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.apitest.R;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class ShowEmoji extends AppCompatActivity {
    LinearLayout lnrLay;
    ImageView emojiBtn,btnSend;
    EditText txtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_emoji);
        initVar();
        myToolbar();
        EmojiPopup popup = EmojiPopup.Builder.fromRootView(findViewById(R.id.rootView)).build(txtInput);
        emojiBtn.setOnClickListener(v -> {
            popup.toggle();
        });
        btnSend.setOnClickListener(v -> {
            EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater.from(v.getContext()).inflate(R.layout.emoji_text_view,lnrLay,false);
            emojiTextView.setText(txtInput.getText().toString());
            lnrLay.addView(emojiTextView);
            txtInput.getText().clear();
        });
    }
    private void myToolbar() {
        Toolbar toolBar= findViewById(R.id.toolBar);
        toolBar.setTitle("View Emoji");
        toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
    private void initVar() {
        lnrLay = findViewById(R.id.lnrLay);
        emojiBtn = findViewById(R.id.emojiBtn);
        btnSend = findViewById(R.id.btnSend);
        txtInput = findViewById(R.id.txtInput);
    }
}
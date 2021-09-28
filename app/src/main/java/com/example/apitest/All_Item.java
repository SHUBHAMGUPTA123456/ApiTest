package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apitest.Button.ButtonExample;
import com.example.apitest.Calendar.CalendarCustom;
import com.example.apitest.CardStack.CardStack;
import com.example.apitest.ChartBar.ChartStackBarActivity;
import com.example.apitest.CollapsingTool.CollapseTool;
import com.example.apitest.Emoji.ShowEmoji;
import com.example.apitest.Image.ImageWithRetrofit;
import com.example.apitest.Login.Login;
import com.example.apitest.Map.MapActivity;
import com.example.apitest.MultiImg.CropIntentActivity;
import com.example.apitest.MultiImg.EditSaveUploadImg;
import com.example.apitest.MultiImg.ImageEditor;
import com.example.apitest.MultiImg.ShowMultiImage;
import com.example.apitest.MultiImg.UploadImage;
import com.example.apitest.MultiRecyclerView.MainActivity;
import com.example.apitest.Qr.QrCodeScanner;
import com.example.apitest.RecyclerView.RecyclerViewEx;
import com.example.apitest.ShareOption.ShareIntent;
import com.example.apitest.UploadDoc.UploadDocument;
import com.example.apitest.Video.VideoShow;

public class All_Item extends AppCompatActivity {
    LinearLayout sqLite,menuPage,loginSec,dataBindSec,mapSection,btnSection,qrSection,imgUpload,imgEditor,showMultiImg,
            editSaveImg,cropIntent,collapseTool,showVdo,showCalendar,emojiSection,recSection,cardStack,uploadFile,shareIntent,
            uploadImage,multiRecyclerView;
    TextView goToChartBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__item);
        initVar();
        myToolbar();
        performMenu();
    }
    private void performMenu() {
        menuPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_Item.this, MenuActivity.class));
            }
        });
        sqLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_Item.this, SQLite_.class));
            }
        });
        loginSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_Item.this, Login.class));
            }
        });
        dataBindSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_Item.this, DataBindExample.class));
                finish();
            }
        });
        mapSection.setOnClickListener(v -> {
            startActivity(new Intent(this, MapActivity.class));
            finish();
        });
        btnSection.setOnClickListener(v -> {
            startActivity(new Intent(this, ButtonExample.class));
            finish();
        });
        qrSection.setOnClickListener(v -> {
            startActivity(new Intent(this, QrCodeScanner.class));
            finish();
        });
        imgUpload.setOnClickListener(v -> {
            startActivity(new Intent(this, UploadImage.class));
            finish();
        });
        imgEditor.setOnClickListener(v -> {
            startActivity(new Intent(this, ImageEditor.class));
            finish();
        });
        showMultiImg.setOnClickListener(v -> {
            startActivity(new Intent(this, ShowMultiImage.class));
            finish();
        });
        editSaveImg.setOnClickListener(v -> {
            startActivity(new Intent(this, EditSaveUploadImg.class));
            finish();
        });
        cropIntent.setOnClickListener(v -> {
            startActivity(new Intent(this, CropIntentActivity.class));
            finish();
        });
        collapseTool.setOnClickListener(v -> {
            startActivity(new Intent(this, CollapseTool.class));
            finish();
        });
        showVdo.setOnClickListener(v -> {
            startActivity(new Intent(this, VideoShow.class));
            finish();
        });
        showCalendar.setOnClickListener(v -> {
            startActivity(new Intent(this, CalendarCustom.class));
            finish();
        });
        emojiSection.setOnClickListener(v -> {
            startActivity(new Intent(this, ShowEmoji.class));
            finish();
        });
        recSection.setOnClickListener(v -> {
            startActivity(new Intent(this, RecyclerViewEx.class));
            finish();
        });
        cardStack.setOnClickListener(v -> {
            startActivity(new Intent(this, CardStack.class));
            finish();
        });
        shareIntent.setOnClickListener(v -> {
            startActivity(new Intent(this, ShareIntent.class));
            finish();
        });
        uploadFile.setOnClickListener(v -> {
            startActivity(new Intent(this, UploadDocument.class));
            finish();
        });
        uploadImage.setOnClickListener(v -> {
            startActivity(new Intent(this, ImageWithRetrofit.class));
            finish();
        });
        multiRecyclerView.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        goToChartBar.setOnClickListener(v -> {
            startActivity(new Intent(this, ChartStackBarActivity.class));
            finish();
        });
    }
    private void initVar() {
        sqLite = findViewById(R.id.sqLite);
        menuPage = findViewById(R.id.menuPage);
        loginSec = findViewById(R.id.loginSec);
        dataBindSec = findViewById(R.id.dataBindSec);
        mapSection = findViewById(R.id.mapSection);
        btnSection = findViewById(R.id.btnSection);
        qrSection = findViewById(R.id.qrSection);
        imgUpload = findViewById(R.id.imgUpload);
        imgEditor = findViewById(R.id.imgEditor);
        showMultiImg = findViewById(R.id.showMultiImg);
        editSaveImg = findViewById(R.id.editSaveImg);
        cropIntent = findViewById(R.id.cropIntent);
        collapseTool = findViewById(R.id.collapseTool);
        showVdo = findViewById(R.id.showVdo);
        showCalendar = findViewById(R.id.showCalendar);
        emojiSection = findViewById(R.id.emojiSection);
        recSection = findViewById(R.id.recSection);
        cardStack = findViewById(R.id.cardStack);
        shareIntent = findViewById(R.id.shareIntent);
        uploadFile = findViewById(R.id.uploadFile);
        uploadImage = findViewById(R.id.uploadImage);
        multiRecyclerView = findViewById(R.id.multiRecyclerView);
        goToChartBar = findViewById(R.id.goToChartBar);
    }
    private void myToolbar() {
        Toolbar toolBar = findViewById(R.id.toolBar);
        toolBar.setTitle("All Pages");
        toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
}
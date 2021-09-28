package com.example.apitest.Video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.apitest.R;

public class VideoShow extends AppCompatActivity implements View.OnClickListener {
    Button selectVdo;
    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show);
        selectVdo = findViewById(R.id.selectVdo);
        videoView = findViewById(R.id.videoView);
        if (mediaController == null) {
            // create an object of media controller class
            mediaController = new MediaController(VideoShow.this);
            mediaController.setAnchorView(videoView);
        }
        videoView.setMediaController(mediaController);
        selectVdo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.selectVdo:
                if (ContextCompat.checkSelfPermission(VideoShow.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(VideoShow.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                }else {
                    selectVideo();
                }
                break;
        }
    }
    private void selectVideo() {
        Intent ig = new Intent(Intent.ACTION_PICK);
        ig.setType("video/*");
        startActivityForResult(Intent.createChooser(ig,"Select Video"),100);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1 && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            selectVideo();
        }else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            Log.d("VideoUri", "onActivityResult: "+uri);
            videoView.setVideoURI(uri);
            videoView.start();
        }
    }
}
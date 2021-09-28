package com.example.apitest.UploadDoc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.widget.Toast;

import com.example.apitest.R;
import com.example.apitest.databinding.ActivityUploadDocumentBinding;

import java.io.File;

public class UploadDocument extends AppCompatActivity {
ActivityUploadDocumentBinding binding;
    String path;
    File myFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadDocumentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myToolBar();
        clickPerform();
    }
    private void clickPerform() {
        binding.pickFile.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            startActivityForResult(intent,1);
        });
        binding.viewPdf.setOnClickListener(v -> {
            Log.d("FileName", "clickPerform: "+myFile+" Path:"+path);
                startActivity(new Intent(this, ViewFileActivity.class).putExtra("myFile",myFile.getAbsolutePath()));
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    String uriString = uri.toString();
                    myFile = new File(uriString);
                    path = myFile.getAbsolutePath();
                    String displayName = null;
                    if (uriString.startsWith("content://")) {
                        Cursor cursor = null;
                        try {
                            cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
                            if (cursor != null && cursor.moveToFirst()) {
                                displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                                binding.pathDirectory.setText(displayName);
                                Toast.makeText(this, displayName, Toast.LENGTH_SHORT).show();
                            }
                        } finally {
                            cursor.close();
                        }
                    } else if (uriString.startsWith("file://")) {
                        displayName = myFile.getName();
                        Toast.makeText(this, displayName, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void myToolBar() {
        binding.toolBar.setTitle("Upload File");
        binding.toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        binding.toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }
}
package com.example.apitest.MultiImg;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.example.apitest.R;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.sangcomz.fishbun.define.Define.ALBUM_REQUEST_CODE;
import static com.sangcomz.fishbun.define.Define.INTENT_PATH;

public class UploadImage extends Activity implements View.OnClickListener {
    ImageSwitcher imagesIs;
    Button previousBtn,nextBtn,pickImagesBtn;
    ArrayList<Uri> imageUris;
    private static final int PICK_IMAGES_CODE = 0;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        imagesIs = findViewById(R.id.imagesIs);
        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        pickImagesBtn = findViewById(R.id.pickImagesBtn);
        pickImagesBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        previousBtn.setOnClickListener(this);
        imageUris = new ArrayList<>();
        imagesIs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
    }
    private void pickImagesIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image(s)"),PICK_IMAGES_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PICK_IMAGES_CODE){
            if (resultCode == Activity.RESULT_OK){
                if (data.getClipData() != null){
                    //Multiple Image
                    int cout= data.getClipData().getItemCount();
                   for (int i = 0; i < cout; i++){
                       Uri imageUrl = data.getClipData().getItemAt(i).getUri();
                       imageUris.add(imageUrl);
                   }
                   imagesIs.setImageURI(imageUris.get(0));
                   position = 0;
                }else {
                    //single Image
                    Uri imageUri = data.getData();
                    imageUris.add(imageUri);
                    imagesIs.setImageURI(imageUris.get(0));
                    position = 0;
                }
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nextBtn:
                if (position<imageUris.size()-1){
                    position++;
                    imagesIs.setImageURI(imageUris.get(position));
                }else {
                    Toast.makeText(this, "No More Images . . .", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.previousBtn:
                if (position>0){
                    position--;
                    imagesIs.setImageURI(imageUris.get(position));
                }else {
                    Toast.makeText(this, "No Images . . .", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pickImagesBtn:
                pickImagesIntent();
                break;
        }
    }
    //Image Id onClick . . .
    // imgU.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                if (ActivityCompat.checkSelfPermission(WriteReview.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
    //                        PackageManager.PERMISSION_GRANTED) {
    //                    ActivityCompat.requestPermissions(WriteReview.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
    //                            REQUEST_EXTERNAL_STORAGE);
    //                }
    //                launchGalleryIntent();
    //            }
    //        });
    //    public void launchGalleryIntent() {
    //        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    //        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
    //        intent.setType("image/*");
    //        startActivityForResult(intent, REQUEST_EXTERNAL_STORAGE);
    //    }
    //    @Override
    //    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //        super.onActivityResult(requestCode, resultCode, data);
    //        if (requestCode == REQUEST_EXTERNAL_STORAGE && resultCode == RESULT_OK) {
    //
    //            final List<Bitmap> bitmaps = new ArrayList<>();
    //            ClipData clipData = data.getClipData();
    //
    //            if (clipData != null) {
    //                //multiple images selecetd
    //                for (int i = 0; i < clipData.getItemCount(); i++) {
    //                    Uri imageUri = clipData.getItemAt(i).getUri();
    //                    Log.d("URI", imageUri.toString());
    //                    try {
    //                        InputStream inputStream = getContentResolver().openInputStream(imageUri);
    //                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
    //                        bitmaps.add(bitmap);
    //                    } catch (FileNotFoundException e) {
    //                        e.printStackTrace();
    //                    }
    //                }
    //            } else {
    //                //single image selected
    //                Uri imageUri = data.getData();
    //                Log.d("URI", imageUri.toString());
    //                try {
    //                    InputStream inputStream = getContentResolver().openInputStream(imageUri);
    //                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
    //                    bitmaps.add(bitmap);
    //                } catch (FileNotFoundException e) {
    //                    e.printStackTrace();
    //                }
    //
    //            }
    //
    //            new Thread(new Runnable() {
    //                @Override
    //                public void run() {
    //                    for (final Bitmap b : bitmaps) {
    //                        runOnUiThread(new Runnable() {
    //                            @Override
    //                            public void run() {
    //                                imgU.setImageBitmap(b);
    //                            }
    //                        });
    //
    //                        try {
    //                            Thread.sleep(3000);
    //                        } catch (InterruptedException e) {
    //                            e.printStackTrace();
    //                        }
    //                    }
    //                }
    //            }).start();
    //        }
    //    }
}
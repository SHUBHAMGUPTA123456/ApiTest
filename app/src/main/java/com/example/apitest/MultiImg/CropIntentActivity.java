package com.example.apitest.MultiImg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.apitest.R;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class CropIntentActivity extends AppCompatActivity {
   Button btnCapture;
   ImageView imgViewCamera;
    protected int LOAD_IMAGE_CAMERA = 0, CROP_IMAGE = 1, LOAD_IMAGE_GALLARY = 2;
     Uri picUri;
     File pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_intent);
        btnCapture = findViewById(R.id.btnSubmit);
        imgViewCamera = findViewById(R.id.imgShow);
        btnCapture.setOnClickListener(v -> {
            selectImg();
        });
}
    private void selectImg() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(CropIntentActivity.this);
        builder.setTitle("Select Pic Using...");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    try {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        pic = new File(Environment.getExternalStorageDirectory(), "tmp_" + System.currentTimeMillis() + ".jpg");
//                        picUri = Uri.fromFile(pic);
                        Log.d("UriCameraIntent", "onClick: "+picUri);
//                        cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, picUri);
//                        cameraIntent.putExtra("return-data", true);
                        startActivityForResult(cameraIntent, LOAD_IMAGE_CAMERA);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMAGE_GALLARY);
                }
            }
        });
        builder.show();
    }
//    private void selectImage(Context context) {
//        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setCancelable(false);
//        builder.setTitle("Choose a Media");
//        builder.setItems(options, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int item) {
//                if (options[item].equals("Take Photo")) {
//                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(takePicture, 0);
//                } else if (options[item].equals("Choose from Gallery")) {
//                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(pickPhoto, 1);//one can be replaced with any action code
//                } else if (options[item].equals("Cancel")) {
//                    dialog.dismiss();
//                }
//            }
//        });
//        builder.show();
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CROP_PIC_REQUEST_CODE) {
//            if (data != null) {
//                Uri uri = data.getData();
//                Bundle extras = data.getExtras();
//                Bitmap bitmap= extras.getParcelable("data");
//                doCrop(uri);
//                imgShow.setImageBitmap(bitmap);
//            }
//        }
//    }
//    private void doCrop(Uri picUri) {
//        try {
//            Intent cropIntent = new Intent("com.android.camera.action.CROP");
//            cropIntent.setDataAndType(picUri, "image/*");
//            cropIntent.putExtra("crop", "true");
//            cropIntent.putExtra("aspectX", 1);
//            cropIntent.putExtra("aspectY", 1);
//            cropIntent.putExtra("outputX", 128);
//            cropIntent.putExtra("outputY", 128);
//            cropIntent.putExtra("return-data", true);
//            startActivityForResult(cropIntent, CROP_PIC_REQUEST_CODE);
//        }
//        // respond to users whose devices do not support the crop action
//        catch (ActivityNotFoundException anfe) {
//            // display an error message
//            String errorMessage = "Whoops - your device doesn't support the crop action!";
//            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
//            toast.show();
//        }
//    }
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //super.onActivityResult(requestCode, resultCode, data);
    super.onActivityResult(requestCode, resultCode, data);
    picUri = data.getData();
    if (requestCode == LOAD_IMAGE_CAMERA) {
        if (data != null) {
            CropImage();
            Log.d("ByCamera", "CameraResponse: " + data.getData() + " Uri: " + picUri);
        }
    }
    else if (requestCode == LOAD_IMAGE_GALLARY) {
        if (data != null) {
            CropImage();
            Log.d("ByCamera", "GalleryResponse: "+data.getData()+" Uri: "+picUri);
        }
    }
    else if (requestCode == CROP_IMAGE) {
        if (data != null) {
            // get the returned data
            Bundle extras = data.getExtras();
            // get the cropped bitmap
            Bitmap photo = extras.getParcelable("data");
            imgViewCamera.setImageBitmap(photo);
            if (pic != null) {
                // To delete original image taken by camera
                if (pic.delete())
                    Toast.makeText(this, "original image deleted...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
    protected void CropImage() {
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(picUri, "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("outputX", 200);
            intent.putExtra("outputY", 200);
            intent.putExtra("aspectX", 3);
            intent.putExtra("aspectY", 4);
            intent.putExtra("scaleUpIfNeeded", true);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, CROP_IMAGE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Your device doesn't support the crop action!", Toast.LENGTH_SHORT).show();
        }
    }
    public Bitmap CompressResizeImage(Bitmap bm) {
        int bmWidth = bm.getWidth();
        int bmHeight = bm.getHeight();
        int ivWidth = imgViewCamera.getWidth();
        int ivHeight = imgViewCamera.getHeight();
        int new_height = (int) Math.floor((double) bmHeight *( (double) ivWidth / (double) bmWidth));
        Bitmap newbitMap = Bitmap.createScaledBitmap(bm, ivWidth, new_height, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        newbitMap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        Bitmap bm1 = BitmapFactory.decodeByteArray(b, 0, b.length);
        return bm1;
    }
}
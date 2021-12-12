package com.example.apitest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.shantanudeshmukh.linkedinsdk.LinkedInBuilder;
import com.shantanudeshmukh.linkedinsdk.helpers.LinkedInUser;
import com.shantanudeshmukh.linkedinsdk.helpers.OnBasicProfileListener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

public class MenuActivity extends AppCompatActivity {
    Button showPopup, getLoginInfo;
    ListView showContext;
    ImageButton menuBtn;
    String contacts[] = {"Ajay", "Sachin", "Sumit", "Tarun", "Yogesh"};
    Button openCustomDialog,btnLoginWithLinkedIn;
    private String accessToken;
    private long accessTokenExpiry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        showPopup = findViewById(R.id.showPopup);
        showContext = findViewById(R.id.showContext);
        menuBtn = findViewById(R.id.menuBtn);
        btnLoginWithLinkedIn = findViewById(R.id.btnLoginWithLinkedIn);
        openCustomDialog = findViewById(R.id.openCustomDialog);
        getLoginInfo = findViewById(R.id.getLoginInfo);

        btnLoginWithLinkedIn.setOnClickListener(v -> {
            LinkedInBuilder.getInstance(MenuActivity.this)
                    .setClientID("778thctjqegu7n")
                    .setClientSecret("aRSgUV9XmLuYNT67")
                    .setRedirectURI("https://www.javatpoint.com/")
                    .authenticate(21);
        });
        //for Popup Menu
        showPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MenuActivity.this, showPopup);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MenuActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        showContext.setAdapter(adapter);
        registerForContextMenu(showContext);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,All_Item.class));
            }
        });
        //On MainActivity Page
        Button openCustomDialog=findViewById(R.id.openCustomDialog);
        openCustomDialog.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_for_filter);
            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(false);
            dialog.show();
            ImageView exitDialog=dialog.findViewById(R.id.exitDialog);
            TextView fromDate=dialog.findViewById(R.id.fromDate);
            TextView dateToDoList=dialog.findViewById(R.id.dateToDoList);
            Button applyDate=dialog.findViewById(R.id.applyDate);
            fromDate.setOnClickListener(v1 -> {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mdiDialog = new DatePickerDialog(MenuActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fromDate.setText(monthOfYear + 1 + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, day);
                mdiDialog.show();
            });
            applyDate.setOnClickListener(v1 -> {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Handle Your Action !", Toast.LENGTH_SHORT).show();
            });
            exitDialog.setOnClickListener(v1 -> {
                dialog.dismiss();
            });
        });
        getLoginInfo.setOnClickListener(v -> {
            LinkedInBuilder.retrieveBasicProfile(accessToken, accessTokenExpiry, new OnBasicProfileListener() {
                @Override
                public void onDataRetrievalStart() {

                }

                @Override
                public void onDataSuccess(LinkedInUser user) {
                    setUserData(user);
                }

                @Override
                public void onDataFailed(int errCode, String errMessage) {

                    Toast.makeText(MenuActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
    private void setUserData(LinkedInUser user) {
        accessToken = user.getAccessToken();
        accessTokenExpiry = user.getAccessTokenExpiry();

        Log.wtf("LINKEDIN ID", user.getId());

//        tvFName.setText(user.getFirstName());
//        tvLName.setText(user.getLastName());
//        tvEmail.setText(user.getEmail());

        Toast.makeText(getApplicationContext(), user.getFirstName()+" "+
                user.getLastName()+", "+user.getEmail(), Toast.LENGTH_SHORT).show();
//        if(user.getProfileUrl()!= null && !user.getProfileUrl().isEmpty()){
//            new ImageLoadTask(user.getProfileUrl(), ivUserPic).execute();
//        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        showPopup(v);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.call) {
            Toast.makeText(getApplicationContext(), "calling code", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.sms) {
            Toast.makeText(getApplicationContext(), "sending sms code", Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
        return true;
    }
    //Opion Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu,add items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);//Menu ResourceFile
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.two:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.three:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.four:
                Toast.makeText(getApplicationContext(), "Item 4 Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void showPopup(View v) {
        Context wrapper = new ContextThemeWrapper(this, R.style.popupMenuStyle);
        PopupMenu mypopupmenu = new PopupMenu(wrapper, v);
        setForceShowIcon(mypopupmenu);
        MenuInflater inflater = mypopupmenu.getMenuInflater();
        inflater.inflate(R.menu.context_menu, mypopupmenu.getMenu());
        mypopupmenu.show();
        mypopupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one:
                        // Your code goes here
                        break;

                    case R.id.two:
                        // Your code goes here
                        break;
                }
                return false;
            }
        });
    }
    private void setForceShowIcon(PopupMenu popupMenu) {
        try {
            Field[] mFields = popupMenu.getClass().getDeclaredFields();
            for (Field field : mFields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> popupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method mMethods = popupHelper.getMethod("setForceShowIcon", boolean.class);
                    mMethods.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 21 && data != null) {
            if (resultCode == RESULT_OK) {
                //Successfully signed in
                LinkedInUser user = data.getParcelableExtra("social_login");

                //acessing user info
                Log.i("LinkedInLogin", user.getFirstName());

            } else {

                if (data.getIntExtra("err_code", 0) == LinkedInBuilder.ERROR_USER_DENIED) {
                    //Handle : user denied access to account

                } else if (data.getIntExtra("err_code", 0) == LinkedInBuilder.ERROR_FAILED) {

                    //Handle : Error in API : see logcat output for details
                    Log.e("LINKEDIN ERROR", data.getStringExtra("err_message"));
                }
            }
        }

    }
}
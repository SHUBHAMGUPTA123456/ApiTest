package com.example.apitest.CardStack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.apitest.R;

import java.util.ArrayList;

public class CardStack extends AppCompatActivity {
    ViewPager viewpager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<ViewPagerModel> viewPagerModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_stack);
        viewpager = findViewById(R.id.viewpager);
        viewPagerModels = new ArrayList<>();
//        int img[] = {R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
//        String jobTtl[] = {"Ui Developer","Software Developer","Android Developer", "Web Developer"};
//        for (int i = 0; i<jobTtl.length; i++){
            viewPagerModels.add(new ViewPagerModel("Ui Developer", "Aara Technologies Pvt Ltd","Lucknow","3-4 Year"));
            viewPagerModels.add(new ViewPagerModel("Software Developer","Microsoft Technology","Lucknow","3-4 Year"));
            viewPagerModels.add(new ViewPagerModel("Android Developer", "Google","Lucknow","3-4 Year"));
            viewPagerModels.add(new ViewPagerModel("Web Developer","IBM","Lucknow","3-4 Year"));
//        }
        viewPagerAdapter = new ViewPagerAdapter(viewPagerModels,getApplicationContext());
        viewpager.setPageTransformer(true,new ViewPagerStack());
        viewpager.setOffscreenPageLimit(4);
        viewpager.setAdapter(viewPagerAdapter);
    }

    private class ViewPagerStack implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
//            if (position>=0){
//                page.setScaleX(0.07f - 0.05f * position);
//                page.setScaleY(0.7f);
//                page.setTranslationX(-page.getWidth()*position);
//                page.setTranslationY(-30*position);
//            }
            if (position >= 0) {
                page.setScaleX(0.7f - 0.05f * position);
                page.setScaleY(0.7f);
                page.setTranslationX(-page.getWidth() * position);
                page.setTranslationY(30 * position);
            }
        }
    }
}
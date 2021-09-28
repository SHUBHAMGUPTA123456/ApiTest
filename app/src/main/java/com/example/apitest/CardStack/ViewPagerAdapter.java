package com.example.apitest.CardStack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.apitest.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    List<ViewPagerModel> viewPagerModels;
    Context context;

    public ViewPagerAdapter(List<ViewPagerModel> viewPagerModels, Context context) {
        this.viewPagerModels = viewPagerModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return viewPagerModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_rec_profile_based_job,container,false);
        container.addView(view);
        TextView jobTitle = view.findViewById(R.id.jobTitle);
        TextView cmpnyName = view.findViewById(R.id.cmpnyName);
        jobTitle.setText(viewPagerModels.get(position).getJobTitle());
        cmpnyName.setText(viewPagerModels.get(position).getCmpnyName());
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

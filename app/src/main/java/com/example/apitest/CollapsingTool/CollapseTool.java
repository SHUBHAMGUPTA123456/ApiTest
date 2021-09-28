package com.example.apitest.CollapsingTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;

import com.example.apitest.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.SubtitleCollapsingToolbarLayout;
import com.google.android.material.internal.SubtitleCollapsingTextHelper;

public class CollapseTool extends AppCompatActivity {
    Toolbar tool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse_tool);
        tool = findViewById(R.id.tool);
        tool.setCollapseContentDescription("Hi");
        tool.setCollapseIcon(R.drawable.icon_four);
        tool.setTitle("Shubham");
        tool.setSubtitle("Kasimabad");
        tool.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }
}
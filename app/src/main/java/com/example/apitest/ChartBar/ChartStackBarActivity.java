package com.example.apitest.ChartBar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.apitest.R;
import com.example.apitest.databinding.ActivityChartStackBarBinding;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartStackBarActivity extends AppCompatActivity {
    ActivityChartStackBarBinding binding;

    private static final int MAX_X_VALUE = 5;
    private static final int MAX_Y_VALUE = 50;
    private static final int MIN_Y_VALUE = 10;
    private static final int MAX_YY_VALUE = 50;
    private static final String STACK_1_LABEL = "Stack 1";
    private static final String STACK_2_LABEL = "Stack 2";
    private static final String STACK_3_LABEL = "Stack 3";
    private static final String STACK_4_LABEL = "Stack 4";
    private static final String SET_LABEL = "Chart Bar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChartStackBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myTool();
        BarData data = createChartData();
        configureChartAppearance();
        prepareChartData(data);
    }
    private void configureChartAppearance() {
        binding.barChart.setDrawGridBackground(false);
        binding.barChart.setDrawValueAboveBar(false);

        binding.barChart.getDescription().setEnabled(false);

        XAxis xAxis = binding.barChart.getXAxis();
        xAxis.setGranularity(1f);

        YAxis leftAxis = binding.barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);

        YAxis rightAxis = binding.barChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
    }
    private BarData createChartData() {
        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < MAX_X_VALUE; i++) {
            float value1 = Math.max(MIN_Y_VALUE, (float) Math.random() * (MAX_Y_VALUE + 1));
            float value2 = Math.max(MIN_Y_VALUE, (float) Math.random() * (MAX_Y_VALUE + 1));
            float value3 = Math.max(MIN_Y_VALUE, (float) Math.random() * (MAX_Y_VALUE + 1));
            float value4 = Math.max(MAX_YY_VALUE, (float) Math.random() * (MAX_YY_VALUE + 1));
            values.add(new BarEntry(i, new float[]{value1, value2, value3,value4}));
        }

        BarDataSet set1 = new BarDataSet(values, SET_LABEL);

        set1.setColors(new int[] {ColorTemplate.MATERIAL_COLORS[0], ColorTemplate.MATERIAL_COLORS[1], ColorTemplate.MATERIAL_COLORS[2],ColorTemplate.MATERIAL_COLORS[3]});
        set1.setStackLabels(new String[] {STACK_1_LABEL, STACK_2_LABEL, STACK_3_LABEL,STACK_4_LABEL});

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        return data;
    }

    private void prepareChartData(BarData data) {
        data.setValueTextSize(12f);
        binding.barChart.setData(data);
        binding.barChart.invalidate();
    }
    private void myTool() {
        binding.toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        binding.toolBar.setTitle("Chart Bar");
        binding.toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }
}
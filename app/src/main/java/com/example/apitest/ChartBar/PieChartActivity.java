package com.example.apitest.ChartBar;

import static com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutQuad;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;

import com.example.apitest.databinding.ActivityPieChartBinding;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {
    ActivityPieChartBinding binding;
    int pStatus = 0;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPieChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupPieChart();
        loadPieChartData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.circleProgress.setProgress(pStatus);
                        }
                    });
                    try {
                        Thread.sleep(8); //thread will take approx 1.5 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void setupPieChart() {
        binding.pieChart.setDrawHoleEnabled(true);
        binding.pieChart.setUsePercentValues(true);
        binding.pieChart.setEntryLabelTextSize(12);
        binding.pieChart.setEntryLabelColor(Color.BLACK);
        binding.pieChart.setCenterText("Category");
        binding.pieChart.setCenterTextSize(24);
        binding.pieChart.getDescription().setEnabled(false);
        Legend l = binding.pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f, "Food"));
        entries.add(new PieEntry(0.15f, "Medical"));
        entries.add(new PieEntry(0.15f, "Entertain"));
        entries.add(new PieEntry(0.25f, "Electricity"));
        entries.add(new PieEntry(0.3f, "Housing"));
        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }
        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        binding.pieChart.setData(data);
        binding.pieChart.invalidate();
        binding.pieChart.animateY(1400, EaseInOutQuad);
    }
}
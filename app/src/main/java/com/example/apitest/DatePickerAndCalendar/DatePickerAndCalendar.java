package com.example.apitest.DatePickerAndCalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;
import com.example.apitest.databinding.ActivityDatePickerAndCalendarBinding;

import java.util.Calendar;

public class DatePickerAndCalendar extends AppCompatActivity {
    ActivityDatePickerAndCalendarBinding binding;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    int startYear,startMonth,startDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatePickerAndCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        showEndDate(year, month+1, day);
        binding.startDate.setOnClickListener(v -> {
            showDialog(999);
        });
        binding.endDateTxt.setOnClickListener(v -> {
            showDialog(998);
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }else if (id == 998){
            return new DatePickerDialog(this,
                    myDateListenerO, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        binding.startDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        startYear = year;
        startMonth = month;
        startDay = day;
    }
    private DatePickerDialog.OnDateSetListener myDateListenerO = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showEndDate(arg1, arg2+1, arg3);
                }
            };
    private void showEndDate(int year, int month, int day) {
       if (year>= startYear){
            if (month>=startMonth){
                if (day>=startDay){
                    binding.endDateTxt.setText(new StringBuilder().append(day).append("/")
                            .append(month).append("/").append(year));
                }else {
                    Toast.makeText(getApplicationContext(), "Choose Correct Day", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Choose Correct Month", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Choose Correct Year", Toast.LENGTH_SHORT).show();
        }
    }
}
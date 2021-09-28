package com.example.apitest.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.example.apitest.R;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnNavigationButtonClickedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarCustom extends AppCompatActivity implements OnNavigationButtonClickedListener {
    CustomCalendar custom_calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_custom);
        custom_calendar = findViewById(R.id.custom_calendar);
        myToolbar();

        HashMap<Object, Property> mapDescToProp = new HashMap<>();
        Property propDefault = new Property();
        propDefault.layoutResource = R.layout.default_view;
        propDefault.dateTextViewResource = R.id.txtView;
        mapDescToProp.put("default", propDefault);

        Property propUnavailable = new Property();
        propUnavailable.layoutResource = R.layout.unavailable_view;
        propUnavailable.dateTextViewResource = R.id.txtView;
        //You can leave the text view field blank. Custom calendar won't try to set a date on such views
        propUnavailable.enable = false;
        mapDescToProp.put("unavailable", propUnavailable);

        Property propHoliday = new Property();
        propHoliday.layoutResource = R.layout.holiday_view;
        propHoliday.dateTextViewResource = R.id.holiday_datetextview;
        mapDescToProp.put("holiday", propHoliday);
        custom_calendar.setMapDescToProp(mapDescToProp);

        HashMap<Integer, Object> mapDateToDesc = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        mapDateToDesc.put(2, "unavailable");
        mapDateToDesc.put(5, "holiday");
        mapDateToDesc.put(10, "default"); //You don't need to explicitly mention "default" description dates.
        mapDateToDesc.put(11, "unavailable");
        mapDateToDesc.put(19, "holiday");
        mapDateToDesc.put(20, "holiday");
        mapDateToDesc.put(24, "unavailable");
        custom_calendar.setDate(calendar, mapDateToDesc);
        custom_calendar.setOnDateSelectedListener((view, selectedDate, desc) -> {
            String sDate = selectedDate.get(Calendar.DAY_OF_MONTH)+"/"+(selectedDate.get(Calendar.MONTH)+1)+
                    "/"+selectedDate.get(Calendar.YEAR);
            Toast.makeText(this, sDate, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public Map<Integer, Object>[] onNavigationButtonClicked(int whichButton, Calendar newMonth) {
        Map<Integer, Object>[] arr = new Map[2];
        switch(newMonth.get(Calendar.MONTH)) {
            case Calendar.AUGUST:
                arr[0] = new HashMap<>(); //This is the map linking a date to its description
                arr[0].put(3, "unavailable");
                arr[0].put(6, "holiday");
                arr[0].put(21, "unavailable");
                arr[0].put(24, "holiday");
                arr[1] = null; //Optional: This is the map linking a date to its tag.
                break;
            case Calendar.JUNE:
                arr[0] = new HashMap<>();
                arr[0].put(5, "unavailable");
                arr[0].put(10, "holiday");
                arr[0].put(19, "holiday");
                break;
        }
        return arr;
    }
    private void myToolbar() {
        Toolbar toolBar= findViewById(R.id.toolBar);
        toolBar.setTitle("Custom Calendar");
        toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
}
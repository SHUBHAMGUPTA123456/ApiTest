package com.example.apitest.MultiRecyclerView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Object> objects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        AdapterForAll adapter = new AdapterForAll(this, getObject());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myToolbar();
    }

    private void myToolbar() {
        Toolbar toolBar = findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
    private ArrayList<Object> getObject() {
        objects.add(getCheckBox().get(0));
        objects.add(getRadioBtn().get(0));
        objects.add(getSpecify().get(0));
        objects.add(getFour().get(0));
        return objects;
    }

    public static ArrayList<ModelCheckBox> getCheckBox() {
        ArrayList<ModelCheckBox> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new ModelCheckBox("Q1. How do you feel about the performance of Prime Minister\n" +
                "Narendra Modi and his Government?"));
        singleHorizontals.add(new ModelCheckBox( "Q2. How do you feel about the performance of Prime Minister\n" +
                "Narendra Modi and his Government?"));
        return singleHorizontals;
    }
    public static ArrayList<ModelRadioButton> getRadioBtn() {
        ArrayList<ModelRadioButton> singleVerticals = new ArrayList<>();
        singleVerticals.add(new ModelRadioButton("Q3. Do you think BJP has done the right thing by replacing BS\n" +
                "Yeddyurappa with Basavaraj Bommai as the Chief Minister?"));
        singleVerticals.add(new ModelRadioButton("Q4. Do you think BJP has done the right thing by replacing BS\n" +
                "Yeddyurappa with Basavaraj Bommai as the Chief Minister?"));
        return singleVerticals;
    }
    public static ArrayList<ModelSppecifyInput> getSpecify() {
        ArrayList<ModelSppecifyInput> modeViewThrees = new ArrayList<>();
        modeViewThrees.add(new ModelSppecifyInput("Q5. Is there any change in your life after Modi became\\nPrime\n" +
                "Minister? (This is a new question added as asked)"));
        modeViewThrees.add(new ModelSppecifyInput( "Q6. Is there any change in your life after Modi became\\nPrime\n" +
                "Minister? (This is a new question added as asked)"));
        return modeViewThrees;
    }
    public static ArrayList<ModelViewFour> getFour() {
        ArrayList<ModelViewFour> modelViewFours = new ArrayList<>();
        modelViewFours.add(new ModelViewFour("View Four"));
        modelViewFours.add(new ModelViewFour("Name One"));
        modelViewFours.add(new ModelViewFour("Name Two"));
        modelViewFours.add(new ModelViewFour( "Name Three"));
        return modelViewFours;
    }
}

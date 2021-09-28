package com.example.apitest.RecyclerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;

import com.example.apitest.ModelRecData;
import com.example.apitest.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerViewEx extends AppCompatActivity {
    RecyclerView recView;
    List<ModelRecData> modelRecData;
    AdapterRecyclerView adapterRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_ex);
        recView = findViewById(R.id.recView);
        myToolBar();
        modelRecData = new ArrayList<>();
        recView.setNestedScrollingEnabled(false);
        recView.setHasFixedSize(true);
        modelRecData.add(new ModelRecData("One","",""));
        modelRecData.add(new ModelRecData("Two","",""));
        modelRecData.add(new ModelRecData("Three","",""));
        modelRecData.add(new ModelRecData("Four","",""));
        modelRecData.add(new ModelRecData("Five","",""));
        modelRecData.add(new ModelRecData("Six","",""));
        modelRecData.add(new ModelRecData("Seven","",""));
        modelRecData.add(new ModelRecData("Eight","",""));
        modelRecData.add(new ModelRecData("Nine","",""));
        modelRecData.add(new ModelRecData("Ten","",""));
        modelRecData.add(new ModelRecData("Eleven","",""));
        modelRecData.add(new ModelRecData("Twelve","",""));
        modelRecData.add(new ModelRecData("Thirteen","",""));
        modelRecData.add(new ModelRecData("Fourteen","",""));
        modelRecData.add(new ModelRecData("Fifteen","",""));
        recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapterRecyclerView = new AdapterRecyclerView(getApplicationContext(),modelRecData);
        recView.setAdapter(adapterRecyclerView);
        //Swipe . . .
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.START| ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // this method is called
                // when the item is moved.
                    int fromPosition = viewHolder.getAdapterPosition();
                    int toPosition = target.getAdapterPosition();
                    Collections.swap(modelRecData, fromPosition, toPosition);
                    recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
                    return false;

            }

            @Override
            public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    // this method is called when we swipe our item to right direction.
                    // on below line we are getting the item at a particular position.
                    ModelRecData deletedCourse = modelRecData.get(viewHolder.getAdapterPosition());
                    // below line is to get the position
                    // of the item at that position.
                    int position = viewHolder.getAdapterPosition();
                    // this method is called when item is swiped.
                    // below line is to remove item from our array list.
                    modelRecData.remove(viewHolder.getAdapterPosition());
                    // below line is to notify our item is removed from adapter.
                    adapterRecyclerView.notifyItemRemoved(viewHolder.getAdapterPosition());
                    // below line is to display our snackbar with action.
                    Snackbar.make(recView, deletedCourse.getName(), Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // adding on click listener to our action of snack bar.
                            // below line is to add our item to array list with a position.
                            modelRecData.add(position, deletedCourse);

                            // below line is to notify item is
                            // added to our adapter class.
                            adapterRecyclerView.notifyItemInserted(position);
                        }
                    }).show();
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(recView);
    }
    private void myToolBar() {
        Toolbar toolBar= findViewById(R.id.toolBar);
        toolBar.setTitle("RecyclerView");
        toolBar.setNavigationIcon(R.drawable.icon_btn_back);
        toolBar.setNavigationOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
}
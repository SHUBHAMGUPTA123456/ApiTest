package com.example.apitest.MultiRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.R;

import java.util.ArrayList;

import static com.example.apitest.MultiRecyclerView.MainActivity.getCheckBox;
import static com.example.apitest.MultiRecyclerView.MainActivity.getFour;
import static com.example.apitest.MultiRecyclerView.MainActivity.getRadioBtn;
import static com.example.apitest.MultiRecyclerView.MainActivity.getSpecify;

public class AdapterForAll extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;
    private final int RadioBtn = 1;
    private final int CheckBox = 2;
    private final int Three = 3;
    private final int Four = 4;

    public AdapterForAll(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case RadioBtn:
                view = inflater.inflate(R.layout.vertical, parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case CheckBox:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
            case Three:
                view = inflater.inflate(R.layout.recycler_three, parent, false);
                holder = new ViewThree(view);
                break;
            case Four:
                view = inflater.inflate(R.layout.rcycler_four, parent, false);
                holder = new ViewFour(view);
                break;
            default:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == RadioBtn)
            verticalView((VerticalViewHolder) holder);
        else if (holder.getItemViewType() == CheckBox)
            horizontalView((HorizontalViewHolder) holder);
        else if (holder.getItemViewType() == Three)
            viewTypeThree((ViewThree) holder);
        else if (holder.getItemViewType() == Four)
            viewTypeFour((ViewFour) holder);
    }

    private void verticalView(VerticalViewHolder holder) {
        RadioBtnAdapter adapter1 = new RadioBtnAdapter(getRadioBtn());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter1);
    }
    private void horizontalView(HorizontalViewHolder holder) {
        CheckBoxAdapter adapter = new CheckBoxAdapter(getCheckBox());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter);
    }
    private void viewTypeThree(ViewThree holder) {
        SpecifyAdapter threeAdapter = new SpecifyAdapter(getSpecify());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(threeAdapter);
    }
    private void viewTypeFour(ViewFour holder) {
        FourAdapter fourAdapter = new FourAdapter(getFour());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(fourAdapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof ModelRadioButton)
            return RadioBtn;
        if (items.get(position) instanceof ModelCheckBox)
            return CheckBox;
        if (items.get(position) instanceof ModelSppecifyInput)
            return Three;
        if (items.get(position) instanceof ModelViewFour)
            return Four;
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.inner_recyclerView);
        }
    }
    public class ViewThree extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
         ViewThree(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerThree);
        }
    }
    public class ViewFour extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public ViewFour(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerFour);
        }
    }
}

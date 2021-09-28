package com.example.apitest.MultiRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.R;

import java.util.ArrayList;

public class RadioBtnAdapter extends RecyclerView.Adapter<RadioBtnAdapter.MyViewHolder> {
    private ArrayList<ModelRadioButton> data = new ArrayList<>();

    public RadioBtnAdapter(ArrayList<ModelRadioButton> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_btn_question_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.questionTwo.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView questionTwo;
        public MyViewHolder(View itemView) {
            super(itemView);
            questionTwo = (TextView) itemView.findViewById(R.id.questionTwo);
        }
    }
}
package com.example.apitest.MultiRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.R;

import java.util.ArrayList;

public class SpecifyAdapter extends RecyclerView.Adapter<SpecifyAdapter.holderVi> {
    ArrayList<ModelSppecifyInput> modeViewThrees = new ArrayList<>();

    public SpecifyAdapter(ArrayList<ModelSppecifyInput> modeViewThrees) {
        this.modeViewThrees = modeViewThrees;
    }

    @NonNull
    @Override
    public holderVi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.multi_recycler_view_three,parent,false);
        return new holderVi(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holderVi holder, int position) {
        holder.questionThree.setText(modeViewThrees.get(position).getTxt());
    }

    @Override
    public int getItemCount() {
        return modeViewThrees.size();
    }

    public class holderVi extends RecyclerView.ViewHolder {
        TextView questionThree;
        public holderVi(@NonNull View itemView) {
            super(itemView);
            questionThree = itemView.findViewById(R.id.questionThree);
        }
    }
}

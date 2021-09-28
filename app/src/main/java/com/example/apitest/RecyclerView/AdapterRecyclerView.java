package com.example.apitest.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.ModelRecData;
import com.example.apitest.R;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.holderV>{
    List<ModelRecData> modelRecData;
    Context context;
    public AdapterRecyclerView(Context context,List<ModelRecData> modelRecData) {
        this.context = context;
        this.modelRecData = modelRecData;
    }
    @NonNull
    @Override
    public holderV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_rec_view_swipe,parent,false);
        return new holderV(v);
    }
    @Override
    public void onBindViewHolder(@NonNull holderV holder, int position) {
        holder.title.setText(modelRecData.get(position).getName());
        holder.cover.setClickable(true);
    }
    @Override
    public int getItemCount() {
        return modelRecData.size();
    }
    public class holderV extends RecyclerView.ViewHolder {
        TextView title;
        LinearLayout cover;
        public holderV(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            cover = itemView.findViewById(R.id.cover);
        }
    }
}

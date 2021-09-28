package com.example.apitest.MultiRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitest.R;

import java.util.ArrayList;

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.holderVi> {
    ArrayList<ModelViewFour> modelViewFours = new ArrayList<>();

    public FourAdapter(ArrayList<ModelViewFour> modelViewFours) {
        this.modelViewFours = modelViewFours;
    }

    @NonNull
    @Override
    public holderVi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.multi_recycler_view_four,parent,false);
        return new holderVi(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holderVi holder, int position) {
        holder.txtFour.setText(modelViewFours.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return modelViewFours.size();
    }

    public class holderVi extends RecyclerView.ViewHolder {
        TextView txtFour;
        public holderVi(@NonNull View itemView) {
            super(itemView);
            txtFour = itemView.findViewById(R.id.txtFour);
        }
    }
}

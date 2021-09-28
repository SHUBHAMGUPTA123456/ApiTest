package com.example.apitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apitest.databinding.ActivityDataBindExampleBinding;
import com.example.apitest.databinding.RecDataLayBinding;

import java.util.ArrayList;
import java.util.List;

public class DataBindExample extends AppCompatActivity {
    List<ModelRecData>  modelRecData = new ArrayList<>();
    AdapterData adapterData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindExampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_bind_example);
        User user = new User();
//        user.setName("Shubham Gupta");
        binding.username.setText("Shubham Gupta");
        user.setEmail("shubham@android.info");
        binding.setUser(user);
        //Recycler View
        modelRecData.add(new ModelRecData("Shubham Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Ajay Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Horse Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Archana Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Neha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Rekha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Jaya Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Sushma Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Lalita Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Shubham Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Ajay Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Horse Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Archana Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Neha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Rekha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Jaya Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Sushma Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Lalita Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Shubham Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Ajay Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Horse Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Archana Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Neha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Rekha Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Jaya Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Sushma Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Lalita Gupta","shubham@gmail.com","Lucknow"));
        modelRecData.add(new ModelRecData("Lalita Gupta","shubham@gmail.com","Lucknow"));
         adapterData = new AdapterData(getApplicationContext(),modelRecData);
         binding.recView.setNestedScrollingEnabled(false);
        binding.recView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recView.setAdapter(adapterData);
    }
    public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHold>{
        Context context;
        List<ModelRecData> modelRecData;

        public AdapterData(Context context, List<ModelRecData> modelRecData) {
            this.context = context;
            this.modelRecData = modelRecData;
        }

        @NonNull
        @Override
        public AdapterData.ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            RecDataLayBinding binding = DataBindingUtil.inflate(inflater,
                    R.layout.rec_data_lay, parent, false);
            return new ViewHold(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterData.ViewHold holder, int position) {
            holder.binding.nameT.setText(modelRecData.get(position).getName());
            holder.binding.emailT.setText(modelRecData.get(position).getEmail());
            holder.binding.addressT.setText(modelRecData.get(position).getAddress());
        }

        @Override
        public int getItemCount() {
            return modelRecData.size();
        }

        public class ViewHold extends RecyclerView.ViewHolder {
            RecDataLayBinding binding;
            public ViewHold(@NonNull RecDataLayBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}
package com.example.acme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acme.R;

import java.util.ArrayList;
import java.util.List;

public class AdviceAdapter extends RecyclerView.Adapter<AdviceViewHolder> {

    Context mContext;
    List<String> advises = new ArrayList<>();

    public AdviceAdapter (Context context, List<String> list){
        this.mContext = context;
        this.advises = list;
    }

    @NonNull
    @Override
    public AdviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.advice_item, parent,false);
        return new AdviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdviceViewHolder holder, int position) {

        holder.advice.setText(advises.get(position));
    }

    @Override
    public int getItemCount() {
        return advises.size();
    }
}

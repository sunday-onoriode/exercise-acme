package com.example.acme.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acme.R;

public class AdviceViewHolder  extends RecyclerView.ViewHolder {

    TextView advice;

    public AdviceViewHolder(@NonNull View itemView) {
        super(itemView);

        advice = itemView.findViewById(R.id.advice);
    }
}

package com.example.calculatorapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Historyadapter extends RecyclerView.Adapter<Historyadapter.HistoryViewHolder> {
    List<History> list = new ArrayList<>();

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.textView.setText(list.get(position).histories);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void submitList(List<History> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.test);

        }
    }


}

package com.example.mad_mini_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter3  extends RecyclerView.Adapter<myAdapter3.myViewHolder>  {
    Context context;
    ArrayList<msg> list3;

    public myAdapter3(Context context, ArrayList<msg> list3) {
        this.context = context;
        this.list3= list3;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list3,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        msg mg=list3.get(position);
        holder.date.setText(mg.getDate());
        holder.time.setText(mg.getTime());
        holder.msg.setText(mg.getMessage());

    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView msg,date,time;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.msg);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);
        }
    }
}
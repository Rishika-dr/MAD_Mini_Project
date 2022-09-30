package com.example.mad_mini_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter2  extends RecyclerView.Adapter<myAdapter2.myViewHolder>  {
    Context context;
    ArrayList<fac> list2;

    public myAdapter2(Context context, ArrayList<fac> list2) {
        this.context = context;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list2,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        fac f=list2.get(position);
        holder.fname1.setText(f.getFacultyName());
        holder.fid1.setText(f.getFacultyId());

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView fname1,fid1;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            fname1=itemView.findViewById(R.id.fname);
            fid1=itemView.findViewById(R.id.fid);

        }
    }
}
package com.example.codepathproject4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder>{
    Context context;
    ArrayList<recyclerJoin> join;

    public listAdapter(Context context, ArrayList<recyclerJoin> join){
        this.context = context;
        this.join =  join;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // the view inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout, parent, false);
        Log.i("tag", "layout");

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position){
        //assign values to the views
    holder.Title.setText(join.get(position).getTitle());
    holder.Body.setText(join.get(position).getBody());
    holder.Picture.setText(join.get(position).getPicture());
        holder.Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search = new Intent(context, general.class);
                Bundle bundle = new Bundle();
                bundle.putString("Title",join.get(position).getTitle());
                bundle.putString("Body",join.get(position).getBody());
                bundle.putString("Picture",join.get(position).getPicture());
                search.putExtras(bundle);
                context.startActivity(search);
            }
        });

        Log.i("tag", "bind");
    }

    @Override
    public int getItemCount() {
        // number of views
        return join.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Title, Body, Picture;
          public MyViewHolder(@NonNull View itemView){
            super(itemView);
              Title = itemView.findViewById(R.id.title);
              Body = itemView.findViewById(R.id.body);
              Picture = itemView.findViewById(R.id.picture);

        }
    }
}

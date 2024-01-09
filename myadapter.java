package com.meri.simplemehndidesigns;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class myadapter extends FirebaseRecyclerAdapter<Modal,myadapter.myviewholder>{
    ProgressBar progressBar;
    Context context;
    ArrayList<Modal> list;

    public myadapter(@NonNull FirebaseRecyclerOptions<Modal> options, ArrayList<Modal> list) {
        super(options);
        this.list = list;
    }

    public myadapter(@NonNull FirebaseRecyclerOptions<Modal> options, Context context) {
        super(options);
        this.context = context;
    }

    public myadapter(@NonNull FirebaseRecyclerOptions<Modal> options) {
        super(options);
    }




    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample,parent,false);
        return new myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder,  int position, @NonNull Modal model) {
//        Modal modal = list.get(position);

        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);
       holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutid,new back_detail(model.getPurl())).addToBackStack(null).commit();



           }


       });


    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        ImageView view;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
           // progressBar = itemView.findViewById(R.id.progress);
            img = itemView.findViewById(R.id.imageView);
           // view = itemView.findViewById(R.id.imagedetail);






    }


    }


    }








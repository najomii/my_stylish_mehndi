package com.meri.simplemehndidesigns;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class simpleAdapter extends FirebaseRecyclerAdapter<Simple,simpleAdapter.viewHolder> {


    public simpleAdapter(@NonNull FirebaseRecyclerOptions<Simple> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Simple simple) {
        Glide.with(holder.imgSimple.getContext()).load(simple.getSimple()).into(holder.imgSimple);

        holder.imgSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(
                        R.id.simple_frame,new simple_deatailFragment(simple.getSimple())).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_sam,parent,false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgSimple,imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgSimple = itemView.findViewById(R.id.imageViewSimple);
            imageView = itemView.findViewById(R.id.share_simple);
        }
    }
}

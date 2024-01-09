package com.meri.simplemehndidesigns;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class fingerAdapter extends FirebaseRecyclerAdapter<Finger,fingerAdapter.viewHolder> {
    List<Finger>list;
    Context context;

    public fingerAdapter(@NonNull FirebaseRecyclerOptions<Finger> options, List<Finger> list, Context context) {
        super(options);
        this.list = list;
        this.context = context;
    }

    public fingerAdapter(@NonNull FirebaseRecyclerOptions<Finger> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Finger finger) {
        Glide.with(holder.imgfinger.getContext()).load(finger.getFinger()).into(holder.imgfinger);



        holder.imgfinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(
                        R.id.frameFinger,new finger_detail_Fragment(finger.getFinger())).addToBackStack(null).commit();







            }
        });


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.finger_sam,parent,false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgfinger;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgfinger = itemView.findViewById(R.id.imageViewfinger);
        }
    }
}

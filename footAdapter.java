package com.meri.simplemehndidesigns;

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

public class footAdapter extends FirebaseRecyclerAdapter<Foot,footAdapter.viewHolder> {


    public footAdapter(@NonNull FirebaseRecyclerOptions<Foot> options) {
        super(options);
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_sam,parent,false);
        return new viewHolder(view);
    }
    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Foot modal) {
        Glide.with(holder.imgfoot.getContext()).load(modal.getfoot()).into(holder.imgfoot);
        holder.imgfoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.Frameid,new descFragment(modal.getfoot())).
                        addToBackStack(null).commit();

            }
        });

    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgfoot;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgfoot = itemView.findViewById(R.id.imageViewfoot);
        }
    }
}

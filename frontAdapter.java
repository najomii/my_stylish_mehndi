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

public class frontAdapter extends FirebaseRecyclerAdapter<Front,frontAdapter.viewHolder> {


    public frontAdapter(@NonNull FirebaseRecyclerOptions<Front> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Front modal) {
        Glide.with(holder.imgfront.getContext()).load(modal.getfront()).into(holder.imgfront);
        holder.imgfront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(
                        R.id.front_frame,new front_detail_Fragment(modal.getfront())).addToBackStack(null).commit();

            }
        });


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.front_sam,parent,false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgfront;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgfront = itemView.findViewById(R.id.imageViewfront);
        }
    }
}

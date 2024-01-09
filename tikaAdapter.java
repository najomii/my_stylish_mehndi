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

public class tikaAdapter extends FirebaseRecyclerAdapter<Tikka,tikaAdapter.viewHolder> {


    public tikaAdapter(@NonNull FirebaseRecyclerOptions<Tikka> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Tikka modal) {
        Glide.with(holder.imgtika.getContext()).load(modal.gettika()).into(holder.imgtika);
        holder.imgtika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(
                        R.id.tikka_frame,new tikka_detail_Fragment(modal.gettika())).addToBackStack(null).commit();
            }
        });


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tika_sam,parent,false);

        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgtika;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgtika = itemView.findViewById(R.id.imageViewtika);
        }
    }
}

package com.meri.simplemehndidesigns;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class back_detail extends Fragment {

    private ViewPager2 mViewPager;



    String purl;



    public back_detail() {

    }
    public back_detail(String purl) {
        this.purl = purl;

    }


    // TODO: Rename and change types and number of parameters
    public static back_detail newInstance(String imageurl) {
        back_detail fragment = new back_detail();



        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_back_detail, container, false);
        PhotoView imageView = view.findViewById(R.id.imgbackdetail);
        ImageView shareback = view.findViewById(R.id.share_back);
        mViewPager = view.findViewById(R.id.view2);
       // viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this, getApplicationContext());


       // ImageView back = view.findViewById(R.id.back_front);
        Glide.with(getContext()).load(purl).into(imageView);
        shareback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("image/*");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(imageView));
                startActivity(Intent.createChooser(sharingIntent, "Share Image"));

            }
        });






        return view;
    }



    private Uri getLocalBitmapUri(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable) {
            bmp = ((BitmapDrawable) drawable).getBitmap();
        } else {
            return null;
        }
        Uri uri = null;
        try {
            File file = new File(getActivity().getExternalCacheDir(), "image_share_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.close();
            uri = FileProvider.getUriForFile(getActivity(), getActivity().getApplicationContext().getPackageName() + ".fileprovider", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uri;


}}



//
//   // public void onBackPressed(){
//
////        AppCompatActivity activity = (AppCompatActivity)getContext();
////        activity.getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutid,new BackFragment()).
////                addToBackStack(null).commit();
//
//  //  }
//
//
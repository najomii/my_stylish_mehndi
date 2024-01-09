package com.meri.simplemehndidesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class finger_detail_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String finger;
    Bitmap bitmap;
    public finger_detail_Fragment() {

    }
    public finger_detail_Fragment(String finger) {
        this.finger = finger;


    }



    public static finger_detail_Fragment newInstance(String param1, String param2) {
        finger_detail_Fragment fragment = new finger_detail_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_finger_detail_, container, false);


        PhotoView imageView = view.findViewById(R.id.imgFingerDetail);
        Glide.with(getContext()).load(finger).into(imageView);
        ImageView shareFinger = view.findViewById(R.id.shareFinger);
        ImageView back = view.findViewById(R.id.back_arrow);
        shareFinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("image/*");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(imageView));
                startActivity(Intent.createChooser(sharingIntent, "Share Image"));
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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
    }






    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(
                R.id.frameFinger,new fingerFragment()).addToBackStack(null).commit();

    }
}
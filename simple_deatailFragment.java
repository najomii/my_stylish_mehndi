package com.meri.simplemehndidesigns;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class simple_deatailFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String simple;

    PhotoView imageView;
    private ViewPager mViewPager;











    private Uri imageUri = null;



    private final static int CODE = 100;



    public simple_deatailFragment() {

    }
    public simple_deatailFragment(String simple) {
        this.simple = simple;


    }


    public static simple_deatailFragment newInstance(String param1, String param2) {
        simple_deatailFragment fragment = new simple_deatailFragment();
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

        View view = inflater.inflate(R.layout.fragment_simple_deatail, container, false);

          imageView = view.findViewById(R.id.imgSimpleDetail);
          ImageView shareSimple = view.findViewById(R.id.share_simple);
          ImageView backSimple = view.findViewById(R.id.back_simple);
          ImageView saveSimple = view.findViewById(R.id.savesimple);
        Glide.with(getContext()).load(simple).into(imageView);
        shareSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("image/*");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(imageView));
                startActivity(Intent.createChooser(sharingIntent, "Share Image"));
            }
        });









//        backSimple.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//
//
//            }
//        });



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





    public static simple_deatailFragment newInstance(ArrayList<String> imageUrls, int position) {
        simple_deatailFragment fragment = new simple_deatailFragment();
        Bundle args = new Bundle();
        args.putStringArrayList("imageUrls", imageUrls);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    private Intent getIntent() {
        return null;
    }


    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(
                R.id.simple_frame,new tikkaFragment()).addToBackStack(null).commit();
    }}







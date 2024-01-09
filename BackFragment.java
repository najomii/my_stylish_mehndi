package com.meri.simplemehndidesigns;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.Timer;
import java.util.TimerTask;


public class BackFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;



    myadapter adapter;



    String purl;


  //  DatabaseReference reference;
    public BackFragment() {

    }
    public BackFragment(String purl) {
        this.purl = purl;

    }


    public static BackFragment newInstance(String param1, String param2) {
        BackFragment fragment = new BackFragment();
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


        View view= inflater.inflate(R.layout.fragment_back, container, false);
//        reference.keepSynced(true);

       // adapter = new DetailPagerAdapter(getSupportFragmentManager());






        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<Modal> options =
                new FirebaseRecyclerOptions.Builder<Modal>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("images"), Modal.class)
                        .build();



                        //    databaseReference.keepSynced(true);


        adapter = new myadapter(options);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private Object getSupportFragmentManager() {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
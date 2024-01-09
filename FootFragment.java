package com.meri.simplemehndidesigns;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class FootFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    footAdapter adapterfoot;
    String purl;


    private String mParam1;
    private String mParam2;

    public FootFragment() {
        // Required empty public constructor
    }


    public static FootFragment newInstance(String param1, String param2) {
        FootFragment fragment = new FootFragment();
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

       View view = inflater.inflate(R.layout.fragment_foot, container, false);
        recyclerView = view.findViewById(R.id.recfoot);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        FirebaseRecyclerOptions<Foot> options =
                new FirebaseRecyclerOptions.Builder<Foot>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Foot"), Foot.class)
                        .build();


        adapterfoot = new footAdapter(options);
        recyclerView.setAdapter(adapterfoot);

       return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapterfoot.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapterfoot.stopListening();
    }
}
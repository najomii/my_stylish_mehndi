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

public class fingerFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    fingerAdapter adapterfinger;



    private String mParam1;
    private String mParam2;
    String finger;
    public fingerFragment() {

    }



    public static fingerFragment newInstance(String param1, String param2) {
        fingerFragment fragment = new fingerFragment();
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

        View view= inflater.inflate(R.layout.fragment_finger, container, false);
        recyclerView = view.findViewById(R.id.recfinger);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        FirebaseRecyclerOptions<Finger> options =
                new FirebaseRecyclerOptions.Builder<Finger>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Finger"), Finger.class)
                        .build();
        adapterfinger = new fingerAdapter(options);
        recyclerView.setAdapter(adapterfinger);


        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapterfinger.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapterfinger.stopListening();
    }
}
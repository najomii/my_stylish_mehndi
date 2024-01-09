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

public class frontFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    frontAdapter adp;
    public frontFragment() {
        // Required empty public constructor
    }

    public static frontFragment newInstance(String param1, String param2) {
        frontFragment fragment = new frontFragment();
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

        View view= inflater.inflate(R.layout.fragment_front, container, false);
        recyclerView = view.findViewById(R.id.recFront);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<Front> options =
                new FirebaseRecyclerOptions.Builder<Front>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Front"), Front.class)
                        .build();
        //adp = new myadapter(options);
        adp = new frontAdapter(options);
        recyclerView.setAdapter(adp);


        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adp.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adp.stopListening();
    }
}
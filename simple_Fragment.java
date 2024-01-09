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

public class simple_Fragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    simpleAdapter adaptersimple;

    public simple_Fragment() {

    }


    public static simple_Fragment newInstance(String param1, String param2) {
        simple_Fragment fragment = new simple_Fragment();
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

        View view= inflater.inflate(R.layout.fragment_simple_, container, false);
        recyclerView = view.findViewById(R.id.recsimple);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<Simple> options =
                new FirebaseRecyclerOptions.Builder<Simple>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Simple"), Simple.class)
                        .build();
        adaptersimple = new simpleAdapter(options);
        recyclerView.setAdapter(adaptersimple);


        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adaptersimple.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adaptersimple.stopListening();
    }
}
package com.meri.simplemehndidesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.util.ArrayList;

public class DetailScreen extends AppCompatActivity {
    ImageView imageView ;
    ImageView imageView1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
       // imageView = findViewById(R.id.imgV);
        imageView1 = findViewById(R.id.imageViewfinger);





    }
}
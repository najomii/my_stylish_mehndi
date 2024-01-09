package com.meri.simplemehndidesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    ShapeableImageView img1;

    ShapeableImageView img2;
    ShapeableImageView img3;
    ShapeableImageView img4;
    ShapeableImageView img5;
    ShapeableImageView img6;
    ImageView view;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.back);
        img2 = findViewById(R.id.finger);
        img3 = findViewById(R.id.footDsn);
        img4 = findViewById(R.id.frontdsn);
        img5 = findViewById(R.id.simpleDsn);
        img6 = findViewById(R.id.tikkaDsn);
        view = findViewById(R.id.sha);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shr = "Your Subject here";
                String shareBody = "body here";
                intent.putExtra(Intent.EXTRA_SUBJECT,shr);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share "));
            }
        });








        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,backActivity.class);
               startActivity(intent);

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,fingerActivity2.class);
                startActivity(intent);

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,footActivity2.class);
                startActivity(intent);

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,frontActivity2.class);
                startActivity(intent);

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,simpleActivity2.class);
                startActivity(intent);

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,tikkaActivity2.class);
                startActivity(intent);


            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case   R.id.rateUs:
//                Toast.makeText(this,"Rate Us",Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//        return true;
 //   }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();

                    }
                })
                        .setNegativeButton("No",null).show();


     //   super.onBackPressed();
    }
}
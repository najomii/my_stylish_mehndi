package com.meri.simplemehndidesigns;

import android.app.Application;
import android.widget.FrameLayout;

import com.google.firebase.database.FirebaseDatabase;

public class security extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}

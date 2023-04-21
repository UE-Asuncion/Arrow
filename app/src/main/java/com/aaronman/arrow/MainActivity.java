package com.aaronman.arrow;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
public class MainActivity extends AppCompatActivity {
//    static{
//
//        if(OpenCVLoader.initDebug()){
//
//            Log.d(“Check”,”OpenCv configured successfully”);
//
//        } else{
//
//            Log.d(“Check”,”OpenCv doesn’t configured successfully”);
//
//        }
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
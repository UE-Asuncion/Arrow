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

import org.xmlpull.v1.XmlPullParser;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Fragment Manager
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        int id = fragmentManager.beginTransaction()
                .replace(R.id.camera_container, Camera.class, null, "main_camera")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
        if (id > 0) { fragmentManager.popBackStack(); }
        //overriding onBackPressed
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageButton camButton = findViewById(R.id.camera_button);
        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Log","Open Cam");
            }

        });

    }
}
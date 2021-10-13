package com.raychal.simpleapp.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.raychal.simpleapp.R;
import com.raychal.simpleapp.ui.main.MainActivity;


public class ActivitySpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySpalshScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}
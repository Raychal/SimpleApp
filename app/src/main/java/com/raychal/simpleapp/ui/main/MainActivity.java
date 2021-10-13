package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.raychal.simpleapp.R;
import com.raychal.simpleapp.ui.detail.OlahragaActivity;
import com.raychal.simpleapp.ui.detail.TentangActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTentang = findViewById(R.id.tentang);
        Button btnOlahraga = findViewById(R.id.olahraga);

        btnTentang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TentangActivity.class);
            startActivity(intent);
            finish();
        });

        btnOlahraga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OlahragaActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
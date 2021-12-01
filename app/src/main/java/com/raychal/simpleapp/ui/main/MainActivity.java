package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.raychal.simpleapp.databinding.ActivityMainBinding;
import com.raychal.simpleapp.db.SqliteHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private SqliteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        db = new SqliteHelper(this);
        this.setTitle("Halaman Utama");

        boolean checkSession = db.checkSession("kosong");
        if (checkSession) {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

        binding.logout.setOnClickListener(this);
        binding.tentang.setOnClickListener(v -> startActivity( new Intent(MainActivity.this, TentangActivity.class)));
        binding.olahraga.setOnClickListener(v -> startActivity( new Intent(MainActivity.this, OlahragaActivity.class)));
    }


    @Override
    public void onClick(View view) {
        boolean updateSession = db.upgradeSession("ada", 1);
        if (updateSession) {
            Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
}
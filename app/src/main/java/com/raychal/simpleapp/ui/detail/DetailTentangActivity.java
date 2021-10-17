package com.raychal.simpleapp.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.raychal.simpleapp.R;
import com.raychal.simpleapp.databinding.ActivityDetailTentangBinding;
import com.raychal.simpleapp.model.UserModel;

public class DetailTentangActivity extends AppCompatActivity {

    private ActivityDetailTentangBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tentang);
        binding = ActivityDetailTentangBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        this.setTitle("Detail Anggota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("OBJECT_USER")){
            UserModel userModel = (UserModel) this.getIntent().getParcelableExtra("OBJECT_USER");
            if (userModel != null){
                binding.imageUser.setImageResource(Integer.parseInt(userModel.getAvatar()));
                binding.tvUsername.setText(userModel.getUsername());
                binding.tvName.setText(userModel.getName());
                binding.tvNim.setText(userModel.getNim());
                binding.tvAlamat.setText(userModel.getAlamat());
                binding.tvHobi.setText(userModel.getHobi());
                binding.tvProdi.setText(userModel.getProgram_studi());
                binding.tvUniv.setText(userModel.getUniversitas());
            }
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
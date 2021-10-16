package com.raychal.simpleapp.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.raychal.simpleapp.R;
import com.raychal.simpleapp.databinding.ActivityDetailOlahragaBinding;
import com.raychal.simpleapp.model.DiscussionModel;

public class DetailOlahragaActivity extends AppCompatActivity {

    private ActivityDetailOlahragaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_olahraga);
        binding = ActivityDetailOlahragaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.setTitle("Detail Olahraga");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("OBJECT_DISCUSSION")){
            DiscussionModel discussionModel = (DiscussionModel) this.getIntent().getParcelableExtra("OBJECT_DISCUSSION");
            if (discussionModel != null){
                binding.textTitle.setText(discussionModel.getTitle());
                binding.tvSubtitle.setText(discussionModel.getSubtitle());
                binding.imageView.setImageResource(Integer.parseInt(discussionModel.getAvatar()));
                binding.imageDiscussion.setImageResource(Integer.parseInt(discussionModel.getAvatar_content()));
                binding.tvContent.setText(discussionModel.getContent());
                binding.tvHistory.setText(discussionModel.getHistory());
                binding.tvReferensi.setText(discussionModel.getReference());
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
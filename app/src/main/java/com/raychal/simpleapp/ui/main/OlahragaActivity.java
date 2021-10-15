package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.raychal.simpleapp.databinding.ActivityOlahragaBinding;
import com.raychal.simpleapp.model.DiscussionModel;
import com.raychal.simpleapp.ui.adapter.DiscussionAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class OlahragaActivity extends AppCompatActivity {

    private ActivityOlahragaBinding binding;
    ArrayList<DiscussionModel> discussionModels;
    DiscussionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOlahragaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        this.setTitle("Macam Olahraga");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        discussionModels = new ArrayList<>();
        extractDiscussion();
    }

    private void extractDiscussion() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray discussionArray = obj.getJSONArray("discussion");
            Resources resources = getResources();

            for (int i = 0; i < discussionArray.length(); i++) {
                JSONObject discussion = discussionArray.getJSONObject(i);
                String title = discussion.getString("title");
                String subtitle = discussion.getString("subtitle");
                String avatar = discussion.getString("avatar");
                String avatar_content = discussion.getString("avatar_content");
                String content = discussion.getString("content");
                String history = discussion.getString("history");
                String reference = discussion.getString("reference");

                String resourceId = String.valueOf(resources.getIdentifier(avatar, "drawbale", this.getPackageName()));
                String resourceId1 = String.valueOf(resources.getIdentifier(avatar_content, "drawbale", this.getPackageName()));

                DiscussionModel discussionDetails = new DiscussionModel(title, subtitle, resourceId, resourceId1, content, history, reference);

                discussionModels.add(discussionDetails);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        binding.rvOlahraga.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DiscussionAdapter(this, discussionModels);
        binding.rvOlahraga.setAdapter(adapter);
        binding.rvOlahraga.setHasFixedSize(true);
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("discussion.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
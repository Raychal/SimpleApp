package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.raychal.simpleapp.databinding.ActivityTentangBinding;
import com.raychal.simpleapp.model.UserModel;
import com.raychal.simpleapp.ui.adapter.UserAdapter;
import com.raychal.simpleapp.ui.detail.DetailTentangActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TentangActivity extends AppCompatActivity implements UserAdapter.OnUsersListener {
    
    private ActivityTentangBinding binding;
    public static final String INTENT_PARCELABLE = "OBJECT_USER";
    ArrayList<UserModel> userModels;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTentangBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        this.setTitle("Anggota Kelompok");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userModels = new ArrayList<>();
        extractUsers();
    }

    private void extractUsers() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray("users");
            Resources resources = getResources();

            for (int i = 0; i < userArray.length(); i++) {
                JSONObject user = userArray.getJSONObject(i);
                String username = user.getString("username");
                String name = user.getString("name");
                String avatar = user.getString("avatar");
                String nim= user.getString("nim");
                String alamat = user.getString("alamat");
                String hobi = user.getString("hobi");
                String program_studi = user.getString("program_studi");
                String universitas = user.getString("universitas");

                int resourceId = resources.getIdentifier(avatar, "drawbale", this.getPackageName());

                UserModel userDetails = new UserModel(username, name, String.valueOf(resourceId), nim, alamat, hobi, program_studi, universitas);

                userModels.add(userDetails);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        binding.rvUser.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this, userModels, this);
        binding.rvUser.setAdapter(adapter);
        binding.rvUser.setHasFixedSize(true);
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("users.json");
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

    @Override
    public void onUsersClick(int position) {
        Intent intent = new Intent(this, DetailTentangActivity.class);
        intent.putExtra("OBJECT_USER", userModels.get(position));
        startActivity(intent);
    }
}
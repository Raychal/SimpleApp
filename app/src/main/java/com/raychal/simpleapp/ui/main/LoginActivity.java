package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.raychal.simpleapp.databinding.ActivityLoginBinding;
import com.raychal.simpleapp.db.SqliteHelper;
import com.raychal.simpleapp.model.User;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaration ViewBinding
    private ActivityLoginBinding binding;
    //Declaration SqliteHelper
    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        binding.btnLogin.setOnClickListener(this);
    }

    private void initCreateAccountTextView() {
        binding.tvCreateAccount.setText(fromHtml("<font color='#FF000000'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        binding.tvCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View v) {
        //Check user input is correct or not
        if (validate()) {
            //Get values from EditText fields
            String Email = Objects.requireNonNull(binding.inputEmail.getText()).toString();
            String Password = Objects.requireNonNull(binding.inputPassword.getText()).toString();

            //Authenticate user
            User currentUser = sqliteHelper.Authenticate(new User(null, null, Email, Password));

            //Check Authentication is successful or not
            if (currentUser != null) {
                boolean updateSession = sqliteHelper.upgradeSession("ada", 1);
                if (updateSession){
                    Snackbar.make(binding.btnLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                    //User Logged in Successfully Launch You home screen activity
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            } else {

                //User Logged in Failed
                Snackbar.make(binding.btnLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    //This method is for handling fromHtml method deprecation
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    private boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = Objects.requireNonNull(binding.inputEmail.getText()).toString();
        String Password = Objects.requireNonNull(binding.inputPassword.getText()).toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            binding.textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            binding.textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            binding.textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                binding.textInputLayoutPassword.setError(null);
            } else {
                binding.textInputLayoutPassword.setError("Password is to short!");
            }
        }
        return valid;
    }
}
package com.raychal.simpleapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.raychal.simpleapp.databinding.ActivityRegisterBinding;
import com.raychal.simpleapp.db.SqliteHelper;
import com.raychal.simpleapp.model.User;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaration ViewBinding
    private ActivityRegisterBinding binding;
    //Declaration SqliteHelper
    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        binding.btnRegis.setOnClickListener(this);
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = Objects.requireNonNull(binding.inputUsername.getText()).toString();
        String Email = Objects.requireNonNull(binding.inputEmail.getText()).toString();
        String Password = Objects.requireNonNull(binding.inputPassword.getText()).toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            binding.textInputLayoutUsername.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                binding.textInputLayoutEmail.setError(null);
            } else {
                binding.textInputLayoutPassword.setError("Username is to short!");
            }
        }

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

    private void initTextViewLogin() {
        binding.tvLogin.setText(fromHtml("<font color='#0c0099'>back to login</font>"));
        binding.tvLogin.setOnClickListener(view -> finish());
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

    @Override
    public void onClick(View v) {
        if (validate()) {
            String UserName = Objects.requireNonNull(binding.inputUsername.getText()).toString();
            String Email = Objects.requireNonNull(binding.inputEmail.getText()).toString();
            String Password = Objects.requireNonNull(binding.inputPassword.getText()).toString();


            //Check in the database is there any user associated with  this email
            if (!sqliteHelper.isEmailExists(Email)) {

                //Email does not exist now add new user to database
                sqliteHelper.addUser(new User(null, UserName, Email, Password));
                Snackbar.make(binding.btnRegis, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(this::finish, Snackbar.LENGTH_LONG);
            }else {

                //Email exists with email input provided so show error user already exist
                Snackbar.make(binding.btnRegis, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
            }


        }
    }
}
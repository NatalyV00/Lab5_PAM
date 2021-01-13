package com.example.telemedicine.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.telemedicine.R;
import com.google.android.material.button.MaterialButton;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        MaterialButton signUpBtn = findViewById(R.id.welcome_sign_up);
        MaterialButton loginBtn = findViewById(R.id.welcome_login);

        signUpBtn.setOnClickListener(view -> goSignUp());
        loginBtn.setOnClickListener(view -> goLogin());
    }

    private void goSignUp() {
        final Intent mainIntent = new Intent(WelcomeScreen.this, SignUpActivity.class);
        startActivity(mainIntent);
    }

    private void goLogin() {
        final Intent mainIntent = new Intent(WelcomeScreen.this, LoginActivity.class);
        startActivity(mainIntent);
    }
}

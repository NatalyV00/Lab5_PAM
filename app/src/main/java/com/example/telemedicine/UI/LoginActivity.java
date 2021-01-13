package com.example.telemedicine.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.telemedicine.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private MaterialButton loginBtn;
    private MaterialButton signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_login);
        signUpBtn = findViewById(R.id.login_sign_up);

        loginBtn.setOnClickListener(view -> goMainScreen());
        signUpBtn.setOnClickListener(view -> goSignUp());
    }

    private void goMainScreen() {
        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    private void goSignUp() {
        final Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}

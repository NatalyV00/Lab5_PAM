package com.example.telemedicine.UI;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.telemedicine.R;
import com.example.telemedicine.Utils.ImageUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {

    private static final int GET_FROM_GALLERY = 101;

    private TextInputEditText fullNameInput;
    private TextInputEditText usernameInput;
    private TextInputEditText passwordInput;
    private TextInputEditText birthdayInput;
    private TextInputEditText emailInput;
    private TextInputEditText phoneInput;
    private TextInputEditText addressInput;

    private CircleImageView userImage;
    private String base64Photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageButton backBtn = findViewById(R.id.sign_up_back);
        MaterialButton continueBtn = findViewById(R.id.sign_up_continue);
        fullNameInput = findViewById(R.id.sign_up_fullname);
        usernameInput = findViewById(R.id.sign_up_username);
        passwordInput = findViewById(R.id.sign_up_password);
        birthdayInput = findViewById(R.id.sign_up_birthday);
        emailInput = findViewById(R.id.sign_up_email);
        phoneInput = findViewById(R.id.sign_up_phone);
        addressInput = findViewById(R.id.sign_up_address);

        userImage = findViewById(R.id.sign_up_photo);
        userImage.setOnClickListener(view -> startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY));

        backBtn.setOnClickListener(view -> goBack());
        continueBtn.setOnClickListener(view -> userRegister());
    }

    public void userRegister() {
        goToLogin();
    }

    public void goToLogin() {
        final Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void goBack() {
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                base64Photo = ImageUtil.convert(bitmap);
                userImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchLoginActivity(View view) {
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
    }

    public void launchRegisterActivity(View view) {
        Intent intentRegister = new Intent(this, RegisterActivity.class);
        startActivity(intentRegister);
    }
}
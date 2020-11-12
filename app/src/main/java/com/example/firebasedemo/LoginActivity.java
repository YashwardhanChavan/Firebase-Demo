package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        mEditTextEmail = findViewById(R.id.edittext_email_loginAct);
        mEditTextPassword = findViewById(R.id.edittext_password_loginAct);
    }

    public void loginUser(View view) {
        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Enter all the Login Credentials!", Toast.LENGTH_SHORT).show();
        } else {
            login(email, password);
        }
    }

    public void login(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
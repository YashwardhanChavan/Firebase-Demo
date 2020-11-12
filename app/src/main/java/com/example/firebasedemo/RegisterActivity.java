package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEditTextEmail = findViewById(R.id.edittext_email);
        mEditTextPassword = findViewById(R.id.edittext_password);
        auth = FirebaseAuth.getInstance();
    }

    public void registerUser(View view) {
        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter email and password!", Toast.LENGTH_SHORT).show();
        }
        else if (password.length() < 6){
            Toast.makeText(this, "Password is too short!", Toast.LENGTH_SHORT).show();
        }
        else{
            register(email, password);
        }
    }

    public void register(String email, String password){
        auth.createUserWithEmailAndPassword(email, password);
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
    }
}
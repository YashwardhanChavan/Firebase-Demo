package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private EditText mEditTextName;
    private EditText mEditTextUsername;
    private EditText mEditTextContact;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEditTextEmail = findViewById(R.id.edittext_email);
        mEditTextPassword = findViewById(R.id.edittext_password);
        mEditTextName = findViewById(R.id.edittext_name);
        mEditTextUsername = findViewById(R.id.edittext_user_name);
        mEditTextContact = findViewById(R.id.edittext_contact_number);
        auth = FirebaseAuth.getInstance();
    }

    public void registerUser(View view) {
        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();
        String name = mEditTextName.getText().toString();
        String username = mEditTextUsername.getText().toString();
        String contact = mEditTextContact.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(name) || TextUtils.isEmpty(username) || TextUtils.isEmpty(contact)){
            Toast.makeText(this, "Enter all the Credentials!", Toast.LENGTH_SHORT).show();
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

        HashMap<String, Object> map = new HashMap<>();
        map.put("Name", mEditTextName.getText().toString());
        map.put("Username", mEditTextUsername.getText().toString());
        map.put("Contact", mEditTextContact.getText().toString());
        map.put("Email Address", mEditTextEmail.getText().toString());
        FirebaseDatabase.getInstance().getReference().push().updateChildren(map);

        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
    }
}
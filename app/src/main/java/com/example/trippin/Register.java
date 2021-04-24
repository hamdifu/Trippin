package com.example.trippin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    EditText editName, editEmail, editPassword;
    private ProgressBar progressBar;
    Button registerUser, loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editName = (EditText) findViewById(R.id.fullName);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }


    public void loginFunc(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void registerFunc(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String name = editName.getText().toString().trim();

        if(name.isEmpty()) {
            editName.setError("Name is required!");
            editName.requestFocus();
            return;
        }

        if(email.isEmpty()) {
            editEmail.setError("Email is required!");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Please provide valid email!");
            editEmail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            editPassword.setError("Password is required!");
            editPassword.requestFocus();
            return;
        }

        if(password.length() < 6) {
            editPassword.setError("Min password length should be 6 characters");
            editPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            User user = new User(name, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User has been registered successfully!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);

                                        startActivity(new Intent(Register.this, Home.class));
                                        //Intent intent1 = new Intent(Register.this, Home.class);
                                        //startActivity(intent1);
                                    }else {
                                        Toast.makeText(Register.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }else {
                            Toast.makeText(Register.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}
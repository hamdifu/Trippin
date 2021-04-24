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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button register, loginButton, signIn;
    private EditText editEmail, editPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        loginButton = (Button) findViewById(R.id.loginButton);

        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        forgotPassword.setOnClickListener(this);
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
            case R.id.register:
                startActivity(new Intent(this, Register.class));
                break;

            case R.id.loginButton:
                startActivity(new Intent(this, Login.class));

            case R.id.signIn:
                userLogin();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
        }
    }

    private void userLogin() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

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
            editPassword.setError("Min password length is 6 characters!");
            editPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(Login.this, "You are now Logged In!!", Toast.LENGTH_SHORT).show();
                    //redirect to user profile or home screen
                    startActivity(new Intent(Login.this, Home.class));
                    //Intent intent1 = new Intent(Login.this, Home.class);
                    //startActivity(intent1);
                }else {
                    Toast.makeText(Login.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
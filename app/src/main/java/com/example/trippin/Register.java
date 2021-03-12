package com.example.trippin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_register);
    }

    public void loginFunc(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void registerFunc(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
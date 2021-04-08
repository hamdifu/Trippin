package com.example.trippin;


import  com.example.trippin.adapter.PlaceAutoSuggester;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Home extends AppCompatActivity implements View.OnClickListener {
    AutoCompleteTextView autoComplete =null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    Button famousDestination,Budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoComplete  = (AutoCompleteTextView)findViewById(R.id.city);
        famousDestination = (Button)findViewById(R.id.FamousDestination) ;
        Budget =(Button)findViewById(R.id.budget);
        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places);
        autoComplete.setThreshold(1);
        famousDestination.setOnClickListener(this);
        Budget.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==famousDestination)
        {
            Intent intent = new Intent(Home.this,FamousDestinations.class);
            startActivity(intent);
        }
        if(v==Budget)
        {
            Intent intent = new Intent(Home.this,Budget.class);
            startActivity(intent);
        }

    }
}


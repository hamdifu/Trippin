package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.trippin.adapter.PlaceAutoSuggester;

public class Couches extends AppCompatActivity {
    AutoCompleteTextView city =null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couches);
        city  = (AutoCompleteTextView)findViewById(R.id.c);
        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places);
        city.setThreshold(1);
        city.setAdapter(adapter);
        city.setThreshold(1);
        city.setAdapter(adapter);
    }
}
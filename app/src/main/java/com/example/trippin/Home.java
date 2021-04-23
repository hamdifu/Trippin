package com.example.trippin;


import  com.example.trippin.adapter.PlaceAutoSuggester;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Home extends AppCompatActivity implements View.OnClickListener {
    AutoCompleteTextView autoComplete =null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    Button famousDestination,Budget;
    CardView flight,train,hotel,couch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        autoComplete  = (AutoCompleteTextView)findViewById(R.id.city);
        famousDestination = (Button)findViewById(R.id.FamousDestination) ;
        Budget =(Button)findViewById(R.id.budget);
        flight = (CardView) findViewById(R.id.flight);
        train = (CardView) findViewById(R.id.train);
        hotel = (CardView) findViewById(R.id.hotel);
        couch = (CardView) findViewById(R.id.couch);
        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places);
        autoComplete.setThreshold(1);
        autoComplete.setAdapter(adapter);
        famousDestination.setOnClickListener(this);
        Budget.setOnClickListener(this);
        flight.setOnClickListener(this);
        train.setOnClickListener(this);
        hotel.setOnClickListener(this);
        couch.setOnClickListener(this);


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
        if(v==flight)
        {
            Intent intent = new Intent(Home.this,Flights.class);
            startActivity(intent);
        }
        if(v==train)
        {
            Intent intent = new Intent(Home.this,Trains.class);
            startActivity(intent);
        }
        if(v==hotel)
        {
            Intent intent = new Intent(Home.this,Hotels.class);
            startActivity(intent);
        }
        if(v==couch)
        {
            Intent intent = new Intent(Home.this,Couches.class);
            startActivity(intent);
        }


    }

}


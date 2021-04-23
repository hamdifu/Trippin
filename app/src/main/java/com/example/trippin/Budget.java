package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Budget extends AppCompatActivity {

    Double flight,train,hotel;
    EditText f,t,h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        f = (EditText)findViewById(R.id.f);
        t = (EditText)findViewById(R.id.t);
        h = (EditText)findViewById(R.id.h);

    }

    public Double getFlight()
    {
        flight = Double.parseDouble(f.getText().toString());
        return flight;
    }
    public Double getTrain()
    {
        train = Double.parseDouble(t.getText().toString());
        return train;
    }
    public Double getHotel()
    {
      hotel = Double.parseDouble(h.getText().toString());
        return hotel;
    }
}
package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.trippin.adapter.PlaceAutoSuggester;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Flights extends AppCompatActivity implements View.OnClickListener {
    ArrayList<JSONObject> data= new ArrayList<>();
    AutoCompleteTextView from =null;
    AutoCompleteTextView to =null;
    EditText ArrivalDate = null;
    EditText DepartureDate = null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    ScrollView s;
    ArrayList<TextView> f = new ArrayList<>();
    ArrayList<TextView> t = new ArrayList<>();
    ArrayList<TextView> price = new ArrayList<>();
    ArrayList<TextView> departure = new ArrayList<>();
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        from  = (AutoCompleteTextView)findViewById(R.id.f);
        to  = (AutoCompleteTextView)findViewById(R.id.t);
        DepartureDate = (EditText)findViewById(R.id.dd);
        ArrivalDate = (EditText)findViewById(R.id.ad);
        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places);
        from.setThreshold(1);
        from.setAdapter(adapter);
        to.setThreshold(1);
        to.setAdapter(adapter);
        ArrivalDate.setOnClickListener(this);
        DepartureDate.setOnClickListener(this);
        s = (ScrollView)findViewById(R.id.scr);
        try {
            JSONObject json = new JSONObject(JSONDataFromAssets("Flights.json"));
            JSONArray jsonArray = json.getJSONArray("flight");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject j = jsonArray.getJSONObject(i);
                data.add(j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        f.add(findViewById(R.id.f1));
        f.add(findViewById(R.id.f2));
        f.add(findViewById(R.id.f3));
        f.add(findViewById(R.id.f4));
        f.add(findViewById(R.id.f5));
        f.add(findViewById(R.id.f6));
        f.add(findViewById(R.id.f7));
        f.add(findViewById(R.id.f8));
        t.add(findViewById(R.id.t1));
        t.add(findViewById(R.id.t2));
        t.add(findViewById(R.id.t3));
        t.add(findViewById(R.id.t4));
        t.add(findViewById(R.id.t5));
        t.add(findViewById(R.id.t6));
        t.add(findViewById(R.id.t7));
        t.add(findViewById(R.id.t8));
        price.add(findViewById(R.id.p1));
        price.add(findViewById(R.id.p2));
        price.add(findViewById(R.id.p3));
        price.add(findViewById(R.id.p4));
        price.add(findViewById(R.id.p5));
        price.add(findViewById(R.id.p6));
        price.add(findViewById(R.id.p7));
        price.add(findViewById(R.id.p8));
        departure.add(findViewById(R.id.ti1));
        departure.add(findViewById(R.id.ti2));
        departure.add(findViewById(R.id.ti3));
        departure.add(findViewById(R.id.ti4));
        departure.add(findViewById(R.id.ti5));
        departure.add(findViewById(R.id.ti6));
        departure.add(findViewById(R.id.ti7));
        departure.add(findViewById(R.id.ti8));

    }

    private String JSONDataFromAssets(String file){
        String json = null;
        try {
            InputStream inputStream=getAssets().open(file);
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public void onClick(View v) {
        if(v==DepartureDate)
        {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                       DepartureDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
        if(v==ArrivalDate)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                        ArrivalDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

    }

    public void back(View view) {
        finish();
    }

    public void logout(View view) {
        //logout firebase
    }

    public void search(View view) {
        String city_from = from.getText().toString();
        String city_to = to.getText().toString();
        Collections.shuffle(data);
        s.setVisibility(View.VISIBLE);
        for(int i=0;i<8;i++) {
            try {
                String name = data.get(i).getString("FlightName");
                t.get(i).setText(city_to);
                String dtime=data.get(i).getString("DepartureTime");
                departure.get(i).setText("Departure Time : "+dtime);
                f.get(i).setText(city_from);
               String Price =  data.get(i).getString("Price");
               price.get(i).setText(Price);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
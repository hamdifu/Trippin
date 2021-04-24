package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.trippin.adapter.PlaceAutoSuggester;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Trains extends AppCompatActivity implements View.OnClickListener {
    AutoCompleteTextView from =null;
    AutoCompleteTextView to =null;
    EditText ArrivalDate = null;
    EditText DepartureDate = null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<JSONObject> data= new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains);
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
        try {
            JSONObject json = new JSONObject(JSONDataFromAssets("Trains.json"));
            JSONArray jsonArray = json.getJSONArray("train");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject j = jsonArray.getJSONObject(i);
                data.add(j);
            }
            Collections.shuffle(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //to access json data
        //data.get(index).getString("TrainName")
        //data.get(index).getString("DepartureTime")
        //data.get(index).getString("Price")
        // index variable bna lio
        // use loop main increase karti rahio
        //main train and flight ki company ke logo ke image assets dhoondti hu tab tak

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
}
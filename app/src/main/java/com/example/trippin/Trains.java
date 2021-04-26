package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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

public class Trains extends AppCompatActivity implements View.OnClickListener {
    ArrayList<JSONObject> data= new ArrayList<>();
    AutoCompleteTextView from =null;
    AutoCompleteTextView to =null;
    EditText ArrivalDate = null;
    EditText DepartureDate = null;
    ArrayAdapter<String> adapter;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] places = p.getPlaces();
    private int mYear, mMonth, mDay;
    ScrollView s;
    ArrayList<TextView> f = new ArrayList<>();
    ArrayList<TextView> t = new ArrayList<>();
    ArrayList<TextView> price = new ArrayList<>();
    ArrayList<TextView> departure = new ArrayList<>();
    ArrayList<TextView> name = new ArrayList<>();
    EditText passenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        s = (ScrollView)findViewById(R.id.scr);
        passenger = findViewById(R.id.pa);
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
        f.add(findViewById(R.id.f1t));
        f.add(findViewById(R.id.f2t));
        f.add(findViewById(R.id.f3t));
        f.add(findViewById(R.id.f4t));
        f.add(findViewById(R.id.f5t));
        f.add(findViewById(R.id.f6t));
        f.add(findViewById(R.id.f7t));
        f.add(findViewById(R.id.f8t));
        t.add(findViewById(R.id.t1t));
        t.add(findViewById(R.id.t2t));
        t.add(findViewById(R.id.t3t));
        t.add(findViewById(R.id.t4t));
        t.add(findViewById(R.id.t5t));
        t.add(findViewById(R.id.t6t));
        t.add(findViewById(R.id.t7t));
        t.add(findViewById(R.id.t8t));
        price.add(findViewById(R.id.p1t));
        price.add(findViewById(R.id.p2t));
        price.add(findViewById(R.id.p3t));
        price.add(findViewById(R.id.p4t));
        price.add(findViewById(R.id.p5t));
        price.add(findViewById(R.id.p6t));
        price.add(findViewById(R.id.p7t));
        price.add(findViewById(R.id.p8t));
        departure.add(findViewById(R.id.ti1t));
        departure.add(findViewById(R.id.ti2t));
        departure.add(findViewById(R.id.ti3t));
        departure.add(findViewById(R.id.ti4t));
        departure.add(findViewById(R.id.ti5t));
        departure.add(findViewById(R.id.ti6t));
        departure.add(findViewById(R.id.ti7t));
        departure.add(findViewById(R.id.ti8t));
        name.add(findViewById(R.id.tn1));
        name.add(findViewById(R.id.tn2));
        name.add(findViewById(R.id.tn3));
        name.add(findViewById(R.id.tn4));
        name.add(findViewById(R.id.tn5));
        name.add(findViewById(R.id.tn6));
        name.add(findViewById(R.id.tn7));
        name.add(findViewById(R.id.tn8));

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
    public void searcht(View view) {
        String city_from = from.getText().toString();
        String city_to = to.getText().toString();

        Collections.shuffle(data);
        s.setVisibility(View.VISIBLE);
        for(int i=0;i<8;i++) {
            try {
                String nm = data.get(i).getString("TrainName");
                name.get(i).setText(nm);
                t.get(i).setText(city_to);
                String dtime=data.get(i).getString("DepartureTime");
                departure.get(i).setText("Departure Time : "+dtime);
                f.get(i).setText(city_from);
                String Price =  data.get(i).getString("Price");
                price.get(i).setText("₹"+Price);
//                int p= Integer.parseInt(Price) * Integer.parseInt(people);
                price.get(i).setText(Price);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void back(View view) {
        finish();
    }

    public void logout(View view) {
    }

    public void buy(View view) {
        String tag = view.getTag().toString();
        int index = Integer.parseInt(tag)-1;
        Intent intent = new Intent(Trains.this,Buy.class);
        intent.putExtra("name",name.get(index).getText().toString());
        intent.putExtra("to",to.getText().toString());
        intent.putExtra("from",from.getText().toString());
        intent.putExtra("dtime",departure.get(index).getText().toString());
        String Price = null;
        try {
            intent.putExtra("name",data.get(index).getString("TrainName"));
            Price = data.get(index).getString("Price");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String people = passenger.getText().toString();
        intent.putExtra("people",Integer.parseInt(people));
        intent.putExtra("price",Integer.parseInt(Price));
        intent.putExtra("dday",DepartureDate.getText().toString());
        intent.putExtra("type","train");
        startActivity(intent);
    }
}
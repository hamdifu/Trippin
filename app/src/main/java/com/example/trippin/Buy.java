package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Buy extends AppCompatActivity{
    TextView dest,airline,ft,passenger,adt,ati,pp,tax,totalp;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Intent intent= getIntent();
        String to = intent.getStringExtra("to");
        String from = intent.getStringExtra("from");
        String d = intent.getStringExtra("dday");
        String dtime = intent.getStringExtra("dtime");
        String name = intent.getStringExtra("name");
        Integer people = intent.getIntExtra("people",1);
        Integer price = intent.getIntExtra("price",1000);
        String type = intent.getStringExtra("type");
        dest = findViewById(R.id.dest);
        airline = findViewById(R.id.airline);
        ft = findViewById(R.id.ft);
        passenger = findViewById(R.id.passenger);
        adt = findViewById(R.id.adt);
        ati = findViewById(R.id.ati);
        pp = findViewById(R.id.pp);
        tax = findViewById(R.id.tax);
        totalp = findViewById(R.id.totalp);
        logo = findViewById(R.id.logo);
        dest.setText(to);
        airline.setText(name);
        String atival = ati.getText().toString() + "  " + dtime;
        String pval = passenger.getText().toString() + " "+Integer.toString(people);
        passenger.setText(pval);
        ati.setText(atival);
        String adtval = adt.getText().toString() + " " + d;
        adt.setText(adtval);
        String priceval = pp.getText().toString() + "  ₹" + price;
        pp.setText(priceval);
        Double taxv = price * people * 0.08;
        String val = tax.getText().toString() + "  ₹" + Double.toString(taxv);
        tax.setText(val);
        Double total = taxv  + (price*people);
        String ppval = totalp.getText().toString() + "  ₹" + Double.toString(total);
        totalp.setText(ppval);
        String fromto = from + " ••• " + to;
        ft.setText(fromto);
        if(type.compareTo("train")==0)
            logo.setVisibility(View.INVISIBLE);
        else if(type.compareTo("flight")==0){
            if (name.compareTo("Go Air")==0){
                logo.setImageResource(R.drawable.trujet);
            }
            else if(name.compareTo("Air Asia")==0){
                logo.setImageResource(R.drawable.airasia);

            }
            else if(name.compareTo("IndiGo")==0){
                logo.setImageResource(R.drawable.indigo);

            }
            else if(name.compareTo("Air India")==0){
                logo.setImageResource(R.drawable.airindia);

            }
            else if(name.compareTo("Spicejet")==0){
                logo.setImageResource(R.drawable.spicejet);

            }
            else if(name.compareTo("Vistara")==0){
                logo.setImageResource(R.drawable.vistara);

            }
        }
    }

    public void back(View view) {
        finish();
    }

    public void logout(View view) {
        //logout from firebase
    }

    public void cart(View view) {
    }
}
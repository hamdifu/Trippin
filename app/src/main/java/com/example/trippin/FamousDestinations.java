package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.trippin.adapter.PlaceAutoSuggester;

public class FamousDestinations extends AppCompatActivity  {//implements View.OnClickListener
    Button varanasi,kerela,goa;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] fP = p.getFamousPlaces();
    String description;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_destinations);
        goa = findViewById(R.id.goa);
        kerela = findViewById(R.id.kerala);
        varanasi = findViewById(R.id.varanasi);
//        goa.setOnClickListener(this);
//        varanasi.setOnClickListener(this);
//        kerela.setOnClickListener(this);
    }

    public void info(View v) {
        if (v == goa) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.goa);
            title = fP[4];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
            intent.putExtra("image",R.drawable.goa);
            startActivity(intent);
        }

        if (v == kerela) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.kerela);
            title = fP[5];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
            intent.putExtra("image",R.drawable.kerala);
            startActivity(intent);
        }
        if (v == varanasi) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.varanasi);
            title = fP[6];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
            intent.putExtra("image",R.drawable.varanasi);
            startActivity(intent);
        }
    }

//    @Override
//    public void onClick(View v) {
//        if (v == goa) {
//            Intent intent = new Intent(this, DestinationsInormation.class);
//            description = getString(R.string.goa);
//            title = fP[4];
//            intent.putExtra("title",title);
//            intent.putExtra("description",description);
//            startActivity(intent);
//        }
//
//        if (v == kerela) {
//            Intent intent = new Intent(this, DestinationsInormation.class);
//            description = getString(R.string.kerela);
//            title = fP[5];
//            intent.putExtra("title",title);
//            intent.putExtra("description",description);
//            startActivity(intent);
//        }
//        if (v == varanasi) {
//            Intent intent = new Intent(this, DestinationsInormation.class);
//            description = getString(R.string.varanasi);
//            title = fP[6];
//            intent.putExtra("title",title);
//            intent.putExtra("description",description);
//                    startActivity(intent);
//        }
//
//    }
}
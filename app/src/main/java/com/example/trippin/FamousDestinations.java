package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.trippin.adapter.PlaceAutoSuggester;

public class FamousDestinations extends AppCompatActivity implements View.OnClickListener {
    ImageView varanasi,kerela,goa;
    PlaceAutoSuggester p = new PlaceAutoSuggester();
    String [] fP = p.getFamousPlaces();
    String description;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_destinations);
        goa = (ImageView) findViewById(R.id.img5);
        kerela = (ImageView)findViewById(R.id.img6);
        varanasi = (ImageView) findViewById(R.id.img7);
        goa.setOnClickListener(this);
        varanasi.setOnClickListener(this);
        kerela.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == goa) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.goa);
            title = fP[4];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
            startActivity(intent);
        }

        if (v == kerela) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.kerela);
            title = fP[5];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
            startActivity(intent);
        }
        if (v == varanasi) {
            Intent intent = new Intent(this, DestinationsInormation.class);
            description = getString(R.string.varanasi);
            title = fP[6];
            intent.putExtra("title",title);
            intent.putExtra("description",description);
                    startActivity(intent);
        }

    }
}
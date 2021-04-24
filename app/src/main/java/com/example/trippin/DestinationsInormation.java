package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

public class DestinationsInormation extends AppCompatActivity {

    JustifiedTextView tv;
    TextView title;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations_inormation);
        Intent intent= getIntent();
        tv = (JustifiedTextView) findViewById(R.id.tv);
        title = (TextView) findViewById(R.id.title);
        i = findViewById(R.id.pic);
        title.setText(intent.getStringExtra("title"));
        tv.setText(intent.getStringExtra("description"));
        i.setImageResource(intent.getIntExtra("image",R.drawable.varanasi));
    }

    public void back(View view) {
        finish();
    }
}
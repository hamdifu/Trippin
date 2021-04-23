package com.example.trippin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

public class DestinationsInormation extends AppCompatActivity {

    JustifiedTextView tv;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations_inormation);
        Intent intent= getIntent();
         tv = (JustifiedTextView) findViewById(R.id.tv);
         title = (TextView) findViewById(R.id.title);
         title.setText(intent.getStringExtra("title"));
        tv.setText(intent.getStringExtra("description"));
    }
}
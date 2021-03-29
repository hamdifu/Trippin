package com.example.trippin;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    EditText searchField;
    ImageButton searchButton;
    RecyclerView ResultList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.home);
        searchButton = (ImageButton) findViewById(R.id.imageButton);
        searchField = (EditText) findViewById(R.id.city);
        ResultList = (RecyclerView) findViewById(R.id.result_list);


    }

}

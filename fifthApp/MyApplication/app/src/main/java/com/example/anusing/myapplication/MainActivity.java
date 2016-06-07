package com.example.anusing.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView cityListView;
    String[] cities;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityListView = (ListView) findViewById(R.id.listView);
        // getResources gives acces of the resources
        cities = getResources().getStringArray(R.array.citiies);
        // to populate list views we need adapters
        adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.textView,cities);

        //attach the adapter to a list view
        cityListView.setAdapter(adapter);

    }
}

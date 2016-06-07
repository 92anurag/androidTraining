package com.example.anusing.countryinfoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {

    TextView countryListTextView;
    ArrayList<String> countryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        countryListTextView = (TextView) findViewById(R.id.textView);

        if(savedInstanceState != null){
            countryList = savedInstanceState.getStringArrayList("COUNTRY_LIST");
        }
    }

    private String getStringFromArrayList(ArrayList<String> list){
        StringBuffer buffer = new StringBuffer();
        String text =  null;
        for(String name : list){
            buffer.append(name);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public void addNewCountry(View view){
        Intent intent = new Intent(this,AddCounrtyActivity.class);
        // 101 is identifier for the child
        // each child activity should have a unique code
        startActivityForResult(intent,101);
    }

    // when of AddCountry List is called intent is passed to CountryList Added
    // capturing that
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK){
            String countryName = data.getStringExtra("COUNTRY_NAME");
            Log.i("CountryListActivity","Received "+ countryName + " from AddCountryList");
            // this will append to the list
            // countryListTextView.append("\n" + countryName);
            countryList.add(countryName);

        }
    }

    // we need to save state , so that we can switch between the view
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList("COUNTRY_LIST",countryList);
    }

    @Override
    // here also we can reinitialize the countryListTextView
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String text = getStringFromArrayList(countryList);
        countryListTextView.setText(text);
    }

    // activity goes into different modes 1. Active  2. Pause  3. Stop
    // when another activity start pervious is stopped (activity is not visible to the user .
    // now this 2nd activity finishes 1st activity gets active and we have onCreate , onStart , onResume methods
    // Pause happens when we have a dialog box


    // for preserving live objects of an activity and data we have fragments and if we need to preserve only data we can use savedInstance state
}

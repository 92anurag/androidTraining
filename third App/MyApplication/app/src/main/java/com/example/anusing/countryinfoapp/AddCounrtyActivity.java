package com.example.anusing.countryinfoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCounrtyActivity extends AppCompatActivity {

    // when we switch to landscape mode the activity on the top of the call stack will be destroyed and new will be created
    // if back button button is pressed than current acitivity will
    EditText countryNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_counrty);
        countryNameEditText = (EditText) findViewById(R.id.editText);
    }
    // intent has 2 purposes to pass data and launch an activity
    public void done(View view){
        String countryName = countryNameEditText.getText().toString();
        // create an empty intent
        // this is done to pass data around
        // is this was a new intent will be launched , we dont want that , we want to use the prevoius instance of countryListActivity inten
        // Intent intent = new Intent(this,CountryListActivity.class);
        Intent intent = new Intent();
        intent.putExtra("COUNTRY_NAME",countryName);

        // send intent to the parent activity
        // intent are independent
        // so we need to setup a relation , where to pass this intent
        setResult(RESULT_OK,intent);
        finish();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }


}

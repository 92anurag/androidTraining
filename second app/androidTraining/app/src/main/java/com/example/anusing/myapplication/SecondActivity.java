package com.example.anusing.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView userTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // for every activity we can have only one launchng intent
        // get access to the launching intent
        Intent launchingIntent = getIntent();

        //get string extra attached to the launching intent
        String userText = launchingIntent.getStringExtra(MainActivity.USER_TEXT_KEY);
        if(userText != null) {
            userTextView = (TextView) findViewById(R.id.textView);
            userTextView.setText(userText);
        }
    }

    public void back(View view){
        finish();
    }

}

package com.example.anusing.helloandroidapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("MainActivity","Activity Created");
        // error message use Log.e
        // for debug message use Log.d()
        // linmit of 24 characters for the tag

        // activity should be registered in AndroidManifest.xml


        // To get shell access
        //get path of sdk from - click on android studio , prefrences
        // click android sdk
        // copy this path on terminal
        // go to cd platform-tools/
        // ./adb devices - shows you all the devices connected to app
        // ./adb shell - gives you root access
        // cd /data/data
        // ls
        // select any
        // cd databases
        // sqlite3 <database-name>
        // .tables
        // .quit

        setContentView(R.layout.activity_main);
    }

    public void launchMain(View view){
        // create an intent for launching the main activity
        Intent intent = new Intent(this,MainActivity.class);
        //send the intent to android activity manager
        startActivity(intent);
    }

    public void browseInternet(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http:www.google.com"));
        startActivity(intent);
    }
    
    public void callPhone(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:555-555-5555"));
        startActivity(intent);
    }
}

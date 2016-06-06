package com.example.anusing.helloandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
}

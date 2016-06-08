package com.example.anusing.imagedownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void download (View view){
        // in the message queue  if the message is more than 5 secs , we see a message app not responding
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
    }
}

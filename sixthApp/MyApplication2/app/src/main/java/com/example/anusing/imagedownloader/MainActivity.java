package com.example.anusing.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private Bitmap getImage(String url){
        Bitmap image = null;
        try {
            URL link = new URL(url);
            URLConnection connection = link.openConnection();
            InputStream stream = connection.getInputStream();
            image = BitmapFactory.decodeStream(stream);
            return image ;
        }catch(MalformedURLException e){
            Log.i("MainActivity", "Malformed URL exception" + e.getMessage());
        } catch(IOException e){
            Log.i("MainActivity", "IO Exception" + e.getMessage());
        }

        return null;
    }

    // emulator runs on protected mode . so we cant do any network operation , so create a background thread


    public void download (View view){
        // in the message queue  if the message is more than 5 secs , we see a message app not responding
//        try{
//            Thread.sleep(10000);
//        }catch (InterruptedException e){
//            e.printStackTrace();;
//        }

        Bitmap image = getImage("http://pre13.deviantart.net/ba29/th/pre/i/2016/070/a/f/android_n_logo_by_stayka007-d9untw2.png");
        imageView.setImageBitmap(image);
    }
}

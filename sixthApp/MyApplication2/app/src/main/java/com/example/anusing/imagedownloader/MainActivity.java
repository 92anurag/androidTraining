package com.example.anusing.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

    // class which provides an interface which get attached to the message queue of the main thread

    class ImageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            Bitmap image = bundle.getParcelable("IMAGE");
            imageView.setImageBitmap(image);
        }
    }

    ImageHandler imageHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageHandler =  new ImageHandler();
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



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Bitmap image = getImage("http://pre13.deviantart.net/ba29/th/pre/i/2016/070/a/f/android_n_logo_by_stayka007-d9untw2.png");
                if(image != null) {
                    Log.i("MainActivity ","Image Download Complete");
                    // cant update UI elements from background thread , we need to notify main thread to update this
                    // to send a message to main thread create a handler, this will message in the message queue and the looper will than pick this in the message queue

                    // get access to message object
                    Message msg = Message.obtain();

                    // create a bundle that contains image
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("IMAGE",image);

                    // attach the bundle to message
                    msg.setData(bundle);

                    // send message to the handler
                    imageHandler.sendMessage(msg);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

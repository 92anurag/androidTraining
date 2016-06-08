package com.example.anusing.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

public class MainActivityAsync extends AppCompatActivity {

    ImageView imageView;

    class ImageDownloderTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            String link = params[0];
            Bitmap image = getImage(link);
            if(image != null){
                Log.i("ImageDownLoaderTask","Image Downloaded Successfully");
            }
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
                imageView.setImageBitmap(bitmap);
            }
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
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

    }


    public void download (View view){
        ImageDownloderTask task = new ImageDownloderTask();
        task.execute("http://www.androidcentral.com/sites/androidcentral.com/files/article_images/2016/03/n-bg-generic.jpg");
    }
}

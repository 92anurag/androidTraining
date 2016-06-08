package com.example.anusing.imagedownloader;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivityService extends AppCompatActivity {

    ImageView imageView;

    ResultReceiver imageReceiver = new ResultReceiver(new Handler()){
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            Bitmap image = resultData.getParcelable("IMAGE");
            imageView.setImageBitmap(image);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

    }


    public void download (View view){
        Intent intent = new Intent(this, DownLoaderService.class);
        intent.putExtra("URL", "http://www.androidcentral.com/sites/androidcentral.com/files/article_images/2016/03/n-bg-generic.jpg");
        intent.putExtra("RECEIVER",imageReceiver);
        startService(intent);
    }

    public void auto(View view){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent =new Intent(this, DownLoaderService.class);
        intent.putExtra("URL", "http://www.androidcentral.com/sites/androidcentral.com/files/article_images/2016/03/n-bg-generic.jpg");
        intent.putExtra("RECEIVER",imageReceiver);

        PendingIntent pIntent = PendingIntent.getService(this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        manager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 30000, pIntent);
    }
}

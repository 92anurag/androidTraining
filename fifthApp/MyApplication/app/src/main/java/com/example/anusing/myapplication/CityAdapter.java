package com.example.anusing.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anusing on 6/7/16.
 */
public class CityAdapter extends BaseAdapter
{

    String[] cities;
    Context context;

    LruCache<Integer, Bitmap> cache ;

    // In Android create static handler class
    static class ViewHolder {
        TextView tv;
        ImageView iv;
    }

    public CityAdapter(String[] cities, Context context) {
        this.cities = cities;
        this.context = context;

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);

        //Use 1.8th of teh available memory cache .
        final int cacheSize = maxMemory/8;

        cache = new LruCache<Integer, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(Integer key, Bitmap value) {
                return value.getByteCount()/1024;
            }
        };
    }

    @Override
    public int getCount() {
        return cities.length;
    }

    @Override
    public Object getItem(int position) {
        return cities[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mainView = null;


        if(convertView == null) {
            // inflate layout
            mainView = LayoutInflater.from(context).inflate(R.layout.row, null);
            ViewHolder vh =  new ViewHolder();
            vh.tv = (TextView) mainView.findViewById(R.id.textView);
            vh.iv = (ImageView) mainView.findViewById(R.id.imageView);

            // attach the view holder to the view
            mainView.setTag(vh);
        }else{
            mainView = convertView;
        }

        ViewHolder viewHolder = (ViewHolder)mainView.getTag();
        // world of list views - video during googleIO -2010

        String cityName = (String) getItem(position);
        viewHolder.tv.setText(cityName);

        Bitmap image = cache.get(R.drawable.tom);
        if(image != null){
            viewHolder.iv.setImageBitmap(image);
        }else{
            BitmapDrawable drawable = (BitmapDrawable)context.getResources().getDrawable(R.drawable.tom);
            Bitmap img = drawable.getBitmap();
            cache.put(R.drawable.tom,img);
            viewHolder.iv.setImageBitmap(img);
        }
        return mainView;
    }
}

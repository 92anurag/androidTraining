package com.example.anusing.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by anusing on 6/7/16.
 */
public class CityAdapter extends BaseAdapter
{

    String[] cities;
    Context context;

    public CityAdapter(String[] cities, Context context) {
        this.cities = cities;
        this.context = context;
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
        }else{
            mainView = convertView;
        }
        TextView tv = (TextView) mainView.findViewById(R.id.textView);

        String cityName = (String) getItem(position);
        tv.setText(cityName);
        return mainView;
    }
}

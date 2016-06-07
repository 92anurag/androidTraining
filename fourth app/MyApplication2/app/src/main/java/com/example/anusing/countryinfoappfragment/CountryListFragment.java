package com.example.anusing.countryinfoappfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryListFragment extends Fragment {
    Button addButton;
    TextView countryListView;
    AddCountry delegate;


    public static CountryListFragment newFragment(String arg1) {
        CountryListFragment frag = new CountryListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ARG1","First Argument");
        frag.setArguments(bundle);
        return frag;

    }
    public CountryListFragment() {

    }

    public void setDelegate(AddCountry c){
        delegate = c;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == 101){
            String countryName = data.getStringExtra("COUNTRY_NAME");
            Log.i("CountryListFragment", "Received "+ countryName + " from AddCountryFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);
        addButton = (Button) view.findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(delegate!=null){
                  delegate.switchToAddCountry();
              }
            }
        });
        countryListView = (TextView) view.findViewById(R.id.textView);
        return view;
    }

}

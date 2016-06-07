package com.example.anusing.countryinfoappfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) { // create fragment for the first time after that fragment manager will take care of adding a fragment
            addCountryListFragmemt();
        }
    }

    private void addCountryListFragmemt() {

        CountryListFragment frag = CountryListFragment.newFragment("ARG1");

        //get access to fragment manager
        FragmentManager manager = getSupportFragmentManager();

        // create a transaction
        FragmentTransaction trans = manager.beginTransaction();

        trans.add(R.id.mainLayout,frag,"CLF"); // "CLF is name of the fragment " , this will be used to search for the fragment

        trans.commit();


    }
}


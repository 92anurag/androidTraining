package com.example.anusing.countryinfoappfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AddCountry{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) { // create fragment for the first time after that fragment manager will take care of adding a fragment
            addCountryListFragmemt();
        }
    }

    public void switchToAddCountry() {
        AddCountryFragment frag = new AddCountryFragment();
        FragmentTransaction trans =getSupportFragmentManager().beginTransaction();
        Fragment clfFragment = getSupportFragmentManager().findFragmentByTag("CLF");

        //set the country list fragment as target of the add country fragment
        frag.setTargetFragment(clfFragment,101);
        trans.remove(clfFragment);
        trans.add(R.id.mainLayout,frag,"ACF");
        trans.addToBackStack("");
        trans.commit();
    }

    private void addCountryListFragmemt() {

        CountryListFragment frag = CountryListFragment.newFragment("ARG1");
        frag.setDelegate(this);

        //get access to fragment manager
        FragmentManager manager = getSupportFragmentManager();

        // create a transaction
        FragmentTransaction trans = manager.beginTransaction();

        trans.add(R.id.mainLayout,frag,"CLF"); // "CLF is name of the fragment " , this will be used to search for the fragment

        trans.commit();


    }
}


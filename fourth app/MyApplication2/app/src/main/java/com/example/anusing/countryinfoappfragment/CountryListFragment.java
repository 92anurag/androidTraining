package com.example.anusing.countryinfoappfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment; // compatibility below honeycomb
import android.support.v4.app.FragmentTransaction;
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


    public static CountryListFragment newFragment(String arg1) {
        CountryListFragment frag = new CountryListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ARG1","First Argument");
        frag.setArguments(bundle);
        return frag;

    }
    public CountryListFragment() {
    }

    private void switchToAddFragment() {
        AddCountryFragment frag = new AddCountryFragment();
        FragmentTransaction trans =getFragmentManager().beginTransaction();

        trans.remove(this);
        trans.add(R.id.mainLayout,frag,"ACF");
        trans.addToBackStack("");
        trans.commit();
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
                switchToAddFragment();
            }
        });
        countryListView = (TextView) view.findViewById(R.id.textView);
        return view;
    }

}

package com.example.anusing.countryinfoappfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddCountryFragment extends Fragment {

    Button cancelButton;
    Button doneButton;
    EditText countryNameEditText ;
    public AddCountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_country, container, false);
        cancelButton = (Button)  view.findViewById(R.id.button3);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getFragmentManager().getBackStackEntryCount() >0) {
                    getFragmentManager().popBackStack();
                }
            }
        });
        doneButton = (Button) view.findViewById(R.id.button2);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryName =  countryNameEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("COUNTRY_NAME",countryName);

                // send the intent to whichever fragment is set as target of this fragment
                getTargetFragment().onActivityResult(101,101,intent);
                if(getFragmentManager().getBackStackEntryCount() >0) {
                    getFragmentManager().popBackStack();
                }
            }
        });
        countryNameEditText = (EditText) view.findViewById(R.id.editText);
        return view;
    }

}

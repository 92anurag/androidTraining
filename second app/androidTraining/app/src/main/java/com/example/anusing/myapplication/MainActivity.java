package com.example.anusing.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This line basically creates a content view of the tree ,creates 4 objects , relative object , textview object, edittext object ,buttonView objet
        setContentView(R.layout.activity_main);

        // get a reference ti the edit text from the content view tree of the activity
        // this should be after view has inflated i.e after setContentView();
        userEditText = (EditText) findViewById(R.id.editText);
    }

    public void showText(View view){
        String userText = userEditText.getText().toString();
        // popup at the bottom which delivers message and disaapears
        // toast requires activity context and not application context , because in application context there is no window
        Toast.makeText(this, userText, Toast.LENGTH_SHORT).show();
    }
}

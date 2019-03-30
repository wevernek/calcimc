package com.example.calcimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables
    String gender;
    int weight;
    float tall;

    // Objects
    EditText myGender, myWeight, myTall;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGender = (EditText) findViewById(R.id.inpGender);
        myWeight = (EditText) findViewById(R.id.inpWeight);
        myTall = (EditText) findViewById(R.id.inpTall);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        // Define all characters in uppercase in this input
        myGender.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recover values entered
                gender = myGender.getText().toString();
                weight = Integer.parseInt(myWeight.getText().toString());
                tall = Float.parseFloat(myTall.getText().toString());

                Intent ViewResult = new Intent(MainActivity.this, ResultadoView.class);
                Bundle values = new Bundle();

                values.putString("valueGender", myGender.getText().toString());
                values.putString("valueWeight", myWeight.getText().toString());
                values.putString("valueTall", myTall.getText().toString());

                ViewResult.putExtras(values);
                startActivity(ViewResult);

            }
        });

    }
}

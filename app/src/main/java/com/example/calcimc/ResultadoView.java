package com.example.calcimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoView extends Activity {
    TextView gender, weight, tall, result;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Double weightN, tallN, imc;

        setContentView(R.layout.activity_resultado);

        gender = findViewById(R.id.txtGender);
        weight = findViewById(R.id.txtWeight);
        tall = findViewById(R.id.txtTall);
        result = findViewById(R.id.txtResult);

        Intent calcView = getIntent();
        Bundle values = calcView.getExtras();

        String genderS = values.getString("valueGender");
        String weightS = values.getString("valueWeight");
        String tallS = values.getString("valueTall");

        weightN = Double.valueOf(weightS);
        tallN = Double.valueOf(tallS);

        gender.setText(genderS);
        weight.setText(weightS);
        tall.setText(tallS);

        btnBack = (Button) findViewById(R.id.btnBack);

        // IMC formula
        imc = weightN / (tallN * tallN);

        switch(genderS) {
            // Case the gender be male
            case "M":
                if (imc < 20) {
                    result.setText("Below normal");
                } else if (imc > 20 && imc <= 24.9) {
                    result.setText("Normal");
                } else if (imc > 25 && imc <= 29.9) {
                    result.setText("Lightweight obesity");
                } else if (imc > 30 && imc <= 39.9) {
                    result.setText("Moderate obesity");
                } else if (imc > 43) {
                    result.setText("Morbid obesity");
                } else {
                    result.setText("Invalid data!");
                }
                break;
            // Case the gender be female
            case "F":
                if (imc < 19) {
                    result.setText("Below normal");
                } else if (imc > 19 && imc <= 23.9) {
                    result.setText("Normal");
                } else if (imc > 24 && imc <= 28.9) {
                    result.setText("Lightweight obesity");
                } else if (imc > 29 && imc <= 38.9) {
                    result.setText("Moderate obesity");
                } else if (imc > 39) {
                    result.setText("Morbid obesity");
                } else {
                    result.setText("Invalid data!");
                }
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

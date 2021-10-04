package com.example.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText edittext1, edittext2, edittext3, edittext4;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {
        edittext1 = (EditText) findViewById(R.id.editText1);
        edittext2 = (EditText) findViewById(R.id.editText2);
        edittext3 = (EditText) findViewById(R.id.editText3);
        edittext4 = (EditText) findViewById(R.id.editText4);
        buttonCalculate = (Button) findViewById(R.id.button);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1=edittext1.getText().toString();
                String value2=edittext2.getText().toString();
                String value3=edittext3.getText().toString();
                String value4=edittext4.getText().toString();

                double l=Double.parseDouble(value1);
                double p=Double.parseDouble(value2);
                double r=Double.parseDouble(value3) / 100;
                double y=Double.parseDouble(value4);
                double monthlyP = ((l+p)*Math.pow(1+r,y))/(y*12); //monthly payment amount
                double total = monthlyP*(y*12) - (l+p); //the total interest
                String display = String.valueOf(monthlyP) + "   " + String.valueOf(total);
                Toast.makeText(getApplicationContext(),String.valueOf(display), Toast.LENGTH_LONG).show();
            }
        });
    }

}
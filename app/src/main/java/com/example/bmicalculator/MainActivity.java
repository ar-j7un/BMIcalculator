package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);

        resultTextView = findViewById(R.id.resultTextView);
    }



    public void onCalc(View v) {
        calculateBMI();
    }


    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            float weight = Float.parseFloat(weightString);
            float height = Float.parseFloat(heightString) / 100; // Convert height to meters

            float bmi = weight / (height * height);

            String result;
            if (bmi < 18.5) {
                result = "You are Underweight";
            } else if (bmi < 24.9) {
                result = "You are Normal weight & Healthy";
            } else if (bmi < 29.9) {
                result = "You are Overweight";
            } else {
                result = "You are Obese";
            }

            resultTextView.setText("BMI: " + String.format("%.1f", bmi) + "\n" + result);
        }
    }
}
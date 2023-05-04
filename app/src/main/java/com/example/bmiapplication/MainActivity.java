package com.example.bmiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight;
        EditText editHeightFt;
        EditText editHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout lMain;

        editWeight =findViewById(R.id.editWeight);
        editHeightFt =findViewById(R.id.editHeightFt);
        editHeightIn =findViewById(R.id.editHeightIn);
        btnCalculate =findViewById(R.id.btmCalculate);
        txtResult = findViewById(R.id.txtResult);
        lMain = findViewById(R.id.lMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(editWeight.getText().toString());
                int ft =Integer.parseInt(editHeightFt.getText().toString());
                int in =Integer.parseInt(editHeightIn.getText().toString());

                int totalIn =ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi =wt/(totalM*totalM);

                if (bmi > 25) {
                    txtResult.setText("You are Overweight!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi<18) {
                    txtResult.setText("You are UnderWeight!!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else {
                    txtResult.setText("You are Healthy!!!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.colorH));

                }

            }
        });
    }
}
package com.mizanthecoder.myedittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText numberOne, numberTwo;
private Button addButton, subButton;
private TextView resultShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOne = (EditText) findViewById(R.id.numberone);
        numberTwo = (EditText) findViewById(R.id.numbertwo);
        addButton = (Button) findViewById(R.id.addbutton);
        subButton = (Button) findViewById(R.id.substractionbutton);
        resultShow = (TextView) findViewById(R.id.resultshow);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            String num1 = numberOne.getText().toString();
            String num2 = numberTwo.getText().toString();
// to convert string into double.
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            if (v.getId()==R.id.addbutton){

                double sum = n1+n2;
                resultShow.setText("Result : "+ sum);
            }
            if (v.getId()==R.id.substractionbutton){
                double sub = n1-n2;
                resultShow.setText("Result : "+sub);

            }
        }
        catch (Exception e){

            Toast.makeText(MainActivity.this,"Number One or Number Two is blank.", Toast.LENGTH_SHORT).show();
        }


    }
}
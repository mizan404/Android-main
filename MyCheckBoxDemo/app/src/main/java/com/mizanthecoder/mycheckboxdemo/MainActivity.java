package com.mizanthecoder.mycheckboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // for checkBox =====================================================================================
private CheckBox milkChockBox, sugerChockBox,teaChockBox;
private Button checkBoxButton;
private TextView checkBoxResult;
    // for RadioButton =====================================================================================

    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button radioButton;
    private TextView radioTextShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // for checkBox =====================================================================================
        milkChockBox = (CheckBox) findViewById(R.id.checkboxMilk);
        sugerChockBox = (CheckBox) findViewById(R.id.checkboxSugar);
        teaChockBox = (CheckBox) findViewById(R.id.checkboxTea);
        checkBoxButton = (Button) findViewById(R.id.checkboxButton);
        checkBoxResult = (TextView) findViewById(R.id.checkboxResult);
        // for CheckBox =====================================================================================
        checkBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if (milkChockBox.isChecked()){
                    String value = milkChockBox.getText().toString();
                    stringBuilder.append(value+" is added to chart."+"\n");
                }   if (sugerChockBox.isChecked()){
                    String value = sugerChockBox.getText().toString();
                    stringBuilder.append(value+" is added to chart."+"\n");
                }   if (teaChockBox.isChecked()){
                    String value = teaChockBox.getText().toString();
                    stringBuilder.append(value+" is added to chart."+"\n");
                }
                checkBoxResult.setText(stringBuilder);
            }
        });
        // for RadioButton =====================================================================================

radioGroup= (RadioGroup) findViewById(R.id.genderId);
radioButton = (Button) findViewById(R.id.genderButtonId);
radioTextShow = (TextView) findViewById(R.id.genderResultId);

radioButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
int selectedId  = radioGroup.getCheckedRadioButtonId();
genderButton = (RadioButton) findViewById(selectedId);
String value = genderButton.getText().toString();
        radioTextShow.setText("You have selected : "+value);


    }
});

    }
}
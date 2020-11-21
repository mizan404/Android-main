package com.mizanthecoder.myintendactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.secondPageViewId);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            String value = bundle.getString("tag");
            textView.setText(value);
        }

    }
}
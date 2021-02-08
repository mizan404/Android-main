package com.mizanthecoder.projectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        DBHelper db = new DBHelper(this);
        Button showDataBtn = findViewById(R.id.btnShowData);

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.getStudent();
                Log.v("show", "view all");
            }
        });

    }
    public void viewAll(){


    }
}
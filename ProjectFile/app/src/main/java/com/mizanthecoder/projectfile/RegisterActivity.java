package com.mizanthecoder.projectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mizanthecoder.projectfile.model.Student;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DBHelper db = new DBHelper(this);
        Button btnRegister = findViewById(R.id.btnRegister);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("reg", "registration section");
                db.addUser(new Student(username.getText().toString(), password.getText().toString()));
            }
        });
    }
}
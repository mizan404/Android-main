package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.userapplication.model.User;
import com.example.userapplication.utils.DBHelper;

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
                db.addUser(new User(username.getText().toString(), password.getText().toString()));
            }
        });

    }
}
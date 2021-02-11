package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.userapplication.model.User;
import com.example.userapplication.utils.DBHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnDelete2);

        DBHelper db = new DBHelper(this);
        EditText username = findViewById(R.id.txtEnterId);
        EditText password = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u = db.getUser(username.getText().toString());
                if (u.getPassword().equals(password.getText().toString())) {

                    Intent i = new Intent(LoginActivity.this, Welcome.class);
                    i.putExtra("username", u.getUsername());
                    startActivity(i);
                }
            }
        });


    }
}
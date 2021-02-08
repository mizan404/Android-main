package com.mizanthecoder.projectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mizanthecoder.projectfile.model.Student;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnLogin);

        DBHelper db = new DBHelper(this);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("login", "login section");
                Student u = db.getStudent(username.getText().toString());
                if(u.getPassword().equals(password.getText().toString())){
                    Log.v("success", "Login Successful");
                    Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
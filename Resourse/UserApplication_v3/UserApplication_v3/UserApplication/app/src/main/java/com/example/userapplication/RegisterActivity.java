package com.example.userapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userapplication.model.User;
import com.example.userapplication.utils.DBHelper;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DBHelper db = new DBHelper(this);
        Button btnRegister = findViewById(R.id.btnRegister);
        EditText username = findViewById(R.id.txtEnterId);
        EditText password = findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.addUser(new User(username.getText().toString(), password.getText().toString()));

                username.getText().clear();
                password.getText().clear();

                List<User> users = db.getUser();
                for (User user1 : users
                ) {
                    Log.v("users", user1.getUsername());
                    System.out.println("ID= " + user1.getId());
                    Toast.makeText(RegisterActivity.this, "" + user1.getUsername() + "Id=" + user1.getId(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
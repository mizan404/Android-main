package com.example.userapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userapplication.model.User;
import com.example.userapplication.utils.DBHelper;

import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        DBHelper db = new DBHelper(this);
        Button btnDelete = findViewById(R.id.btnDelete);
        EditText enterId = findViewById(R.id.txtEnterId);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DeleteActivity.this).setTitle("Are you want to delete this").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        db.deleteUser (Integer.parseInt(enterId.getText().toString().trim()));

                        List<User> users=db.getUser();
                        for (User user1:users
                        ) {
                            Log.v("users", user1.getUsername());
                            System.out.println("ID= "+user1.getId());
                        }
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DeleteActivity.this, "Item Delete Cancel", Toast.LENGTH_SHORT).show();

                        List<User> users=db.getUser();
                        for (User user1:users
                        ) {
                            Log.v("users", user1.getUsername());
                            System.out.println("ID= "+user1.getId());
                            Toast.makeText(DeleteActivity.this, ""+user1.getUsername()+"Id="+user1.getId(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();



            }
        });
    }
}
package com.mizanthecoder.myalertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button;
private AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.exitButtonId);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
alertDialog = new AlertDialog.Builder(MainActivity.this);

// for setting alert tittle.
        alertDialog.setTitle(R.string.alert_tittle);
        // for setting alert message.
        alertDialog.setMessage("let's change.");
        //for setting alert icon.
        alertDialog.setIcon(R.drawable.right);
        // for setting alert positive option.
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
// exit
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked No Button", Toast.LENGTH_SHORT).show();
            }
        }); alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You clicked Cancel Button", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialogView = alertDialog.create();
        alertDialogView.show();
    }
}
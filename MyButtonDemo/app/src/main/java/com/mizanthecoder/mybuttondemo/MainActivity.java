package com.mizanthecoder.mybuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    int count = 0;
private Button loginButton;
private TextView loginView;
private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.buttonLoginId);
        logoutButton = (Button) findViewById(R.id.buttonLogoutId);

        loginView = (TextView) findViewById(R.id.textId);
//==========================================================================
        // 1 way to declare OnClickListener.
//==========================================================================
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                count++;
////                loginView.setText("Login Button is clicked..."+count+" times");
//                loginView.setText("Login Button is clicked...");
//
//            }
//        });
//logoutButton.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        loginView.setText("Logout Button is clicked...");
//    }
//});
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
//         2 way to declare is implement OnClickListen interface.==============================
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
        loginButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);
    }
// Second way worked here.
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonLoginId){
            loginView.setText("Login Button is clicked..");
        }
if (v.getId()==R.id.buttonLogoutId){

    loginView.setText("Logout Button is clicked..");

}
    }
}
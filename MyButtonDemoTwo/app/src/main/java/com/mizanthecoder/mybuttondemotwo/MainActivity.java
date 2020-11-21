package com.mizanthecoder.mybuttondemotwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Third Way to use Listener is Inner Class and implement OnClickListener.
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

private Button loginButton, logoutButton, loginButton2, logoutButton2;
private TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton= (Button) findViewById(R.id.loginButton);
        logoutButton= (Button) findViewById(R.id.logoutButton);
        textView = (TextView) findViewById(R.id.textView);

        //for 4th way ... to use Listener.
        loginButton2= (Button) findViewById(R.id.loginButton2);
        logoutButton2= (Button) findViewById(R.id.logoutButton2);
        textView2 = (TextView) findViewById(R.id.textView2);

        AnyNameCanTakeAsInnerClass anctaic = new AnyNameCanTakeAsInnerClass();

    loginButton.setOnClickListener(anctaic);
    logoutButton.setOnClickListener(anctaic);
    }
    class AnyNameCanTakeAsInnerClass implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.loginButton){
                textView.setText("Zareen Button is clicked..");

            }if (v.getId()==R.id.logoutButton){
                textView.setText("Ramin Button is clicked..");

            }
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // 4th way to use Listener by method create and calling with Toast
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void showMessage(View v){
if (v.getId()==R.id.loginButton2){
    Toast.makeText(MainActivity.this,"Zareen is older sister.",Toast.LENGTH_SHORT).show();
    Log.v("tag","Zareen is older sister.");

//    textView2.setText("Login Button is clicked for second time");
}if (v.getId()==R.id.logoutButton2){
// Can change the position of the Toast message location where it shows.

            Toast toast = Toast.makeText(MainActivity.this,"Ramin is younger sister.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP,0,0);
            toast.show();

//    textView2.setText("Logout Button is clicked for second time");
}
    }
}
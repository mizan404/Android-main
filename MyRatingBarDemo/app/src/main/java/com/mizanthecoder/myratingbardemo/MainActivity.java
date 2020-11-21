package com.mizanthecoder.myratingbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private RatingBar ratingBar;
private TextView textView;
// For SeekBar
    private SeekBar seekBar;
    private TextView seekBarText;
    // For SwichBar
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar = (RatingBar) findViewById(R.id.ratingBarId);
        textView = (TextView) findViewById(R.id.ratingText);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText("Values : "+ rating);
            }
        });
        // For Seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        seekBarText = (TextView) findViewById(R.id.seekBarText);
        seekBarText.setText("Valume : "+seekBar.getProgress()+"/"+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarText.setText("Valume : "+progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
// for SwichBar
        aSwitch = (Switch) findViewById(R.id.swichId);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
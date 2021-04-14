package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiaozhuan();
    }
    public void tiaozhuan(){
        final Intent intent=new Intent(MainActivity.this, OL_statusActivity.class);
        Timer timer=new Timer();

        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,3000);
    }
}
package com.mizan.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service implements Runnable{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Log.v("StartService", "This is service method!!!!!!");

        for (int i = 0; i < 100; i++) {
            Log.v("loop", "this is a service loop " + i);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {

    }
}

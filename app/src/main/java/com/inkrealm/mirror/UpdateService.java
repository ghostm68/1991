package com.inkrealm.mirror;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class UpdateService extends Service {

    private static final String TAG = "UpdateService";
    private static final long UPDATE_INTERVAL = TimeUnit.MINUTES.toMillis(5); // 5 minutes
    private Handler handler;
    private Runnable updateRunnable;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        setupUpdateTimer();
        Log.d(TAG, "UpdateService created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "UpdateService started");
        startUpdateTimer();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopUpdateTimer();
        Log.d(TAG, "UpdateService destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void setupUpdateTimer() {
        updateRunnable = new Runnable() {
            @Override
            public void run() {
                checkForUpdates();
                handler.postDelayed(this, UPDATE_INTERVAL);
            }
        };
    }

    private void startUpdateTimer() {
        if (handler != null && updateRunnable != null) {
            handler.post(updateRunnable);
        }
    }

    private void stopUpdateTimer() {
        if (handler != null && updateRunnable != null) {
            handler.removeCallbacks(updateRunnable);
        }
    }

    private void checkForUpdates() {
        // Broadcast update request to MainActivity if it's running
        Intent updateIntent = new Intent("com.inkrealm.mirror.UPDATE_CONTENT");
        sendBroadcast(updateIntent);
        
        Log.d(TAG, "Update check triggered");
    }
}
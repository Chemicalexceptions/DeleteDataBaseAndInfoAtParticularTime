package com.example.deletedatabaseandinfoatparticulartime.misc;

import android.app.Application;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.deletedatabaseandinfoatparticulartime.R;
import com.example.deletedatabaseandinfoatparticulartime.util.AlarmUtil;
import com.example.deletedatabaseandinfoatparticulartime.util.NotificationUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("Applic","Called");

        //this is for auto deletion of code
        AlarmUtil.setAlarm(getApplicationContext());
        NotificationUtil.createNotificationChannel(getApplicationContext(), NotificationCompat.PRIORITY_HIGH,true,getString(R.string.app_name),"App Notification Channel");

    }
}

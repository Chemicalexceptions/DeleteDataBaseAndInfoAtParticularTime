package com.example.deletedatabaseandinfoatparticulartime.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.deletedatabaseandinfoatparticulartime.util.AlarmUtil;
import com.example.deletedatabaseandinfoatparticulartime.util.NotificationUtil;

public class OnBootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("OnBoot","--> Called");
        //Toast.makeText(context, "On Boot has been called", Toast.LENGTH_SHORT).show();

        //for checking it is working or not
        NotificationUtil.createNotification(context,"Boot Completed","Boot has been completed","");

        //Alarm for deleting all data from device on a specific time
        AlarmUtil.setAlarm(context);


    }
}

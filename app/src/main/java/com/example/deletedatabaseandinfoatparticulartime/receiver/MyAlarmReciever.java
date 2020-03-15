package com.example.deletedatabaseandinfoatparticulartime.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.deletedatabaseandinfoatparticulartime.util.InternalDataUtil;

public class MyAlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("Alarm_custom","Alarm has been called");

        //Deleting all data from the phone including database and shared prefernces everything
        InternalDataUtil.deleteAllInternalData(context);

    }
}

package com.example.deletedatabaseandinfoatparticulartime.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.deletedatabaseandinfoatparticulartime.misc.RequestCodes;
import com.example.deletedatabaseandinfoatparticulartime.receiver.MyAlarmReciever;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlarmUtil {

   public static void setAlarm(Context context){

        Log.e("Alarm_manager","Alarm has been set");

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyAlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, RequestCodes.ALARM_DELETE_ALL_DATA,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar afterDate = Calendar.getInstance();
        afterDate.set(2020,Calendar.OCTOBER,1,00,00,0);

        Calendar beforeDate = Calendar.getInstance();
        beforeDate.set(2020,Calendar.APRIL,1,00,00,0);


        long currentTime = System.currentTimeMillis();
        long startTime = beforeDate.getTimeInMillis();
        long endTime = afterDate.getTimeInMillis();

//       //here if the time exceeds from the given time the alarm will get canceled
//       Log.e("start_time", String.valueOf(currentTime>startTime));
//       Log.e("end_time", String.valueOf(endTime>currentTime));

       SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
       Date currentDate = new Date(currentTime);
       Date startDate = new Date(startTime);
       Date endDate = new Date(endTime);
       Log.e("current_date", sdf.format(currentDate));
       Log.e("start_date", String.valueOf(startDate));
       Log.e("end_date", String.valueOf(endDate));

       if(DateUtil.checkBetween(currentDate,startDate,endDate)){

            //if it dont falls in range and the if there is any alarm set it will be automatically cancled
            alarmManager.cancel(pendingIntent);

            //Deleting all Data if present before and after a specific range of date
            //InternalDataUtil.deleteAllInternalData(context);
            InternalDataUtil.deleteAllInternalData(context);

            Log.e("Alarm_custom","Alarm has been cancelled time because the time dont falls in range and all data has been deleted");

        }
        else{

            //This is for if the date falls in range between 2 dates then after the end date the data will automatically deleted
            //this is for if phone goes in idle mode  i.e doze mode
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,endTime,pendingIntent);
                Log.e("Alarm_manager","Alarm has been set android M and above");

            }
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                alarmManager.setExact(AlarmManager.RTC_WAKEUP,endTime,pendingIntent);
                Log.e("Alarm_manager","Alarm has been set android Kitkat and above");
            }

        }

    }


}

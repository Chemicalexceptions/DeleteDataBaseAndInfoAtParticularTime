package com.example.deletedatabaseandinfoatparticulartime.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.deletedatabaseandinfoatparticulartime.R;

public class NotificationUtil {

    public static void createNotificationChannel(Context context,int importance, Boolean showbadge , String name , String description){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String channelId = context.getPackageName()+"-"+name;
            NotificationChannel notificationChannel = new NotificationChannel(channelId,name,importance);
            notificationChannel.setDescription(description);
            notificationChannel.setShowBadge(showbadge);

            //Notification manager
           NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
           notificationManager.createNotificationChannel(notificationChannel);

        }

    }

    public static void createNotification(Context context, String title ,String message,String bigText){

        String channelId = context.getPackageName()+"-"+context.getString(R.string.app_name);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(1001,builder.build());

    }



}

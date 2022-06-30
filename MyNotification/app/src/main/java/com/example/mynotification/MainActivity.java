package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager manager;
Notification notification;
PendingIntent pi;
Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificatonChannel();
        myintent=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,12,myintent,PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void createNotificatonChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel cn=new NotificationChannel("MyChannel",
                    "Notification",NotificationManager.IMPORTANCE_DEFAULT);
            cn.setLightColor(Color.BLUE);
            manager.createNotificationChannel(cn);

        }
    }

    public void showMyNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyChannel");
        builder.setContentTitle("My Own Notification");
        builder.setContentText("This is our own notification build by US");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setPriority(1);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_notifications_24,"reply",pi);
        notification= builder.build();
        manager.notify(12, notification);

    }
}
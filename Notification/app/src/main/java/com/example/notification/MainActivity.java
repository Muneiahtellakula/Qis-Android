package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager nm;
PendingIntent pi;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,53,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
   createNotificationChannel();

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel("channel","mychannel",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nm.createNotificationChannel(nc);
        }
    }

    public void showNotificaton(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"channel");
        builder.setContentTitle("My Notificaton");
        builder.setContentText("This is our Notification ");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setContentIntent(pi);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        nm.notify(53,builder.build());

    }
}
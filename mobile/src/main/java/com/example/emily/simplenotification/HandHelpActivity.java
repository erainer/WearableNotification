package com.example.emily.simplenotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HandHelpActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "com.example.emily.simplenotification";
    public static final int NOTIFY_ID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_help);
        Button mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplication())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Sample Notification")
                        .setContentText("This is a notification.")
                        .setAutoCancel(true)
                        .setSubText("Tap to View")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setChannelId(CHANNEL_ID)
                        .extend(
                                new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true));


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());

                int notificationId = 1;
                Notification notification = builder.build();
                NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mgr.notify(NOTIFY_ID, notification);
                notificationManager.notify(notificationId, notification);
            }

        });
    }

}
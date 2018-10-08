package com.example.emily.simplenotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class WearActivity extends AppCompatActivity {
    public static final int NOTIFY_ID = 1001;
    public static final String CHANNEL_ID = "com.emily.ANDROID";
    private TextView mTextView;
    private NotificationManagerCompat notificationManager;
    private NotificationCompat.Action action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        showNotification();
    }

    public void showNotification(){
        Intent intent = new Intent(this, Result.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFY_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Sample Notification")
                .setContentText("This is a notification.")
                .setAutoCancel(true)
                .setSubText("Tap to View")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setChannelId(CHANNEL_ID)
                .setContentIntent(pendingIntent);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("This is a big notification");
        bigTextStyle.bigText(getResources().getString(R.string.longMsg));
        builder.setStyle(bigTextStyle);

        Intent notificaitonResult = new Intent(this, Result.class);
        notificaitonResult.putExtra("notifiyID", NOTIFY_ID);

        builder.setVisibility(Notification.VISIBILITY_PUBLIC);

        Notification notification = builder.build();
        NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ID, notification);
    }
}

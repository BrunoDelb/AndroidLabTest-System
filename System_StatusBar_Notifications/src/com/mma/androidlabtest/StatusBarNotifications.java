package com.mma.androidlabtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatusBarNotifications extends Activity {

    private NotificationManager notificationManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Button btnNotify = (Button)findViewById(R.id.btn_notify);
        btnNotify.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(getApplicationContext(), StatusBarNotifications.class);
                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                final Notification notification = new Notification(
                        R.drawable.app,       
                        "Text of the notification !",                        
                        System.currentTimeMillis()); 
                notification.setLatestEventInfo(
                        getApplicationContext(),                        
                        "Title of the notification", 
                        "Text of the notification",                        
                        contentIntent);              
                notification.defaults = Notification.DEFAULT_SOUND;
                notificationManager.notify(R.layout.main, notification);
            }
        });
    }
}

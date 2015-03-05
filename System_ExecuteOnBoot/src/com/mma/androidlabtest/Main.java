package com.mma.androidlabtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Main extends BroadcastReceiver {

	public void onReceive(Context context, Intent intent) {
		Intent intentNotification = new Intent(context, Main.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intentNotification, 0);
		Notification notification = new Notification(R.drawable.app, "Executed at boot", System.currentTimeMillis());
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		notification.setLatestEventInfo(context, "Information", "Executed at boot !", contentIntent);
		NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify (1, notification);		
	}
}

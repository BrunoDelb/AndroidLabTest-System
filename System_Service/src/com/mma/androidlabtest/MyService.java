package com.mma.androidlabtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

class MyService extends Service {

	public IBinder onBind(Intent intent) {
		return null;
	}
	
	public void onCreate() {
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "onStartCommand called", 5000).show();
		return START_STICKY;
	}
	
	public void onStart(Intent intent, int startid) {
		Toast.makeText(getApplicationContext(), "onStart called", 5000).show();
	}
	
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "onDestroy called", 5000).show();
	}
}

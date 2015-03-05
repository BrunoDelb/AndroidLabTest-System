package com.mma.androidlabtest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;

public class Main extends Activity {

    EditText etOutput;
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etOutput = (EditText)findViewById (R.id.et_output);
    }
    
    protected void onStart() {
    	this.registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    	super.onStart();
    }
    
    protected void onStop() {
    	this.unregisterReceiver(receiver);
    	super.onStop();
    }
    
    private BroadcastReceiver receiver = new BroadcastReceiver() {

		public void onReceive(Context context, Intent intent) {
			etOutput.setText("Level battery: " + intent.getIntExtra("level", 0));
		}
    };
}

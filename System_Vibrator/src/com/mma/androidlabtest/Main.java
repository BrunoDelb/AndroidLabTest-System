package com.mma.androidlabtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;

public class Main extends Activity {
    
	Vibrator vibrator;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(500);
    }
}

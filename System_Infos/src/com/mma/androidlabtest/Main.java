package com.mma.androidlabtest;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.EditText;

public class Main extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText etOutput = (EditText)findViewById (R.id.et_output);
        etOutput.setText (
			"Android ID: " + Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID) +
			"ADB: " + Settings.System.getString(getContentResolver(), Settings.System.ADB_ENABLED) + 
			"Bluetooth: " + Settings.System.getString(getContentResolver(), Settings.System.BLUETOOTH_ON) +
			"Airplane: " + Settings.System.getString(getContentResolver(), Settings.System.AIRPLANE_MODE_ON) +
			"Brightness: " + Settings.System.getString(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS)
		);
    }
}

package com.mma.android;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class Main extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tvDevice = (TextView)findViewById (R.id.tv_device);
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Service.TELEPHONY_SERVICE);
        if(telephonyManager.getDeviceId().equals("000000000000000")){
        	tvDevice.setText("Emulator");
        } else {
        	tvDevice.setText("Real device");
        }
    }
}

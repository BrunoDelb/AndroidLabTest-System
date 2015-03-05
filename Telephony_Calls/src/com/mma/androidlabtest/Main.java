package com.mma.androidlabtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
			 
    TextView tv_log = null;
    TelephonyManager telephonyManager = null;
    MyPhoneStateListener myPhoneStateListener = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv_log = (TextView)findViewById(R.id.tv_log);
        Button btnCall = (Button)findViewById (R.id.btnCall);
        btnCall.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010101"));
		        startActivity(intent);
			}
		});
        telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        myPhoneStateListener = new MyPhoneStateListener();
    }
    
    public void onResume() {
		super.onResume();
		telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }
    
    public void onPause() {
		super.onPause();
		telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_NONE);
    }
    
    public class MyPhoneStateListener extends PhoneStateListener {

		public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch(state) {
                case TelephonyManager.CALL_STATE_IDLE:
                	tv_log.setText("Call state idle : " + incomingNumber);
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                	tv_log.setText("Call state ringing : " + incomingNumber);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                	tv_log.setText("Call state Offhook : " + incomingNumber);
                    break;
                default:
                	tv_log.setText("Call state other : " + incomingNumber);
                    break;
            }
        }
    }
}

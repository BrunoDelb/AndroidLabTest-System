package com.mma.androidlabtest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
    
	EditText et_output;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et_output = (EditText)findViewById (R.id.et_output);
		Receiver receiver = new Receiver();
		registerReceiver(receiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }
    
	public class Receiver 
		extends BroadcastReceiver {
	
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "SMS received", Toast.LENGTH_SHORT).show();
			if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
				Bundle bundle = intent.getExtras();
				if(bundle != null){
					Object[] pdus = (Object[]) bundle.get("pdus");
					SmsMessage[] messages = new SmsMessage[pdus.length];
					for(int i = 0; i<pdus.length; i++)
						messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
					for(SmsMessage message : messages){
						Log.i("",message.getOriginatingAddress()+"::"+message.getMessageBody());
					}	
				}											
			}
		}
	}
}

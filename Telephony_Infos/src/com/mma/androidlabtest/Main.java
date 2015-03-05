package com.mma.androidlabtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.EditText;

public class Main extends Activity {

	EditText etOutput = null;
	TelephonyManager telephonyManager = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		etOutput = (EditText)findViewById(R.id.et_output);
		telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String text = "";
		text += "Network country: " + telephonyManager.getNetworkCountryIso() + "\r\n";
		text += "Network operator id: " + telephonyManager.getNetworkOperator() + "\r\n";
		text += "IMEI number: " + telephonyManager.getDeviceId() + "\r\n";
		text += "Subscriber id: " + telephonyManager.getDeviceId() + "\r\n";
		text += "Network country ISO: " + telephonyManager.getNetworkCountryIso() + "\r\n";
		text += "SIM country ISO: " + telephonyManager.getSimCountryIso() + "\r\n";
		text += "Software version: " + telephonyManager.getDeviceSoftwareVersion() + "\r\n";
		text += "Voice mail number: " + telephonyManager.getVoiceMailNumber() + "\r\n";
		text += "SIM card operator code: " + telephonyManager.getSimOperator() + "\r\n";
		text += "SIM card operator name: " + telephonyManager.getSimOperatorName() + "\r\n";
		text += "SIM card serial number: " + telephonyManager.getSimSerialNumber() + "\r\n";
		switch (telephonyManager.getPhoneType()) {
			case TelephonyManager.PHONE_TYPE_CDMA:
				text += "Phone type CDMA\r\n";
				break;
			case TelephonyManager.PHONE_TYPE_GSM:
				text += "Phone type GSM\r\n";
				break;
			case TelephonyManager.PHONE_TYPE_NONE:
				text += "No phone type\r\n";
				break;
		}
		if(telephonyManager.isNetworkRoaming())
			text += "Roaming\r\n";
		else
			text += "No roaming\r\n";
		switch(telephonyManager.getSimState()) {
			case TelephonyManager.SIM_STATE_ABSENT:
				text += "No SIM card\r\n";
				break;
			case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
				text += "Network locked\r\n";
				break;
			case TelephonyManager.SIM_STATE_PIN_REQUIRED:
				text += "PIN required\r\n";
				break;
			case TelephonyManager.SIM_STATE_PUK_REQUIRED:
				text += "PUK required\r\n";
				break;
			case TelephonyManager.SIM_STATE_READY:
				text += "SIM card ready\r\n";
				break;
			case TelephonyManager.SIM_STATE_UNKNOWN:
				break;
		}
		text += "Network name: " + telephonyManager.getNetworkOperatorName() + "\r\n";
		switch (telephonyManager.getNetworkType()) {
			case TelephonyManager.NETWORK_TYPE_1xRTT:
				text += "Network type 1xRTT\r\n";
				break;
			case TelephonyManager.NETWORK_TYPE_CDMA:
				text += "Network type CDMA\r\n";
				break;
			case TelephonyManager.NETWORK_TYPE_EDGE:
				text += "Network type Edge\r\n";
				break;
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
				text += "Network type EVDO 0\r\n";
				break;
		}
		etOutput.setText (text);
	}
}

package com.mma.androidlabtest;

import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
    
	WifiManager wifiManager;
	TextView et_ssid;
	TextView et_status;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnScan = (Button)findViewById (R.id.btnScan);
        btnScan.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				wifiManager.startScan();
			}
		});
        Button btnEnable = (Button)this.findViewById(R.id.btnActivate);
        btnEnable.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(wifiManager.isWifiEnabled()) {
					wifiManager.setWifiEnabled(false);
					et_ssid.setText("Disabled");
				} else {
					wifiManager.setWifiEnabled(true);
					et_ssid.setText("Enabled");
				}
			}
		});
        et_ssid = (TextView)findViewById (R.id.et_ssid);
        et_status = (TextView)findViewById (R.id.et_status);
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        Receiver receiver = new Receiver();
        registerReceiver(receiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        registerReceiver(receiver,new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

	public class Receiver 
		extends BroadcastReceiver {

		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
				List<ScanResult> results = wifiManager.getScanResults();
				String ssid = "";
				for (int i = 0; i < results.size(); i++) {
					ssid += results.get(i).SSID + ", ";
				}
				et_ssid.setText(ssid);
			}
		}
	}
}

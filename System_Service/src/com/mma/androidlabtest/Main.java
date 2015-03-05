package com.mma.androidlabtest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

	Intent intent;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		intent = new Intent(this, MyService.class);
		
		Button btnStart = (Button) this.findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				startService(intent);
			}
		});
		
		Button btnStop = (Button) this.findViewById(R.id.btnStop);
		btnStop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				stopService(intent);
			}
		});
	}
}

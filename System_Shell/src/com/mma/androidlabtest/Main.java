package com.mma.androidlabtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	
	EditText etCommand;
	TextView tvOutput;
	Button btnExecute;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etCommand = (EditText)findViewById(R.id.et_command);
        tvOutput = (TextView)findViewById(R.id.tv_output);
        btnExecute = (Button)findViewById(R.id.btn_execute);
        btnExecute.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String buffer = "";
				try {			
					Process process = Runtime.getRuntime().exec(etCommand.getText().toString());
					String data;
					InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					while ((data = bufferedReader.readLine())!= null)
						buffer += "\n" + data;
					bufferedReader.close();
					inputStreamReader = new InputStreamReader(process.getErrorStream());
					bufferedReader = new BufferedReader(inputStreamReader);
					while((data = bufferedReader.readLine()) != null)
						buffer += "\n" + data;
					bufferedReader.close();				
				} catch(Exception e) {
					Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
				}
				tvOutput.setText(buffer);
				etCommand.setText("");					
			}
		});
    }
}

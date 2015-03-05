package com.mma.androidlabtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class Main extends Activity {
    
	Thread thread;
	Handler handler;
	final static int HANDLER_RUNNING = 0;
	final static int HANDLER_END = 1;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        handler = new Handler(){
    		public void handleMessage(Message message) { 
    			switch(message.what) {
					case HANDLER_RUNNING:
						String loop = (String)message.obj;
						break;
					case HANDLER_END:
						Toast.makeText (Main.this, "Thread terminé", 5000).show();
						break;
    			}
    		}
        };
        thread = new Thread() {
        	public void run() {
        		try {
		        	for (int i = 0; i < 10; i++) {
		        		handler.sendMessage (handler.obtainMessage (HANDLER_RUNNING, "" + i));
						Thread.sleep(1000);
		            }		        	
    			} catch (InterruptedException e){    				
    			}
    			handler.sendEmptyMessage(HANDLER_END);
        	};
        };
        thread.start();
    }
}

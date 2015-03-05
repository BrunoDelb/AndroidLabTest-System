package com.mma.androidlabtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	final static String outputPath = Environment.getExternalStorageDirectory() + "/download/";

	public void onCreate (Bundle bundle) {
		super.onCreate (bundle);
		setContentView (R.layout.main);
		Button btnDownloadAndInstall = (Button)findViewById (R.id.btnDownloadAndInstall);
		btnDownloadAndInstall.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				downloadAPK (
						"http://www.mediamobileagency.fr/dl/apps/Media_TextToSpeech.apk", 
						Environment.getExternalStorageDirectory() + "/download/Media_TextToSpeech.apk"
					);
					launchAPK (Environment.getExternalStorageDirectory() + "/download/Media_TextToSpeech.apk");
			}
		});
	}
	
	private void downloadAPK (String theUrl, String path) {
		try {
			URL url = new URL(theUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.connect();
			File file = new File(path);
			file.mkdirs();
			File outputFile = new File(path);
			FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
			InputStream inputStream = httpURLConnection.getInputStream();
			byte[] buffer = new byte[1024];
			int len1 = 0;
			while ((len1 = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, len1);
			}
			fileOutputStream.close();
			inputStream.close();
		} catch (IOException e) {
		}
	}
	
	private void launchAPK (String path) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
		startActivity(intent);
	}
}

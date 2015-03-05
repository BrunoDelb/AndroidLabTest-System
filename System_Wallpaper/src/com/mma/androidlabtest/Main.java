package com.mma.androidlabtest;
import android.app.Activity;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
	WallpaperManager wallpaperManager;
			 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        wallpaperManager = WallpaperManager.getInstance(this);
        Button btnSetWallpaper = (Button) findViewById(R.id.btn_setwallpaper);
        btnSetWallpaper.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	try {
	                wallpaperManager.setResource(R.drawable.app);
            	} catch (Exception e) {
            	}
            }
        });
    }
}

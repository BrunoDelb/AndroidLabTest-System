package com.mma.androidlabtest;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Main extends PreferenceActivity {
	
	int widgetId;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(RESULT_CANCELED);
        addPreferencesFromResource(R.xml.preferences);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        	widgetId = extras.getInt (AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        if (widgetId == AppWidgetManager.INVALID_APPWIDGET_ID)
        	finish();
        Intent intentResult = new Intent();
        intentResult.putExtra (AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
        setResult (RESULT_OK, intentResult);
    }
    
    protected void onDestroy() {
    	Widget.Update (this, AppWidgetManager.getInstance(this), new int[] {widgetId});
    	super.onDestroy();
    }
}

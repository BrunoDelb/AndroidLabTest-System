package com.mma.androidlabtest;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;

public class Widget extends AppWidgetProvider {
	
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {	
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Update(context, appWidgetManager, appWidgetIds);
	}
	
	public static void Update(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
		String parameter = settings.getString("param", "Helloworld");
		for (int i = 0; i < appWidgetIds.length; i++) {
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
			remoteViews.setTextViewText (R.id.textView, parameter);
			appWidgetManager.updateAppWidget (appWidgetIds[i], remoteViews);
		}
	}
}

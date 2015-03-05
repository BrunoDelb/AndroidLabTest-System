package com.mma.androidlabtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class Main extends Activity {

    static final String EXTRA_KEY = "com.mma.androidlabtest.System_LaunchShortcut";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentReceived = getIntent();
        if (intentReceived.getAction() == Intent.ACTION_CREATE_SHORTCUT) {
            Intent intentShortcut = new Intent(Intent.ACTION_MAIN);
            intentShortcut.setClassName(this, this.getClass().getName());
            intentShortcut.putExtra(EXTRA_KEY, "Android Lab Test - System LaunchShortcut");
            Intent intentResult = new Intent();
            intentResult.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intentShortcut);
            intentResult.putExtra(Intent.EXTRA_SHORTCUT_NAME, "My shortcut");
            Parcelable iconResource = Intent.ShortcutIconResource.fromContext(this,  R.drawable.app);
            intentResult.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
            setResult(RESULT_OK, intentResult);
            finish();
            return;
        }
        setContentView(R.layout.main);
        TextView tvInfo = (TextView)findViewById(R.id.tv_info);
        String info = intentReceived.toString();
        String extra = intentReceived.getStringExtra(EXTRA_KEY);
        tvInfo.setText(info + " " + extra);
    }
}

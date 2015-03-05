package com.mma.androidlabtest;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class Main extends ListActivity {

    public void onCreate (Bundle bundle) {
        super.onCreate (bundle);
        Cursor cursor = getContentResolver().query (Uri.parse("content://sms/inbox"), null, null, null, null);
        startManagingCursor (cursor);
        ListAdapter listAdapter = new SimpleCursorAdapter(
			this, 						// context
			R.layout.main, 				// layout
			cursor, 					// cursor 
			new String[] {"body"}, 		// from
			new int[] {R.id.et_output}	// to
		);
        setListAdapter (listAdapter);
    }
}

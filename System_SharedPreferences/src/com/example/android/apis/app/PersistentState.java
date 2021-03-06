package com.example.android.apis.app;

import com.example.android.apis.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Simple example of using persistent preferences to retain a screen's state.
 * <p>This can be used as an alternative to the normal
 * <code>onSaveInstanceState()</code> mechanism, if you
 * wish the state to persist even after an activity is finished.</p>
 *
 * <p>Note that using this approach requires more care, since you are sharing
 * the persistent state potentially across multiple instances of the activity.
 * In particular, if you allow a new instance of the activity to be launched
 * directly on top of the existing instance, the state can get out of sync
 * because the new instance is resumed before the old one is paused.</p>
 *
 * <p>For any persistent state that is not simplistic, a content
 * provider is often a better choice.</p>
 *
 * <p>In this example we are currently saving and restoring the state of the
 * top text editor, but not of the bottom text editor.  You can see the difference
 * by editing the two text fields, then going back from the activity and
 * starting it again.</p>
 *
 * <h4>Demo</h4>
 * App/Activity/Save &amp; Restore State
 *
 * <h4>Source files</h4>
 * <table class="LinkTable">
 *         <tr>
 *             <td class="LinkColumn">src/com.example.android.apis/app/PersistentState.java</td>
 *             <td class="DescrColumn">The Save/Restore Screen implementation</td>
 *         </tr>
 *         <tr>
 *             <td class="LinkColumn">/res/any/layout/save_restore_state.xml</td>
 *             <td class="DescrColumn">Defines contents of the screen</td>
 *         </tr>
 * </table>
 *
 */
public class PersistentState extends Activity {

    private EditText mSaved;
	
    /**
     * Initialization of the Activity after it is first created.  Here we use
     * {@link android.app.Activity#setContentView setContentView()} to set up
     * the Activity's content, and retrieve the EditText widget whose state we
     * will persistent.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_restore_state);
        ((TextView)findViewById(R.id.msg)).setText(R.string.persistent_msg);
        mSaved = (EditText)findViewById(R.id.saved);
    }

    /**
     * Upon being resumed we can retrieve the current state.  This allows us
     * to update the state if it was changed at any time while paused.
     */
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(0); 
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            mSaved.setText(restoredText, TextView.BufferType.EDITABLE);
            int selectionStart = prefs.getInt("selection-start", -1);
            int selectionEnd = prefs.getInt("selection-end", -1);
            if (selectionStart != -1 && selectionEnd != -1) {
                mSaved.setSelection(selectionStart, selectionEnd);
            }
        }
    }

    /**
     * Any time we are paused we need to save away the current state, so it
     * will be restored correctly when we are resumed.
     */
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putString("text", mSaved.getText().toString());
        editor.putInt("selection-start", mSaved.getSelectionStart());
        editor.putInt("selection-end", mSaved.getSelectionEnd());
        editor.commit();
    }
}

package com.example.RemindConnected;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;

public class VibratorActivity extends Activity {
    private Vibrator vibrator;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {1000, 2000, 1000, 2000};
        vibrator.vibrate(pattern, 2);
    }

    @Override
    protected void onStop() {
        if (vibrator != null) vibrator.cancel();
        super.onStop();
    }
}

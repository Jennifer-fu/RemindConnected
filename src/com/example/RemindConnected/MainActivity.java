package com.example.RemindConnected;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.RemindConnected.MESSAGE";
    private Vibrator vibrator;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//        long[] pattern = {1000, 2000, 1000, 2000};
//        vibrator.vibrate(pattern, 2);

        /*try {
            Process process = Runtime.getRuntime().exec("logcat -v time -b radio");
            InputStream inputStream = process.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                Log.i("test",line);
            }
        } catch (IOException e) {
            Log.e("exception",e.getMessage());
        }*/

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editableText = (EditText) findViewById(R.id.editable_text);
        String message = editableText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettings() {
        Log.i("action_bar","open settings");
    }

    private void openSearch() {
        Log.i("action_bar","open search");
    }

    @Override
    protected void onStop() {
        if (vibrator != null) vibrator.cancel();
        super.onStop();
    }
}

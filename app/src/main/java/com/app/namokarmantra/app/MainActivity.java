package com.app.namokarmantra.app;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.widget.Switch;
import android.widget.TextView;

import com.infojunc.namokarmantra.R;


public class MainActivity extends ActionBarActivity {

    TextView myText;
    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText =(TextView)findViewById(R.id.textView);
        mySwitch = (Switch)findViewById(R.id.switch1);

        myText.setText("Turn the app on/off");
        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.HOUR_OF_DAY,18);

        Intent i = new Intent(this, AlarmSound.class);
        PendingIntent pending = PendingIntent.getActivity(this,1235, i, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, cl.getTimeInMillis(),pending);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

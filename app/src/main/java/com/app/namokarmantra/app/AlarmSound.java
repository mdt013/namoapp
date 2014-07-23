package com.app.namokarmantra.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.infojunc.namokarmantra.R;

import java.io.IOException;

/**
 * Created by Mudit on 7/23/2014.
 */
public class AlarmSound extends Activity{
    private MediaPlayer player;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.alarmview);

        Button stop = (Button) findViewById(R.id.button);
        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.ic_launcher_web);
        stop.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                player.stop();

                return false;
            }
        });

        play(this, getAlarmSound());
    }

    private void play(Context context, Uri alert) {
        player = new MediaPlayer();
        try {
            player.setDataSource(context, alert);
            final AudioManager audio = (AudioManager) context
                    .getSystemService(Context.AUDIO_SERVICE);
            if (audio.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
                player.setAudioStreamType(AudioManager.STREAM_ALARM);
                player.prepare();
                player.start();
            }
        } catch (IOException e) {
            Log.e("Error....","Check code...");
        }
    }

    private Uri getAlarmSound() {
        Uri alertSound = Uri.parse("android.resource://com.app.namokarmantra.app/"+R.raw.namokar);
//        if (alertSound == null) {
//            alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            if (alertSound == null) {
//                alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
//            }
//        }
        return alertSound;
    }

}

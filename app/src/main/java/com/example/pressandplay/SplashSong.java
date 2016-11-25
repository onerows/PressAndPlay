package com.example.pressandplay;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class SplashSong extends Activity {

    MediaPlayer my_mediaPlayer;

    //This is a comment for Github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_song);

        my_mediaPlayer = MediaPlayer.create(this,R.raw.susanvega);
        my_mediaPlayer.start();


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(10200);
                   // Intent openMain = new Intent(SplashSong.this, MainActivity.class);
                   // startActivity(openMain);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally{
                    //announce our (Explicit) intent to open the main activity and pass it to startActivity
                    //the Intent openMain is basically a data structure
                    //holding an abstract description of the operation to be performed - MAINACTIVITY
                    //	Intent openMain = new Intent("com.example.pressandplay.MAINACTIVITY");
                    Intent openMain = new Intent(SplashSong.this, MainActivity.class);
                    startActivity(openMain);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        my_mediaPlayer.release();
        finish();
    }
}

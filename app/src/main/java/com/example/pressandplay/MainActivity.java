package com.example.pressandplay;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	final String TAG = "PressPlayMain";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button startButton = (Button) findViewById(R.id.trigger);
		
		startButton.setOnClickListener(    //the button is a view - setOnClickListener(View.OnClickListener l)
				                           //Register a callback to be invoked when this view is clicked
				new View.OnClickListener() {  //Interface definition for a callback to be invoked when a view is clicked.
					@Override
					public void onClick(View v) { //the onClick() callback method
						// Called when a view has been clicked
						Thread initBkgdThread = new Thread(new Runnable() {
							public void run() {
								
						play_tune();
								}
							});
						initBkgdThread.start();
						}
					});
		}

	int[] notes ={R.raw.c5,R.raw.a4,R.raw.d4,R.raw.g4};
	int NOTE_DURATION=400;
	MediaPlayer m_mediaPlayer;
	
	private void play_notes() {
		for(int ii=0;ii<4;ii++) {
			if(!paused) {
				if(m_mediaPlayer != null) {m_mediaPlayer.release();}
				m_mediaPlayer = MediaPlayer.create(this, notes[ii%4]);
				m_mediaPlayer.start();
				try{
					Thread.sleep(NOTE_DURATION);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void play_tune() {
		m_mediaPlayer = MediaPlayer.create(this,R.raw.tune);

			if(!paused) {
				if(m_mediaPlayer != null) {
					m_mediaPlayer.release();
				}
				m_mediaPlayer = MediaPlayer.create(this,R.raw.tune);
				m_mediaPlayer.start();
			}
	}
	
	
	
	
	boolean paused = false;
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "MainActivity:onStart()");
	}

	@Override
	protected void onPause() {  //onPause() is where you deal with the user leaving your activity.
		paused=true;
		super.onPause();
		Log.d(TAG, "MainActivity:onPause()");
	}
	
	@Override
	protected void onResume() {//onResume() is where you deal with the activity restarting.
		super.onResume();
		paused=false;
		Log.d(TAG, "MainActivity:onResume()");
		
	}
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "MainActivity:onDestroy()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}

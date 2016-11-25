package com.example.pressandplay;

import java.text.SimpleDateFormat;
import java.util.Date;

//import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class Splash2 extends Activity implements OnKeyListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash2);
		
		
	}
	
	Handler handler = new Handler() {
		  @Override
		  public void handleMessage(Message msg) {
			  Bundle bundle = msg.getData();
				String string = bundle.getString("myKey");
				TextView myTextView = (TextView)findViewById(R.id.MytextView);
				myTextView.setText(string);
		     }
		 };
	public void buttonClick(View view)
    {
		Runnable runnable = new Runnable() {
	        public void run() {
            //	Message msg = handler.obtainMessage();
    		//	Bundle bundle = new Bundle();
    		//	SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
    	    //	String dateString = dateformat.format(new Date());
    		//	bundle.putString("myKey", dateString);
            //  msg.setData(bundle);
           ///  handler.sendMessage(msg);
                 play_mymusic();
                 
	        }
      };


Thread mythread = new Thread(runnable);
	mythread.start();
    }



	MediaPlayer my_mediaPlayer;
	private void play_mymusic() {
		
			if(!paused) {
				if(my_mediaPlayer != null) {my_mediaPlayer.release();}
				my_mediaPlayer = MediaPlayer.create(this,R.raw.susanvega);
				my_mediaPlayer.start();
		}
	}
			boolean paused = false;
			
			@Override
			protected void onPause() {  //onPause() is where you deal with the user leaving your activity.
				paused=true;
				super.onPause();
				finish();
			}
			
			@Override
			protected void onResume() {//onResume() is where you deal with the activity restarting.
				super.onResume();
				paused=false;
				
			}
			
			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				return false;
			}
}

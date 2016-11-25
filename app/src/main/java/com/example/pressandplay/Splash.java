package com.example.pressandplay;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Splash extends Activity {
	final String TAG = "Splash";
	@Override
	protected void onCreate(Bundle kitcatState) {
		// TODO Auto-generated method stub
		super.onCreate(kitcatState);
		setContentView(R.layout.splash);  //show the splash screen in new layout
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					//announce our (Explicit) intent to open the main activity and pass it to startActivity
					//the Intent openMain is basically a data structure
					//holding an abstract description of the operation to be performed - MAINACTIVITY
				//	Intent openMain = new Intent("com.example.pressandplay.MAINACTIVITY");
					Intent om = new Intent(getBaseContext(), Splash2.class);
			        
					startActivity(om);
				   
				}
				
			}
		};
		timer.start();
	}
	
	
	@Override
	  protected void onStart() {
	    super.onStart();
//	    TextView myTextView = (TextView)findViewById(R.id.textView1);	  
	//	myTextView.setBackgroundColor(Color.GREEN);
	    //Log.d(TAG, "Splash: onStart()");
	  }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	//	Log.d(TAG, "Splash: onPause()");
		finish();
	}
	
	@Override
	  protected void onStop() {
	    super.onStop();
	   // Log.d(TAG, "Splash: onStop()");
	  }
	    
	  @Override
	  protected void onDestroy() {
	    super.onDestroy();
	  //  Log.d(TAG, "Splash: onDestroy()");
	  }

}

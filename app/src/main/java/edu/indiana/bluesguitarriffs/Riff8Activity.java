/*Riff8Activity.java
*
*Contains the Java code for the
*Riff 8 Activity in this project
*
*Created by: Alex Totheroh
*Created on: 3/1/15
*Last Modified by: Alex Totheroh
*Last Modified on: 3/6/2015
*Assignment/Project: A290 Android Development Final Project
*Part of: BluesGuitarRiffs, refers to activity_riff8.xml layout file
**/

package edu.indiana.bluesguitarriffs;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Riff8Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_riff8);
		
		// this sets up functionality for the play button, referencing riff1.wav
		// using the MediaPlayer class
		Button play = (Button)this.findViewById(R.id.playbutton);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.riff8);
        play.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                mp.start(); // plays the .wav file
            }
        });
        
        // this sets up an intent to go back to the home screen using the back button
        final Intent goBackIntent = new Intent(Riff8Activity.this, MainActivity.class);
        
        Button goBack = (Button)this.findViewById(R.id.backbutton);
        goBack.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	Riff8Activity.this.startActivity(goBackIntent); // goes back to main screen
            }
        });
        
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.riff8, menu);
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

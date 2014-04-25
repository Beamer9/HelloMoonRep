package com.comsi.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class AudioPlayer {

	
	private MediaPlayer mPlayer;
	private int posInTrack;
	private static final String TAG = "AudioPlayer";
	
	
	public void setPosInTrack(int posInTrack) {
		Log.i(TAG, "setPosInTrack:"+posInTrack);
		this.posInTrack = posInTrack;
	}


	public int getPosInTrack() {
		Log.i(TAG, "getPosInTrack: "+posInTrack);
		return posInTrack;
	}


	public void stop() {
		Log.i(TAG, "AudioPlay: stop   "+posInTrack);
		posInTrack = 0;
		if (mPlayer != null) {
			   Log.i(TAG, "AudioPlay: stop  mPlayer is: "+ mPlayer);
			   mPlayer.release();
			   mPlayer=null;
			   
		}
	}
	
	
	public void play(Context c) {
		Log.i(TAG, "AudioPlay: play  mPlayer is: "+ mPlayer);
		if (mPlayer != null)  {
			   Log.i(TAG, "AudioPlay: play  mPlayer is: "+ posInTrack);

			//stop();
			//Restart the audio track 
			mPlayer.seekTo(posInTrack);
			
		}
			
		else {
			

		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
		}
		
		mPlayer.start();
	}
	
	public void pause() {
		Log.i(TAG, "AudioPlay: pause  mPlayer is: "+ mPlayer);

		if (mPlayer != null) {
			Log.i(TAG, "AudioPlay: pause  mPlayer.getCurrentPosition "+ mPlayer.getCurrentPosition());

			setPosInTrack( mPlayer.getCurrentPosition());
			Log.i(TAG, "AudioPlay: pause  mPlayer is: "+ posInTrack);

			mPlayer.pause();

		}
	}
}

package com.comsi.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private static final String TAG = "HelloMoonFragment";
	private static final String POS_INDEX = "position";
	
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mStopButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Retain the instance of the Fragment even though
		// the Activity and Layout View are destroyed and recreated probably
		// due to change in orientation of the phone.   All instance variables are
		// nicely retained...oops but not if the activity is destroyed because the OS
		// needs to reclaim memory (if you left the app, the process is shutdown, and
		// this could happen).
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			 Bundle savedInstanceState)	{
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener ( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mPlayer.play(getActivity());
				
				
			}
		});
		
		mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPlayer.pause();				
			}
		});
		
		return v;
		
	}
	
	@Override
	public void onDestroy() {
		
		super.onDestroy();
		mPlayer.stop();
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    if (savedInstanceState != null) {
			super.onSaveInstanceState(savedInstanceState);
			Log.i(TAG, "onSaveInstanceState()");
			savedInstanceState.putInt(POS_INDEX, mPlayer.getPosInTrack());
	    }
	}
}
